package com.petstore.test.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.petstore.test.base.PetStoreApiTestBase;
import com.petstore.test.models.PetsFindByStatusResponseRecord;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class PetsFindByStatusCategoryTests extends PetStoreApiTestBase {

    @ParameterizedTest
    @MethodSource("getValuesFromProperties")
    @DisplayName("Pets - Find By Available Status - Given Category")
    public void findByAvailableStatusAndGivenCategoryTest(String category, String status) throws JsonProcessingException {

        Response response = RestAssured
                .given(requestSpecification)
                .queryParam("status", status)
                .when()
                .get(properties.getProperty("pets.findByStatus"));

        log.info("Response Code: {}", response.getStatusCode());
        log.info("Response Body: {}", response.getBody().asString());

        assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Response code is not as expected");

        List<PetsFindByStatusResponseRecord> petsFindByStatusResponseRecords = Arrays.asList(objectMapper.readValue(response.getBody().asString(), PetsFindByStatusResponseRecord[].class));

        int categoryRecordsInResponse = findRecordsByCategoryFromResponseAndPrint(petsFindByStatusResponseRecords, category);

        log.info("{} {} records available in response ", categoryRecordsInResponse, category);
    }

    public int findRecordsByCategoryFromResponseAndPrint(List<PetsFindByStatusResponseRecord> petsFindByStatusResponseRecords, String category) {

        int count = 0;

        for (PetsFindByStatusResponseRecord petsFindByStatusResponseRecord : petsFindByStatusResponseRecords) {
            if(petsFindByStatusResponseRecord.getCategory() != null && petsFindByStatusResponseRecord.getCategory().getName() != null) {
                if(petsFindByStatusResponseRecord.getCategory().getName().equalsIgnoreCase(category)) {
                    count++;
                }
            }
        }

        return count;
    }
}
