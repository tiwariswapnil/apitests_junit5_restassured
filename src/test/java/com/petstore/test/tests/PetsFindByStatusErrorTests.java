package com.petstore.test.tests;

import com.petstore.test.base.PetStoreApiTestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class PetsFindByStatusErrorTests extends PetStoreApiTestBase {

    @Test
    @DisplayName("Pets - Find By Status - No Status Specified - Bad Request")
    public void findByStatusNoStatusBadRequestTest() {

        log.info("Pets - Find By Status - No Status Specified - Bad Request");

        Response response = RestAssured
                .given(requestSpecification)
                .when()
                .get(properties.getProperty("pets.findByStatus"));

        log.info("Response Code: {}", response.getStatusCode());
        log.info("Response Body: {}", response.getBody().asString());

        assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode(), "Response code is not as expected");
        assertEquals("No status provided. Try again?", response.getBody().asString(), "Response Body is not as expected");

    }

    @Test
    @DisplayName("Pets - Find By Status - Method Not Allowed")
    public void findByStatusNoStatusMethodNotAllowedTest() {

        log.info("Pets - Find By Status - Method Not Allowed");

        Response response = RestAssured
                .given(requestSpecification)
                .when()
                .post(properties.getProperty("pets.findByStatus"));

        log.info("Response Code: {}", response.getStatusCode());
        log.info("Response Body: {}", response.getBody().asString());

        assertEquals(HttpStatus.SC_METHOD_NOT_ALLOWED, response.getStatusCode(), "Response code is not as expected");
        assertTrue(response.getBody().asString().contains("HTTP 405 Method Not Allowed"), "Response Body is not as expected");

    }

}
