package com.fralermo.springbootNgDemo.infra;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.fralermo.springbootNgDemo.infra.rest.controller.PriceController;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PricesApiTest implements InitializingBean{

	@LocalServerPort
	private int port;

	@Autowired
	private PriceController controller;

	//Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ACME) --> 35.5
	//Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ACME) --> 25.45
	//Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ACME) --> 35.5
	//Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ACME) --> 30.5
	//Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ACME) --> 38.95
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		RestAssured.baseURI = "http://localhost:"+port+"/api/v1/price";
	}	
	
	
	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	void testRestPrices() throws Exception {
		
		Response response = RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.get("/findAll")
		.then()
		.extract().response();
		
		Assertions.assertEquals(200, response.statusCode());
	}
	
	@Test
	void testRestPricesQuery1() throws Exception {
		Map<String, Object> requestParams = new HashMap<>();
	    requestParams.put("localDateTime", "2020-06-14T10:00:00.000+00:00");
	    requestParams.put("productId", "35455");
	    requestParams.put("brandId", "1");
		
		Response response = RestAssured.given()
			.contentType(ContentType.JSON)
			.params(requestParams)
			.when()
			.get("/query")
			.then()
			.extract().response();
		
		Assertions.assertEquals(200, response.statusCode());
		Double price = response.jsonPath().getDouble("price");
		log.info("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ACME): "+price);
		Assertions.assertEquals(35.5, price);
	}
	
	@Test
	void testRestPricesQuery2() throws Exception {
		Map<String, Object> requestParams = new HashMap<>();
	    requestParams.put("localDateTime", "2020-06-14T16:00:00.000+00:00");
	    requestParams.put("productId", "35455");
	    requestParams.put("brandId", "1");
	    
	    Response response = RestAssured.given()
			.contentType(ContentType.JSON)
			.params(requestParams)
			.when()
			.get("/query")
			.then()
			.extract().response();
			
			Assertions.assertEquals(200, response.statusCode());
			Double price = response.jsonPath().getDouble("price");
			log.info("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ACME): "+price);
			Assertions.assertEquals(25.45, price);
	}
	
	@Test
	void testRestPricesQuery3() throws Exception {
		Map<String, Object> requestParams = new HashMap<>();
	    requestParams.put("localDateTime", "2020-06-14T21:00:00.000+00:00");
	    requestParams.put("productId", "35455");
	    requestParams.put("brandId", "1");
	    
	    Response response = RestAssured.given()
	    		.contentType(ContentType.JSON)
	    		.params(requestParams)
	    		.when()
	    		.get("/query")
	    		.then()
	    		.extract().response();
	    		
	    		Assertions.assertEquals(200, response.statusCode());
	    		Double price = response.jsonPath().getDouble("price");
	    		log.info("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ACME): "+price);
	    		Assertions.assertEquals(35.5, price);
	}
	
	@Test
	void testRestPricesQuery4() throws Exception {
		Map<String, Object> requestParams = new HashMap<>();
	    requestParams.put("localDateTime", "2020-06-15T10:00:00.000+00:00");
	    requestParams.put("productId", "35455");
	    requestParams.put("brandId", "1");
	    
	    Response response = RestAssured.given()
	    		.contentType(ContentType.JSON)
	    		.params(requestParams)
	    		.when()
	    		.get("/query")
	    		.then()
	    		.extract().response();
	    		
	    		Assertions.assertEquals(200, response.statusCode());
	    		Double price = response.jsonPath().getDouble("price");
	    		log.info("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ACME): "+price);
	    		Assertions.assertEquals(30.5, price);
	}
	
	@Test
	void testRestPricesQuery5() throws Exception {
		Map<String, Object> requestParams = new HashMap<>();
	    requestParams.put("localDateTime", "2020-06-16T21:00:00.000+00:00");
	    requestParams.put("productId", "35455");
	    requestParams.put("brandId", "1");
	    
	    Response response = RestAssured.given()
	    		.contentType(ContentType.JSON)
	    		.params(requestParams)
	    		.when()
	    		.get("/query")
	    		.then()
	    		.extract().response();
	    		
	    		Assertions.assertEquals(200, response.statusCode());
	    		Double price = response.jsonPath().getDouble("price");
	    		log.info("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ACME): "+price);
	    		Assertions.assertEquals(38.95, price);
	}
	
}
