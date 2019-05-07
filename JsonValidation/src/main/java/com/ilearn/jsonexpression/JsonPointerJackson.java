package com.ilearn.jsonexpression;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPointerJackson {
	public static void main(String[] args) throws JsonProcessingException, IOException {
		getValueUsingJsonPointerExpression();
	}

//	{
//		"Students": [
//			{
//				"student-A": {
//					"class": "X-A",
//					"class-incharge": "Jacob",
//					"subjects": [
//						{
//							"english": {
//								"mark": "80",
//								"grade": "B"
//							}
//						}
//					]
//				},
//				"student-B": {
//					"class": "X-A",
//					"class-incharge": "Jacob",
//					"subjects": [
//						{
//							"english": {
//								"mark": "90",
//								"grade": "A"
//							}
//						}
//					]
//				}
//			}
//		]
//	}

	private static void getValueUsingJsonPointerExpression() throws JsonProcessingException, IOException {
		String json = "{\"Students\": [{\"student-A\": {\"class\": \"X-A\",\"class-incharge\": \"Jacob\",\"subjects\": [{\"english\": {\"mark\": \"80\",\"grade\": \"B\"}}]},\"student-B\": {\"class\": \"X-A\",\"class-incharge\": \"Jacob\",\"subjects\": [{\"english\": {\"mark\": \"90\",\"grade\": \"A\"}}]}}]}";
		ObjectMapper objMapper = new ObjectMapper();
		JsonNode parentNode = objMapper.readTree(json);
		String grade = parentNode.at("/Students/0/student-A/subjects/0/english/grade").toString();
		System.out.print(grade);
		
	}

}
