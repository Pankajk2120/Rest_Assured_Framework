package utils;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class RestUtils {
		public static Response performPost(String endPoint, String requestPayload, Map<String, String> headers) {
	       return RestAssured.given().log().all()
	       .baseUri(endPoint)
	       .headers(headers)
	       .contentType(ContentType.JSON)
	       .body(requestPayload)
	       .post()
	       .then().log().all().extract().response();
	}
}
