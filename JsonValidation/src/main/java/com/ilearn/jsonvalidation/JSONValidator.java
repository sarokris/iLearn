package com.ilearn.jsonvalidation;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;

public class JSONValidator {
	
	public static void main(String[] args) throws JsonProcessingException, IOException {
		String jsonString = "{\"name\" : \"Warriors\",\"memebers\" : [ { \"A\" : \"Captain\", \"B\" : \"WicketKeeper\"}]}";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(jsonString);

		boolean isValid = new JSONValidator().validateJson("teamSchema.json", actualObj);
		System.out.println("Input Json is valid : " + isValid);

	}

	private boolean validateJson(String schema, JsonNode inputJson) {
		boolean isValid = false;
		JsonValidator validator = JsonSchemaFactory.byDefault().getValidator();
		ProcessingReport report = null;
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			JsonNode schemaFromDisk = JsonLoader.fromURL(classLoader.getResource(schema));
			report = validator.validate(schemaFromDisk, inputJson);
			if (!report.isSuccess()) {
				 for (ProcessingMessage processingMessage : report) {
					 System.out.println(processingMessage.getMessage());
				 }
				isValid = false;
			} else {
				isValid = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isValid = false;
		}
		return isValid;
	}
}
