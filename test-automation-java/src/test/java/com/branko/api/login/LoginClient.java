package com.branko.api.login;

import com.branko.api.core.ApiAssertions;
import com.branko.api.core.RequestHelper;
import com.branko.shared.Config;
import com.branko.shared.AllureUtils;
import io.restassured.response.Response;

import static com.branko.api.core.ApiAssertions.*;

public class LoginClient extends RequestHelper {

    private final String LOGIN_ENDPOINT = "/users/login";
    private final String adminUsername = Config.get("practiceSoftwareAdminUsername");
    private final String customerUsername = Config.get("practiceSoftwareUsername");
    private final String standardPassword = Config.get("practiceSoftwarePassword");
    private Response loginResponse;
    private final LoginRequest loginAsCustomerRequest = new LoginRequest(
            customerUsername,
            standardPassword
    );

    private final LoginRequest loginAsAdminRequest = new LoginRequest(
            adminUsername,
            standardPassword
    );
    private Response login(LoginRequest user){
        return sendPost(LOGIN_ENDPOINT, user);
    }

    private String loginAndGetToken(LoginRequest loginUser) {
        AllureUtils.step("Login as standard user", () -> {
            loginResponse = login(loginUser);
            assertStatusCode(loginResponse, 200);
            assertFieldNotBlank(loginResponse, "access_token");
        });
        return extractFromJsonBody(loginResponse, "access_token", String.class);
    }

    public String loginAsCustomerAndGetToken(){
        return loginAndGetToken(loginAsCustomerRequest);
    }

    public String loginAsAdminAndGetToken(){
        return loginAndGetToken(loginAsAdminRequest);
    }

    public Response loginWithInvalidPassword(){
        LoginRequest userWithInvalidPassword = new LoginRequest(
                customerUsername,
                "wrong_password"
        );
        return login(userWithInvalidPassword);
    }

    public Response loginWithNonExistingEmail(){
        LoginRequest userWithNonExistingEmail = new LoginRequest(
                "wrong_email@test.com",
                standardPassword
        );
        return login(userWithNonExistingEmail);
    }

    public Response loginWithoutCredentials(){
        LoginRequest userWithoutCredentials = new LoginRequest(
                "",
                ""
        );
        return login(userWithoutCredentials);
    }

    public void verifyError(Response loginResponse, String errorMessage){
        ApiAssertions.assertStatusCode(loginResponse, 401);
        ApiAssertions.assertField(loginResponse, "error", errorMessage, String.class);
    }
}
