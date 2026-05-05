package com.branko.ui.pom;

import org.openqa.selenium.By;
import com.branko.ui.base.BasePage;
import static com.branko.ui.utils.Assertions.*;

public class CheckoutBillingDetailsPage extends BasePage {

    // Locators
    private static final By PAGE_TITLE = By.cssSelector("[data-test='title']");
    public CheckoutBillingDetailsPage verifyUserIsOnCheckoutBillingDetailsPage(){
        verifyElementIsDisplayed(PAGE_TITLE,"Checkout: Your Information");
        verifyTextIsEqual(PAGE_TITLE,"Checkout: Your Information");
        return this;
    }
    private static final By FIRST_NAME_INPUT = By.cssSelector("[data-test='firstName']");
    private static final By LAST_NAME_INPUT = By.cssSelector("[data-test='lastName']");
    private static final By POSTAL_CODE_INPUT = By.cssSelector("[data-test='postalCode']");
    private static final By CONTINUE_BUTTON = By.cssSelector("[data-test='continue']");
    private static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");

    // Methods
    public CheckoutBillingDetailsPage enterBillingDetails(String firstName, String lastName, String postalCode){
        type(FIRST_NAME_INPUT,firstName, "First name field");
        type(LAST_NAME_INPUT,lastName, "Last name field");
        type(POSTAL_CODE_INPUT, postalCode,"Postal code field");
        return this;
    }
    public CheckoutOverviewPage proceedToCheckout(){
        click(CONTINUE_BUTTON,"Continue button");
        return new CheckoutOverviewPage();
    }

    public CheckoutBillingDetailsPage clickContinueExpectingError(){
        click(CONTINUE_BUTTON,"Continue button");
        return new CheckoutBillingDetailsPage();
    }

    public CheckoutBillingDetailsPage verifyFirstNameErrorIsDisplayed(){
        verifyElementIsDisplayed(ERROR_MESSAGE, "Error message");
        verifyTextContains(ERROR_MESSAGE, "First Name is required");
        return new CheckoutBillingDetailsPage();
    }
}
