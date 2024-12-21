package Airlines;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import RestUtils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.JsonUtils;

public class AirlineTest2 extends AirlineAPIs{
	
	@Test
	public void CreateAirline() throws StreamReadException, DatabindException, IOException {
		
		Map<String, Object> payload = Payload.getCreateAirlinePayloadForMap("123321", "Quatar Airways", "Quatar", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/300px-Qatar_Airways_Logo.svg.png", "Going Places Together", "Qatar Airways Towers, Doha, Qatar", "www.qatarairways.com", "1994");
		Response response = CreateAirline(payload);
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("response statusCode() : "+response.statusCode());
	}

}
