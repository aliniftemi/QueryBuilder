/*
 * Copyright (c) 2017. Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.itfsw.query.builder.other;

import com.itfsw.query.builder.exception.FilterException;
import com.itfsw.query.builder.support.filter.IRuleFilter;
import com.itfsw.query.builder.support.model.JsonRule;
import com.itfsw.query.builder.support.model.enums.EnumBuilderType;

/**
 * ---------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------
 * 
 * @author: hewei
 * @time:2017/11/2 17:32 ---------------------------------------------------------------------------
 */
public class TestFilter implements IRuleFilter
{
	@Override
	public void doFilter(JsonRule jsonRule, EnumBuilderType type) throws FilterException {

	}
}
