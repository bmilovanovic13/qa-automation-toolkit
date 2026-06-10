package com.branko.ui.pom.practicesoftwaretesting;

import com.branko.ui.base.BasePage;
import com.branko.ui.utils.Assertions;
import org.openqa.selenium.By;

public class SignInPage extends BasePage {

    private final By LOGGED_IN_MESSAGE = By.xpath("//p[contains(normalize-space(),'you are already logged in')]");
    private final By PROCEED_TO_CHECKOUT = By.cssSelector("[data-test='proceed-2']");

    public SignInPage verifyUserIsAlreadySignedIn(){
        Assertions.verifyElementIsDisplayed(LOGGED_IN_MESSAGE, "You are already logged in");
        return this;
    }

    public BillingPage proceedToBillingPage(){
        click(PROCEED_TO_CHECKOUT, "Proceed to checkout button");
        return new BillingPage();
    }
}
