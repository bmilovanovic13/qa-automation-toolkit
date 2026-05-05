package com.branko.ui.utils;

import com.branko.ui.enums.WaitStrategy;
import com.branko.ui.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {
    public static WebElement perform(WaitStrategy strategy, By locator) {

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        return switch (strategy) {
            case CLICKABLE -> wait.until(ExpectedConditions.elementToBeClickable(locator));
            case VISIBLE -> wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        };
    }
}
