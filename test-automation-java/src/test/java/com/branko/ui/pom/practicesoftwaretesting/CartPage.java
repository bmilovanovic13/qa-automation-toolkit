package com.branko.ui.pom.practicesoftwaretesting;

import com.branko.ui.base.BasePage;
import com.branko.ui.utils.Assertions;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private By productName(String productName) {
        return By.xpath(String.format(
                "//span[@data-test='product-title'][contains(.,'%s')]",
                productName
        ));
    }
    private final By PROCEED_TO_CHECKOUT = By.cssSelector("[data-test='proceed-1']");

    public CartPage verifyProductInCart(String productName){
        Assertions.verifyElementIsDisplayed(productName(productName),productName);
        return this;
    }

    public SignInPage proceedToSignInPage(){
        click(PROCEED_TO_CHECKOUT, "Proceed to checkout button");
        return new SignInPage();
    }
}
