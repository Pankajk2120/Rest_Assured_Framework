package Airlines;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import RestUtils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AirlineTest {
	
	@Test
	public void CreateAirline() {
		
		String endPoint = "https://api.instantwebtools.net/v1/airlines";
		String payLoad = "{\r\n"
				+ "    \"_id\": \"152d3bca-d9bb-476c-9a97-562d685e235c\",\r\n"
				+ "    \"name\": \"Quatar Airways\",\r\n"
				+ "    \"country\": \"Quatar\",\r\n"
				+ "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/300px-Qatar_Airways_Logo.svg.png\",\r\n"
				+ "    \"slogan\": \"Going Places Together\",\r\n"
				+ "    \"head_quaters\": \"Qatar Airways Towers, Doha, Qatar\",\r\n"
				+ "    \"website\": \"www.qatarairways.com\",\r\n"
				+ "    \"established\": \"1994\"\r\n"
				+ "}";
		
		
		Response response = RestUtils.performPost(endPoint,payLoad,new HashMap<>());
				
				Assert.assertEquals(response.statusCode(), 200);
				
				System.out.println("response statusCode() : "+response.statusCode());
	}

}
