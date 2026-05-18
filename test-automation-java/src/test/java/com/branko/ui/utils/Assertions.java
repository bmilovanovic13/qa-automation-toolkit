package com.branko.ui.utils;

import com.branko.shared.AllureUtils;
import com.branko.ui.enums.WaitStrategy;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import com.branko.ui.driver.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

public class Assertions {

    public static void assertTrue(boolean condition, String message, SoftAssert softAssert){
        if (softAssert !=null) {
            softAssert.assertTrue(
                    condition,message
            );
        } else {
            Assert.assertTrue(
                    condition,message
            );
        }
    }
    public static void assertEquals(String actualText, String expectedText, String message, SoftAssert softAssert){
        if (softAssert != null) {
            softAssert.assertEquals(
                    actualText, expectedText, message
            );
        } else {
            Assert.assertEquals(
                    actualText, expectedText, message
            );
        }
    }
    private static String getVisibleText(By locator){
        return ExplicitWait.perform(WaitStrategy.VISIBLE,locator).getText().trim();
    }
    public static void verifyElementIsDisplayed(By locator, String elementName){
        verifyElementIsDisplayed(locator, elementName, null);
    }
    public static void verifyElementIsDisplayed(By locator, String elementName, SoftAssert softAssert){
        AllureUtils.step(String.format("Verify element '%s' is displayed", elementName),() -> {

            String message = String.format(
                    "Element '%s' (%s) is not displayed", elementName, locator
                );
            WebElement element = ExplicitWait.perform(WaitStrategy.VISIBLE, locator);
            assertTrue(element.isDisplayed(), message, softAssert);
            }
        );
    }

    public static void verifyTextIsEqual(By locator, String expectedText) {
        verifyTextIsEqual(locator, expectedText, null);
    }

    public static void verifyTextIsEqual(By locator, String expectedText, SoftAssert softAssert) {

        AllureUtils.step(
                String.format("Verify element '%s' text equals '%s'", locator, expectedText),
                () -> {
                    String actualText = getVisibleText(locator);

                    String message = String.format(
                            "Expected element '%s' to have text '%s' but was '%s'",
                            locator, expectedText, actualText
                    );
                    assertEquals(actualText, expectedText, message, softAssert);
                }
        );
    }

    public static void verifyTextContains(By locator, String expectedText) {
        verifyTextContains(locator, expectedText, null);
    }

    public static void verifyTextContains(By locator, String expectedText, SoftAssert softAssert) {
        AllureUtils.step(
                String.format("Verify element '%s' contains '%s'", locator, expectedText),
                () -> {
                    String actualText = getVisibleText(locator);

                    assertTrue(actualText.contains(expectedText),String.format("Expected element '%s' to contain '%s' but was '%s'", locator, expectedText, actualText), softAssert);
                }
        );
    }
    public static void verifyElementIsNotDisplayed(By locator, String elementName) {
        AllureUtils.step(
                String.format("Verify element '%s' is NOT displayed", elementName),
                () -> {
                    List<WebElement> elements = DriverManager.getDriver().findElements(locator);

                    Assert.assertTrue(
                            elements.isEmpty(),
                            String.format("Expected element '%s' (%s) to NOT be present", elementName, locator)
                    );
                }
        );
    }
}
