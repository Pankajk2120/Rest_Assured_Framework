package Airlines;

import java.io.IOException;
import java.util.Map;

import utils.JsonUtils;

public class Base {
	public static Map<String, Object> dataFromJsonFile;
	static {
		String env = System.getProperty("env") == null ? "QA" : System.getProperty("env");
		try {
			dataFromJsonFile = JsonUtils.getJsonDataAsMap("/airlines/"+env+"/airlineApiData.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
