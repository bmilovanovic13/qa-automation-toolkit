package com.branko.shared;

import com.branko.ui.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AuthenticationHelper {

    public static void loginWithToken(String token) {
        AllureUtils.step("Authenticate browser using JWT token", () -> {
            WebDriver driver = DriverManager.getDriver();

            driver.get(
                    Config.get(ConfigKey.QA_PRACTICE_BASE_URL)
            );

            ((JavascriptExecutor) driver)
                    .executeScript("window.localStorage.setItem('auth-token', arguments[0]);", token);

            driver.navigate().refresh();
        });
    }
}