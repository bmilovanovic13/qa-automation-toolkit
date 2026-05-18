package com.branko.ui.pom;

import com.branko.shared.Config;
import com.branko.ui.base.BasePage;
import com.branko.ui.driver.DriverManager;
import org.openqa.selenium.By;
import static com.branko.ui.utils.Assertions.*;

public class LoginPage extends BasePage {

    // Locators
    private static final By USERNAME_FIELD =  By.cssSelector("[data-test='username']");
    private static final By PASSWORD_FIELD =  By.cssSelector("[data-test='password']");
    private static final By LOGIN_BUTTON = By.cssSelector("[data-test='login-button']");
    private static final By LOGIN_LOGO = By.className("login_logo");
    private static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");

    //Methods
    public static LoginPage open(){
        DriverManager.getDriver().navigate().to(Config.get("baseUrl"));
        return new LoginPage();
    }
    public LoginPage verifyUserIsOnLoginPage(){
        verifyElementIsDisplayed(LOGIN_LOGO, "Swag Labs logo");
        verifyTextIsEqual(LOGIN_LOGO, "Swag Labs");
        return this;
    }
    private void performLogin(String username){
        type(USERNAME_FIELD,username, "Username field");
        typeSecure(PASSWORD_FIELD, Config.get("password"), "Password field");
        click(LOGIN_BUTTON, "Login button");
    }
    public InventoryPage loginAsStandardUser(){
        performLogin(Config.get("username"));
        return new InventoryPage();
    }

    public LoginPage loginAsLockedOutUser(){
        performLogin("locked_out_user");
        return this;
    }

    public LoginPage verifyThisUserIsLockedOutMessage(){
        verifyTextIsEqual(ERROR_MESSAGE, "Epic sadface: Sorry, this user has been locked out.");
        return this;
    }
    public LoginPage loginWithWrongCredentials(){
        performLogin("wrong_username");
        return this;
    }
    public LoginPage verifyWrongUsernameOrPasswordMessage(){
        verifyTextIsEqual(ERROR_MESSAGE, "Epic sadface: Username and password do not match any user in this service");
        return this;
    }
}
