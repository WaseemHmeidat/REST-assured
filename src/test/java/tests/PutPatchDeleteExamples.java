package tests;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.HashMap;


public class PutPatchDeleteExamples {
	//@Test
	public void testPut() {
		JSONObject request = new JSONObject();
		request.put("name","Hanan 3nata");
		request.put("job", "QA Engineer");
		System.out.println(request.toJSONString());
		
		baseURI ="https://reqres.in/api";
		given().header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("/users/2").
		then().
		statusCode(200).
		log().all();
	}
	
	
	//@Test
	public void testPatch() {
		JSONObject request = new JSONObject();
		request.put("name","Hanan 3nata");
		request.put("job", "QA Engineer");
		System.out.println(request.toJSONString());
		
		baseURI ="https://reqres.in";
		given().header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("/api/users/2").
		then().
		statusCode(200).
		log().all();
	}
	@Test
	public void testDelete() {
		
		baseURI ="https://reqres.in";
		
		when().
		delete("/api/users/2").
		then().
		statusCode(204).
		log().all();
	}
	
	

}
