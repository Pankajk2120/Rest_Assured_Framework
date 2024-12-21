package Airlines;

import java.util.HashMap;
import java.util.Map;

public class Payload {
	
	public static String getCreateAirlinePayloadForString(String id, String name, String country, String logo, String slogan, String head_quaters, String website, String establish){
		String payload = "{\n"
				+ "    \"_id\": "+id+",\n"
				+ "    \"name\": "+name+",\n"
				+ "    \"country\": "+country+",\n"
				+ "    \"logo\": "+logo+",\n"
				+ "    \"slogan\": "+slogan+",\n"
				+ "    \"head_quaters\": "+head_quaters+",\n"
				+ "    \"website\": "+website+",\n"
				+ "    \"established\": "+establish+"\n"
				+ "}";
		return payload;
		
	}
	
	public static Map<String, Object> getCreateAirlinePayloadForMap(String id, String name, String country, String logo, String slogan, String head_quaters, String website, String establish){
		Map<String, Object> payload = new HashMap<>();
		payload.put("id", id);
		payload.put("name", name);
		payload.put("country", country);
		payload.put("logo", logo);
		payload.put("slogan", slogan);
		payload.put("head_quaters", head_quaters);
		payload.put("website", website);
		payload.put("establish", establish);
		return payload;
	}

}
