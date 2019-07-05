/*
 * Copyright (c) 2017. Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.itfsw.query.builder;

import java.util.ArrayList;
import java.util.List;

import com.itfsw.query.builder.support.builder.MongodbBuilder;
import com.itfsw.query.builder.support.parser.AbstractMongodbRuleParser;
import com.itfsw.query.builder.support.parser.IRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.BeginsWithRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.BetweenRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.ContainsRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.DefaultGroupParser;
import com.itfsw.query.builder.support.parser.mongodb.EndsWithRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.EqualRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.GreaterOrEqualRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.GreaterRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.INRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.IsEmptyRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.IsNotEmptyRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.IsNotNullRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.IsNullRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.LessOrEqualRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.LessRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.NotBeginsWithRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.NotBetweenRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.NotContainsRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.NotEndsWithRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.NotEqualRuleParser;
import com.itfsw.query.builder.support.parser.mongodb.NotInRuleParser;

/**
 * ---------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------
 * 
 * @author: hewei
 * @time:2017/11/1 18:31 ---------------------------------------------------------------------------
 */
public class MongodbQueryBuilderFactory extends AbstractQueryBuilderFactory
{

	/**
	 * 构造函数
	 */
	public MongodbQueryBuilderFactory() {

		super();

		// ---------------------- group parser ----------------------------
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
	 * 获取builder
	 * 
	 * @return
	 */
	public MongodbBuilder builder() {

		List<IRuleParser> mongodbRuleParsers = new ArrayList<>();
		for (IRuleParser parser : ruleParsers) {
			if (parser instanceof AbstractMongodbRuleParser) {
				mongodbRuleParsers.add(parser);
			}
		}
		return new MongodbBuilder(groupParser, mongodbRuleParsers, filters);
	}
}
