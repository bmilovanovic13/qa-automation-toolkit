package com.branko.api.users;

import com.branko.api.core.ApiAssertions;
import com.branko.api.core.RequestHelper;
import com.branko.shared.Config;
import com.branko.shared.AllureUtils;
import com.branko.shared.ConfigKey;
import io.restassured.response.Response;

import java.util.Map;

public class UsersClient extends RequestHelper {

    private final String CURRENT_USER_ENDPOINT = "/users/me";
    private Map<String, Object> authorizationHeader(String token){
        return Map.of(
                "Authorization","Bearer " + token
        );
    }
    public Response getCurrentUser(String token){
        return sendGet(CURRENT_USER_ENDPOINT, authorizationHeader(token));
    }

    public void verifyCustomerIsLoggedIn(String token){
        AllureUtils.step("Verify Customer", () -> {
            Response response = getCurrentUser(token);
            ApiAssertions.assertField(response,"email", Config.get(ConfigKey.QA_PRACTICE_USERNAME), String.class);
            ApiAssertions.assertField(response, "first_name", "Jane", String.class);
            ApiAssertions.assertField(response, "last_name", "Doe", String.class);
        });
    }

    public void verifyAdminIsLoggedIn(String token){
        AllureUtils.step("Verify admin user", () -> {
            Response response = getCurrentUser(token);
            ApiAssertions.assertField(response,"email", Config.get(ConfigKey.QA_PRACTICE_ADMIN_USERNAME), String.class);
            ApiAssertions.assertField(response, "first_name", "John", String.class);
            ApiAssertions.assertField(response, "last_name", "Doe", String.class);
            ApiAssertions.assertField(response,"enabled",true, Boolean.class);
        });
    }
}