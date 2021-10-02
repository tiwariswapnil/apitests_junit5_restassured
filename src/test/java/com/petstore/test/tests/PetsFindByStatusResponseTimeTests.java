package com.petstore.test.tests;

import com.petstore.test.base.PetStoreApiTestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class PetsFindByStatusResponseTimeTests extends PetStoreApiTestBase {

    @ParameterizedTest
    @MethodSource("getStatusForTestsFromProperties")
    @DisplayName("Pets - Find By Status - Response Time < 200ms")
    public void findByStatus_Available_ResponseTime(String status) {

        log.info("Pets - Find By Status - Available - Response Time < 200ms");

        Response response = RestAssured
                .given(requestSpecification)
                .queryParam("status", status)
                .when()
                .get(properties.getProperty("pets.findByStatus"));

        long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
        log.info("Response Time: {}", responseTime);
        assertTrue(responseTime < 200, "Find By Status - Response Time is not less than 200ms");
    }

}
