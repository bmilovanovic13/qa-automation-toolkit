package com.branko.ui.pom;

import com.branko.ui.utils.Assertions;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import com.branko.ui.base.BasePage;

public class CheckoutCompletePage extends BasePage {

    private static final By CHECKOUT_COMPLETE_HEADER = By.cssSelector("[data-test='complete-header']");
    private static final By CHECKOUT_COMPLETE_TEXT = By.cssSelector("[data-test='complete-text']");
    private static final By CHECKOUT_COMPLETE_ICON = By.cssSelector("[data-test='pony-express']");
    private static final By BACK_HOME_BUTTON = By.cssSelector("[data-test='back-to-products']");
    private static final String COMPLETE_HEADER_TEXT = "Thank you for your order!";
    private static final String COMPLETE_TEXT = "Your order has been dispatched";
    public void verifyOrderIsComplete() {

        SoftAssert softAssert = new SoftAssert();

        Assertions.verifyTextIsEqual(CHECKOUT_COMPLETE_HEADER, COMPLETE_HEADER_TEXT, softAssert);
        Assertions.verifyTextContains(CHECKOUT_COMPLETE_TEXT, COMPLETE_TEXT, softAssert);
        Assertions.verifyElementIsDisplayed(CHECKOUT_COMPLETE_ICON, "Green checkmark icon", softAssert);
        Assertions.verifyElementIsDisplayed(BACK_HOME_BUTTON, "Back Home button", softAssert);

        softAssert.assertAll();
    }
}
