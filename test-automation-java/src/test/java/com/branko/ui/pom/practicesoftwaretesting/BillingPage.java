package com.branko.ui.pom.practicesoftwaretesting;

import com.branko.ui.base.BasePage;
import com.branko.ui.utils.Assertions;
import org.openqa.selenium.By;

public class BillingPage extends BasePage {

    private final By BILLING_ADDRESS_TITLE = By.xpath("//h3[normalize-space()='Billing Address']");
    private final By COUNTRY_DROPDOWN = By.cssSelector("[data-test='country']");
    private By option(String option) {
        return By.xpath(String.format(
                "//option[normalize-space()='%s']",
                option
        ));
    }
    private final By POSTAL_CODE = By.cssSelector("[data-test='postal_code']");
    private final By HOUSE_NUMBER = By.cssSelector("[data-test='house_number']");
    private final By STREET = By.cssSelector("[data-test='street']");
    private final By CITY = By.cssSelector("[data-test='city']");
    private final By STATE = By.cssSelector("[data-test='state']");
    private final By PROCEED_TO_CHECKOUT = By.cssSelector("[data-test='proceed-3']");

    public BillingPage  verifyBillingPageIsDisplayed(){
        Assertions.verifyElementIsDisplayed(BILLING_ADDRESS_TITLE, "Billing address");
        return this;
    }
    public BillingPage fillBillingDetails(String country, String postalCode, String houseNumber, String street, String city, String state){
        click(COUNTRY_DROPDOWN, "Country dropdown");
        click(option(country), country);
        type(POSTAL_CODE, postalCode, "Postal code");
        type(HOUSE_NUMBER, houseNumber, "House number");
        type(STREET, street, "Street");
        type(CITY, city, "City");
        type(STATE, state, "State");
        return this;
    }

    public PaymentPage proceedToPaymentPage(){
        click(PROCEED_TO_CHECKOUT, "Proceed to checkout button");
        return new PaymentPage();
    }
}
