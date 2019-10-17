package com.itfsw.query.builder;

import java.io.IOException;

import com.itfsw.query.builder.exception.ParserNotFoundException;
import com.itfsw.query.builder.support.builder.MongodbBuilder;
import com.itfsw.query.builder.support.builder.SqlBuilder;
import com.itfsw.query.builder.support.model.result.MongodbQueryResult;
import com.itfsw.query.builder.support.model.result.SqlQueryResult;

public class Interpret
{

	public static void main(String[] args) throws ParserNotFoundException, IOException {

		// Json-ul de pe https://querybuilder.js.org/demo.html
		String json = "{\n" + "  \"condition\": \"AND\",\n" + "  \"rules\": [\n" + "    {\n" + "      \"id\": \"price\",\n" + "      \"field\": \"price\",\n" + "      \"type\": \"double\",\n" + "      \"input\": \"number\",\n" + "      \"operator\": \"less\",\n" + "      \"value\": 10.25\n" + "    },\n" + "    {\n" + "      \"condition\": \"OR\",\n" + "      \"rules\": [\n" + "        {\n" + "          \"id\": \"category\",\n" + "          \"field\": \"category\",\n" + "          \"type\": \"integer\",\n" + "          \"input\": \"select\",\n" + "          \"operator\": \"equal\",\n" + "          \"value\": 2\n" + "        },\n" + "        {\n" + "          \"id\": \"category\",\n" + "          \"field\": \"category\",\n" + "          \"type\": \"integer\",\n" + "          \"input\": \"select\",\n" + "          \"operator\": \"equal\",\n" + "          \"value\": 1\n" + "        }\n" + "      ]\n" + "    }\n" + "  ],\n" + "  \"valid\": true\n" + "}";

		// Transformare JSON in DBObject mongodbQueryResult.getQuery
		MongodbQueryBuilderFactory mongodbQueryBuilderFactory = new MongodbQueryBuilderFactory();
		MongodbBuilder mongodbBuilder = mongodbQueryBuilderFactory.builder();
		MongodbQueryResult mongodbQueryResult = mongodbBuilder.build(json);
		System.out.println(mongodbQueryResult.toString());

		// SQL
		SqlQueryBuilderFactory sqlQueryBuilderFactory = new SqlQueryBuilderFactory();
		SqlBuilder sqlBuilder = sqlQueryBuilderFactory.builder();
		SqlQueryResult sqlQueryResult = sqlBuilder.build(json);
		System.out.println(sqlQueryResult.toString());
	}

}
