package Airlines;

import java.util.HashMap;
import java.util.Map;

import RestUtils.RestUtils;
import io.restassured.response.Response;

public class AirlineAPIs {

	public Response CreateAirline(Map<String, Object> createAirlinePayload) {
		String endPoint = (String) Base.dataFromJsonFile.get("createAirlineEndPoint");
		 return RestUtils.performPost(endPoint,createAirlinePayload,new HashMap<>());
	}
}
