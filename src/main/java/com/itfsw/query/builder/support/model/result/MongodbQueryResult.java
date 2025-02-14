/*
 * Copyright (c) 2017. Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.itfsw.query.builder.support.model.result;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;

/**
 * ---------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------
 * 
 * @author: hewei
 * @time:2017/11/2 16:46 ---------------------------------------------------------------------------
 */
public class MongodbQueryResult extends AbstractResult
{
	private DBObject query;

	/**
	 * 构造函数
	 * 
	 * @param queryJson
	 * @param query
	 */
	public MongodbQueryResult(String queryJson, DBObject query) {

		this.queryJson = queryJson;
		this.query = query;
	}

	/**
	 * Getter method for property <tt>query</tt>.
	 * 
	 * @return property value of query
	 * @author hewei
	 */
	@Override
	public DBObject getQuery() {

		return query;
	}

	/**
	 * to string
	 * 
	 * @return
	 */
	@Override
	public String toString() {

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(query);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
