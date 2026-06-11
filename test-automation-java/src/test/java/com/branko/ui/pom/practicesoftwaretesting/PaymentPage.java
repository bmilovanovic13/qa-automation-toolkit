package com.branko.ui.pom.practicesoftwaretesting;

import com.branko.ui.base.BasePage;
import com.branko.ui.utils.Assertions;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {

    private final By PAYMENT_TITLE = By.xpath("//h3[normalize-space()='Payment']");
    private final By PAYMENT_METHOD_DROPDOWN = By.cssSelector("[data-test='payment-method']");
    private By paymentOption(String option) {
        return By.xpath(String.format(
                "//option[normalize-space()='%s']",
                option
        ));
    }
    private final By CONFIRM_BUTTON = By.cssSelector("[data-test='finish']");
    private final By PAYMENT_SUCCESS_MESSAGE = By.cssSelector("[data-test='payment-success-message']");

    public PaymentPage verifyPaymentPageIsDisplayed(){
        Assertions.verifyElementIsDisplayed(PAYMENT_TITLE, "Payment title");
        return this;
    }

    public PaymentPage payWith(String option){
        click(PAYMENT_METHOD_DROPDOWN, "Payment method dropdown");
        click(paymentOption(option),option);
        click(CONFIRM_BUTTON, "Confirm button");
        return this;
    }

    public void verifyPaymentIsSuccessful(){
        Assertions.verifyElementIsDisplayed(PAYMENT_SUCCESS_MESSAGE,"Payment was successful");
    }
}
