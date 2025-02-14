/*
 * Copyright (c) 2017. Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.itfsw.query.builder;

import java.util.ArrayList;
import java.util.List;

import com.itfsw.query.builder.config.SqlQueryBuilderConfig;
import com.itfsw.query.builder.support.builder.SqlBuilder;
import com.itfsw.query.builder.support.filter.SqlInjectionAttackFilter;
import com.itfsw.query.builder.support.parser.AbstractSqlRuleParser;
import com.itfsw.query.builder.support.parser.IRuleParser;
import com.itfsw.query.builder.support.parser.sql.BeginsWithRuleParser;
import com.itfsw.query.builder.support.parser.sql.BetweenRuleParser;
import com.itfsw.query.builder.support.parser.sql.ContainsRuleParser;
import com.itfsw.query.builder.support.parser.sql.DefaultGroupParser;
import com.itfsw.query.builder.support.parser.sql.EndsWithRuleParser;
import com.itfsw.query.builder.support.parser.sql.EqualRuleParser;
import com.itfsw.query.builder.support.parser.sql.GreaterOrEqualRuleParser;
import com.itfsw.query.builder.support.parser.sql.GreaterRuleParser;
import com.itfsw.query.builder.support.parser.sql.INRuleParser;
import com.itfsw.query.builder.support.parser.sql.IsEmptyRuleParser;
import com.itfsw.query.builder.support.parser.sql.IsNotEmptyRuleParser;
import com.itfsw.query.builder.support.parser.sql.IsNotNullRuleParser;
import com.itfsw.query.builder.support.parser.sql.IsNullRuleParser;
import com.itfsw.query.builder.support.parser.sql.LessOrEqualRuleParser;
import com.itfsw.query.builder.support.parser.sql.LessRuleParser;
import com.itfsw.query.builder.support.parser.sql.NotBeginsWithRuleParser;
import com.itfsw.query.builder.support.parser.sql.NotBetweenRuleParser;
import com.itfsw.query.builder.support.parser.sql.NotContainsRuleParser;
import com.itfsw.query.builder.support.parser.sql.NotEndsWithRuleParser;
import com.itfsw.query.builder.support.parser.sql.NotEqualRuleParser;
import com.itfsw.query.builder.support.parser.sql.NotInRuleParser;

/**
 * ---------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------
 * 
 * @author: hewei
 * @time:2017/10/31 17:03 ---------------------------------------------------------------------------
 */
public class SqlQueryBuilderFactory extends AbstractQueryBuilderFactory
{
	@SuppressWarnings("unused")
	private SqlQueryBuilderConfig config; // 配置

	/**
	 * 构造函数
	 * 
	 * @param config
	 */
	public SqlQueryBuilderFactory(SqlQueryBuilderConfig config) {

		super();
		this.config = config;

		// ------------------------ filter ---------------------------
		filters.add(new SqlInjectionAttackFilter(config.getDbType())); // sql 注入

		// ------------------------- group parser ----------------------
		groupParser = new DefaultGroupParser();

		// ---------------------- rule parser ----------------------------
		ruleParsers.add(new EqualRuleParser());
		ruleParsers.add(new NotEqualRuleParser());
		ruleParsers.add(new INRuleParser());
		ruleParsers.add(new NotInRuleParser());
		ruleParsers.add(new LessRuleParser());
		ruleParsers.add(new LessOrEqualRuleParser());
		ruleParsers.add(new GreaterRuleParser());
		ruleParsers.add(new GreaterOrEqualRuleParser());
		ruleParsers.add(new BetweenRuleParser());
		ruleParsers.add(new NotBetweenRuleParser());
		ruleParsers.add(new BeginsWithRuleParser());
		ruleParsers.add(new NotBeginsWithRuleParser());
		ruleParsers.add(new ContainsRuleParser());
		ruleParsers.add(new NotContainsRuleParser());
		ruleParsers.add(new EndsWithRuleParser());
		ruleParsers.add(new NotEndsWithRuleParser());
		ruleParsers.add(new IsEmptyRuleParser());
		ruleParsers.add(new IsNotEmptyRuleParser());
		ruleParsers.add(new IsNullRuleParser());
		ruleParsers.add(new IsNotNullRuleParser());
	}

	/**
	 * 构造函数
	 */
	public SqlQueryBuilderFactory() {

		this(new SqlQueryBuilderConfig());
	}

	/**
	 * 获取builder
	 * 
	 * @return
	 */
	public SqlBuilder builder() {

		List<IRuleParser> sqlRuleParsers = new ArrayList<>();
		for (IRuleParser parser : ruleParsers) {
			if (parser instanceof AbstractSqlRuleParser) {
				sqlRuleParsers.add(parser);
			}
		}
		return new SqlBuilder(groupParser, sqlRuleParsers, filters);
	}
}
