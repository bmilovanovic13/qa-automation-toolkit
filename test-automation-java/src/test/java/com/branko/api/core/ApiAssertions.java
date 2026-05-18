package com.branko.api.core;

import com.branko.shared.AllureUtils;
import io.restassured.response.Response;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiAssertions {

    public static void assertStatusCode(Response response, int expectedStatusCode) {
        AllureUtils.step(String.format("Verify status code is '%s'", expectedStatusCode), () -> {
            int actualStatusCode = response.statusCode();

            assertThat(actualStatusCode)
                    .withFailMessage("Expected status code: '%s' but actual was: '%s'",expectedStatusCode, actualStatusCode)
                    .isEqualTo(expectedStatusCode);
        } );
    }

    public static void assertFieldNotBlank(Response response, String fieldName) {
        AllureUtils.step(String.format("Verify field '%s' is not blank", fieldName), () -> {
            String field = response.jsonPath().getString(fieldName);

            assertThat(field)
                    .withFailMessage("Field '%s' is null", fieldName)
                    .isNotNull();

            assertThat(field)
                    .withFailMessage("Field '%s' is blank", fieldName)
                    .isNotBlank();
        });
    }

    public static <T> void assertField(Response response, String name, T expected, Class<T> clazz){
        AllureUtils.step(String.format("Verify field '%s' is equal to expected: '%s'", name, expected), () -> {
            T actual = response.jsonPath().getObject(name, clazz);
            assertThat(actual)
                    .withFailMessage("Field '%s' mismatch. Expected: '%s', Actual: '%s'", name, expected, actual)
                    .isEqualTo(expected);
        });
    }

    public static <T> void assertFieldIsNotNull(Response response, String name, Class<T> clazz){
        AllureUtils.step(String.format("Verify field '%s' is not null", name), () -> {
            T field = response.jsonPath().getObject(name, clazz);
            assertThat(field)
                    .withFailMessage("Field '%s' is null.", name, field)
                    .isNotNull();
        });
    }

    public static void assertFieldIsPositive(Response response, String field) {
        AllureUtils.step(String.format("Verify field '%s' is positive", field), () -> {
            BigDecimal actual = response.jsonPath().getObject(field, BigDecimal.class);
            assertThat(actual).withFailMessage("Field '%s' is not positive. Actual: %s", field, actual).isPositive();
        });
    }
}