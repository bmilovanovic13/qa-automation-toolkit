package com.branko.ui.tests.saucedemo;

import com.branko.ui.base.BaseTest;
import com.branko.ui.pom.saucedemo.LoginPage;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {

    @Test(groups = {"ui","smoke"}, description = "Verify that user can complete an order successfully from inventory to checkout")
    public void shouldOrderSuccessfully(){
        final String productName = "Sauce Labs Backpack";
        final String paymentType = "SauceCard";
        final String shippingType = "Free Pony Express";
        final String total = "$32.39";
        final String firstName = "Branko";
        final String lastName = "Milovanovic";
        final String zip = "11060";

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

                .enterBillingDetails(firstName, lastName, zip)
                .proceedToCheckout()
                .verifyUserIsOnCheckoutStepTwoPage()

                .verifyProduct(productName)
                .verifyOrderDetails(paymentType, shippingType, total)
                .completeOrder()

                .verifyOrderIsComplete();
    }
}
