package com.iqbal.webserviceMethods;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

// TODO: Auto-generated Javadoc
/**
 * The Class Webservices.
 */
public class Webservices {
	
	/**
	 * Post.
	 *
	 * @param url the url
	 * @param stringJson the string json
	 * @return the response
	 */
	public static Response Post(String url, String stringJson) {
		RequestSpecification requestSpecification = RestAssured.given().body(stringJson);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(url);
		return response;
	}

	/**
	 * Gets the.
	 *
	 * @param url the url
	 * @return the response
	 */
	public static Response Get(String url) {
		RequestSpecification requestSpecification = RestAssured.given().accept("application/json");
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(url);
		return response;
	}

	/**
	 * Put.
	 *
	 * @param url the url
	 * @param stringJson the string json
	 * @return the response
	 */
	public static Response Put(String url, String stringJson) {
		RequestSpecification requestSpecification = RestAssured.given().body(stringJson);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(url);
		return response;
	}

	/**
	 * Delete.
	 *
	 * @param url the url
	 * @return the response
	 */
	public static Response Delete(String url) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(url);
		return response;
	}
}
