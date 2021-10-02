package com.petstore.test.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.provider.Arguments;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Base class for common tests configurations
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PetStoreApiTestBase {

    public RequestSpecification requestSpecification;
    public Properties properties;
    public ObjectMapper objectMapper;

    /**
     * Setup Method to:
     * Load properties from config.properties file
     * Initialize Restassured RequestSpecification object
     *
     * @throws IOException
     */
    @BeforeAll
    public void setUp() throws IOException {
        FileReader fileReader = new FileReader("src/test/resources/config.properties");
        properties = new Properties();
        properties.load(fileReader);

        objectMapper = new ObjectMapper();

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(properties.getProperty("api.server"))
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

    }

    /**
     * For ease of maintenance, Category value is read from the properties file and
     * sent as Argument for Parametrized Tests
     *
     * @return Arguments
     */
    public Stream<Arguments> getValuesFromProperties() {
        return Stream.of(arguments(properties.getProperty("pets.category"),
                properties.getProperty("status")));
    }

    /**
     * For ease of maintenance, Category value is read from the properties file and
     * sent as Argument for Parametrized Tests
     *
     * @return Arguments
     */
    public Stream<Arguments> getStatusForTestsFromProperties() {
        return Stream.of(arguments(properties.getProperty("status")));
    }

}
