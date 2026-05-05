package com.branko.ui.tests;

import com.branko.ui.base.BaseTest;
import com.branko.ui.pom.LoginPage;
import org.testng.annotations.Test;

public class InventoryProductTest extends BaseTest {

    @Test(groups = {"ui", "regression"}, description = "Verify user can add and remove product on Inventory page")
    public void shouldAddAndRemoveProductOnInventoryPage(){
        final String productName = "Sauce Labs Backpack";

        LoginPage
                .open()
                .verifyUserIsOnLoginPage()
                .loginAsStandardUser()
                .verifyInventoryPageIsDisplayed()
                .addProductToCart(productName)
                .verifyNumberInCartBadge("1")
                .verifyRemoveButton(productName)
                .clickRemoveButton(productName)
                .verifyCartBadgeIsNotDisplayed()
                .verifyAddButtonIsDisplayed(productName);
    }
}
