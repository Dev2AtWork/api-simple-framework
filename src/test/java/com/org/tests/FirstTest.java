package com.org.tests;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.org.constants.Constants;
import static org.testng.Assert.assertTrue;

public class FirstTest {
	@Test
	public void validateReturnCode() {

		given().baseUri(Constants.BASE_URL).log().everything().contentType(ContentType.JSON).when()
				.get("/37.8267,-122.4233").then().statusCode(200);
	}

	@Test
	public void validateResponseTopLevelStructure() {
		Response re = given().baseUri(Constants.BASE_URL).log().everything().contentType(ContentType.JSON)
				.when().get("/" + Constants.query).then().contentType(ContentType.JSON).statusCode(200).extract()
				.response();
		assertTrue(!re.jsonPath().getString("latitude").trim().equalsIgnoreCase(""));
		assertTrue(!re.jsonPath().getString("longitude").trim().equalsIgnoreCase(""));
		assertTrue(!re.jsonPath().getString("timezone").trim().equalsIgnoreCase(""));
		assertTrue(!re.jsonPath().getString("currently").trim().equalsIgnoreCase(""));
		assertTrue(!re.jsonPath().getString("minutely").trim().equalsIgnoreCase(""));
		assertTrue(!re.jsonPath().getString("hourly").trim().equalsIgnoreCase(""));
		assertTrue(!re.jsonPath().getString("daily").trim().equalsIgnoreCase(""));
		assertTrue(!re.jsonPath().getString("flags").trim().equalsIgnoreCase(""));
		assertTrue(!re.jsonPath().getString("offset").trim().equalsIgnoreCase(""));
		
	}
}
