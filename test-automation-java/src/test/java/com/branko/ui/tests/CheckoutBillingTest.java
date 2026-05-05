package com.branko.ui.tests;

import com.branko.ui.base.BaseTest;
import com.branko.ui.pom.LoginPage;
import org.testng.annotations.Test;

public class CheckoutBillingTest extends BaseTest {

    @Test(groups = {"ui","regression"}, description = "Verify that error is shown when billing details are empty")
    public void shouldShowErrorWhenBillingDetailsAreEmpty(){
        final String productName = "Sauce Labs Backpack";
        LoginPage
                .open()
                .verifyUserIsOnLoginPage()
                .loginAsStandardUser()
                .verifyInventoryPageIsDisplayed()

                .addProductToCart(productName)
                .goToCart()
                .verifyUserIsOnCartPage()
                .verifyProductIsInCart(productName)

                .proceedToCheckout()
                .verifyUserIsOnCheckoutBillingDetailsPage()
                .clickContinueExpectingError()
                .verifyFirstNameErrorIsDisplayed();
    }
}
