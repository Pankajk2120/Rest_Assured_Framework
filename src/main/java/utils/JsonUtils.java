package utils;

import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.File;

public class JsonUtils {
	private static ObjectMapper objectMapper = new ObjectMapper();
	public static Map<String, Object> getJsonDataAsMap(String jsonFileName) throws StreamReadException, DatabindException, IOException{
		String CompleteJsonFilePath = System.getProperty("user.dir")+"\src\test\resources" +jsonFileName;
		Map<String, Object> data = objectMapper.readValue(new File(CompleteJsonFilePath),new TypeReference<>() {});
		return data;
	}
}
