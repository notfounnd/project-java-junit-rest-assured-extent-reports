package br.com.qa.test.service.core.helper;

import java.io.InputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonBuilder {

	private static ObjectMapper mapper = new ObjectMapper();

	private JsonBuilder() { }

	public static JsonNode readJsonFileObjectMapper(String fileName) throws Exception {
		String filePath = filePath(fileName);
		InputStream stream = JsonBuilder.class.getResourceAsStream(filePath);
		return mapper.readValue(stream, JsonNode.class);
	}
	
	public static InputStream readJsonFileInputStream(String fileName) throws Exception {
		String filePath = filePath(fileName);
		InputStream stream = JsonBuilder.class.getResourceAsStream(filePath);
		return stream;
	}

	private static String filePath(String fileName) {
		if (fileName.endsWith(".json")) {
			return ConfigConstants.FIXTURES_DIRECTORY + fileName;
		}

		return ConfigConstants.FIXTURES_DIRECTORY + fileName + ".json";
	}

}
