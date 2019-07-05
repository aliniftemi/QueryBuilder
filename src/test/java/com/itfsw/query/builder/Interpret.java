package com.itfsw.query.builder;

import java.io.IOException;

import com.itfsw.query.builder.MongodbQueryBuilderFactory;
import com.itfsw.query.builder.exception.ParserNotFoundException;
import com.itfsw.query.builder.support.builder.MongodbBuilder;
import com.itfsw.query.builder.support.model.result.MongodbQueryResult;

public class Interpret
{

	public static void main(String[] args) throws ParserNotFoundException, IOException {

		String json = "{\n" + "  \"condition\": \"AND\",\n" + "  \"rules\": [\n" + "    {\n" + "      \"id\": \"price\",\n" + "      \"field\": \"price\",\n" + "      \"type\": \"double\",\n" + "      \"input\": \"number\",\n" + "      \"operator\": \"less\",\n" + "      \"value\": 10.25\n" + "    },\n" + "    {\n" + "      \"condition\": \"OR\",\n" + "      \"rules\": [\n" + "        {\n" + "          \"id\": \"category\",\n" + "          \"field\": \"category\",\n" + "          \"type\": \"integer\",\n" + "          \"input\": \"select\",\n" + "          \"operator\": \"equal\",\n" + "          \"value\": 2\n" + "        },\n" + "        {\n" + "          \"id\": \"category\",\n" + "          \"field\": \"category\",\n" + "          \"type\": \"integer\",\n" + "          \"input\": \"select\",\n" + "          \"operator\": \"equal\",\n" + "          \"value\": 1\n" + "        }\n" + "      ]\n" + "    }\n" + "  ],\n" + "  \"valid\": true\n" + "}";

		MongodbQueryBuilderFactory factory = new MongodbQueryBuilderFactory();
		MongodbBuilder builder = factory.builder();
		MongodbQueryResult result = builder.build(json);

		// SqlQueryBuilderFactory factory = new SqlQueryBuilderFactory();
		// SqlBuilder builder = factory.builder();
		// SqlQueryResult result = builder.build(json);

		System.out.println(result.toString());
	}

}
