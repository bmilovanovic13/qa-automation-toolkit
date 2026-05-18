package com.branko.api.tests;

import com.branko.api.users.UsersClient;
import com.branko.api.login.LoginClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LoginTest {
    private final LoginClient loginClient = new LoginClient();
    private final UsersClient usersClient = new UsersClient();

    @Test(groups = {"api", "smoke-api"}, description = "Verify customer can login")
    public void shouldLoginCustomerSuccessfully(){

        String token = loginClient.loginAsCustomerAndGetToken();

        usersClient.verifyCustomerIsLoggedIn(token);
    }

    @Test(groups = {"api", "smoke-api"}, description = "Verify admin can login")
    public void shouldAdminLoginSuccessfully(){

        String token = loginClient.loginAsAdminAndGetToken();

        usersClient.verifyAdminIsLoggedIn(token);
    }

    @Test(groups = {"api","regression-api"}, description = "Verify user can't login with wrong password")
    public void shouldNotLoginWithInvalidPassword(){
        Response loginResponse = loginClient.loginWithInvalidPassword();

        loginClient.verifyError(loginResponse, "Unauthorized");
    }

    @Test(groups = {"api","regression-api"}, description = "Verify user can't login with wrong email")
    public void shouldNotLoginWithNonExistingEmail(){
        Response loginResponse = loginClient.loginWithNonExistingEmail();

        loginClient.verifyError(loginResponse, "Unauthorized");
    }

    @Test(groups = {"api","regression-api"}, description = "Verify user can't login without credentials")
    public void shouldNotLoginWithoutCredentials(){
        Response loginResponse = loginClient.loginWithoutCredentials();

        loginClient.verifyError(loginResponse, "Invalid login request");
    }
}
