package com.branko.ui.tests.saucedemo;

import com.branko.ui.base.BaseTest;
import org.testng.annotations.Test;
import com.branko.ui.pom.saucedemo.LoginPage;

public class LoginTest extends BaseTest {

    @Test(groups = {"ui","smoke"}, description = "Verify that user can login successfully with valid credentials")
    public void shouldLoginSuccessfully(){
        LoginPage
                .open()
                .verifyUserIsOnLoginPage()
                .loginAsStandardUser()
                .verifyInventoryPageIsDisplayed();
    }

    @Test(groups = {"ui", "regression"}, description = "Verify that locked out user cannot login and proper error message is shown")
    public void shouldNotLoginWithLockedOutUser(){
        LoginPage
                .open()
                .verifyUserIsOnLoginPage()
                .loginAsLockedOutUser()
                .verifyThisUserIsLockedOutMessage()
                .verifyUserIsOnLoginPage();
    }

    @Test(groups = {"ui", "regression"}, description = "Verify that login fails with invalid credentials")
    public void shouldNotLoginWithInvalidCredentials(){
        LoginPage
                .open()
                .verifyUserIsOnLoginPage()
                .loginWithWrongCredentials()
                .verifyWrongUsernameOrPasswordMessage()
                .verifyUserIsOnLoginPage();
    }
}
