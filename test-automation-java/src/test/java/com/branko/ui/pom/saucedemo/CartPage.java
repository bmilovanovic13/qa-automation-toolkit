package com.branko.ui.pom.saucedemo;

import com.branko.ui.base.BasePage;
import com.branko.ui.utils.Assertions;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    // Locators
    private static final By PAGE_TITLE = By.cssSelector("[data-test='title']");
    private By ITEM_NAME(String itemName){
        return By.xpath(String.format(
                "//*[@data-test='inventory-item-name' and normalize-space()='%s']",
                itemName
        ));
    }
    private static final By CHECKOUT_BUTTON = By.id("checkout");

    // Methods
    public CartPage verifyUserIsOnCartPage(){
        Assertions.verifyElementIsDisplayed(PAGE_TITLE, "Your cart");
        Assertions.verifyTextIsEqual(PAGE_TITLE, "Your Cart");
        return this;
    }
    public CartPage verifyProductIsInCart(String itemName){
        Assertions.verifyElementIsDisplayed(ITEM_NAME(itemName),itemName);
        return this;
    }

    public CheckoutBillingDetailsPage proceedToCheckout(){
        click(CHECKOUT_BUTTON,"Checkout button");
     return new CheckoutBillingDetailsPage();
    }
}
