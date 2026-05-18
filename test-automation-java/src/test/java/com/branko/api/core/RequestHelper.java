package com.branko.api.core;

import com.branko.shared.AllureUtils;
import com.branko.shared.Config;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestHelper {

    private String url(String endpoint){
        return String.format(Config.get("baseUrlPracticeTestingApi") + endpoint, endpoint);
    }

    private boolean isDebug() {
        return Config.getBoolean("debugMode");
    }
    private void logRequest(RequestSpecification request) {
        if (isDebug()) {
            request.log().all();
        }
    }

    private void logResponse(Response response) {
        if (isDebug()) {
            response.then().log().all();
        }
    }

    public Response sendGet(String endpoint) {
        return AllureUtils.step(String.format("Send GET request to '%s'", endpoint), () -> {
            RequestSpecification request = given();

            logRequest(request);

            Response response = request
                    .when()
                    .get(url(endpoint));

            logResponse(response);
            return response;
        });
    }

    public Response sendGet(String endpoint, Map<String, Object> headers) {
        return AllureUtils.step(String.format("Send GET request to '%s'", endpoint), () -> {
            RequestSpecification request = given()
                    .headers(headers);

            logRequest(request);

            Response response = request
                    .when()
                    .get(url(endpoint));

            logResponse(response);

            return response;
        });
    }

    public Response sendPost(String endpoint, Object body) {
        return AllureUtils.step(String.format("Send POST request to '%s'", endpoint), () -> {

            AllureUtils.attachJson("Request body", body);

            RequestSpecification request = given()
                    .contentType(ContentType.JSON)
                    .body(body);

            logRequest(request);

            Response response = request
                    .when()
                    .post(url(endpoint));

            logResponse(response);

            AllureUtils.attachJson(
                    "Response body",
                    response.getBody().asPrettyString()
            );

            return response;
        });
    }

    public Response sendPut(String endpoint) {
        return AllureUtils.step(String.format("Send PUT request to '%s'", endpoint), () -> {
            RequestSpecification request = given();

            logRequest(request);

            Response response = request
                    .when()
                    .put(url(endpoint));

            logResponse(response);

            return response;
        });
    }

    public Response sendDelete(String endpoint) {
        return AllureUtils.step(String.format("Send PUT request to '%s'", endpoint), () -> {
            RequestSpecification request = given();

            logRequest(request);

            Response response = request
                    .when()
                    .delete(url(endpoint));

            logResponse(response);

            return response;
        });
    }
    public <T> T extractFromJsonBody(Response response, String keyName, Class<T> clazz) {
        return response.jsonPath()
                .getObject(keyName, clazz);
    }

}