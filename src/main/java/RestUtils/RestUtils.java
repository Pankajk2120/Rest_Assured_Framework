package RestUtils;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;
public class RestUtils {
		
	private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String, String>headers) {
		return RestAssured.given()
				.baseUri(endPoint)
				.headers(headers)
				.contentType(ContentType.JSON)
				.body(requestPayload);
	}
	
	private static void printRequestLogInReport(RequestSpecification requestSpecification) {
		QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
		ExtentReportManager.logInfoDetails("Endpoint is " + queryableRequestSpecification.getBaseUri());
		ExtentReportManager.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
		ExtentReportManager.logInfoDetails("Headers are ");
		ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
		ExtentReportManager.logJson("Request body is ");
		ExtentReportManager.logJson("Request body is " + queryableRequestSpecification.getBody());
		
	}
	
	private static void printResponseLogInReport(Response response) {
		ExtentReportManager.logInfoDetails("Response Status is " + response.getStatusCode());
		ExtentReportManager.logInfoDetails("Response Headers is");
		ExtentReportManager.logHeaders(response.getHeaders().asList());
		ExtentReportManager.logJson("Response body is");
		ExtentReportManager.logJson("Response body is " + response.getBody().prettyPrint());
	}
	
	public static Response performPost(String endPoint, String requestPayload, Map<String, String> headers) {
		RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
		Response response =  requestSpecification.post();
		printRequestLogInReport(requestSpecification);
		printResponseLogInReport(response);
		return response;
	}
	
	
	public static Response performPost(String endPoint, Map<String,Object> requestPayload, Map<String, String> headers) {
		RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
		Response response =  requestSpecification.post();
		printRequestLogInReport(requestSpecification);
		printResponseLogInReport(response);
		return response;
	}
	
	
}
