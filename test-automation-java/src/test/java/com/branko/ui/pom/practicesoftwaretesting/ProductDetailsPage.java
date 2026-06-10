package com.branko.ui.pom.practicesoftwaretesting;

import com.branko.ui.base.BasePage;
import com.branko.ui.utils.Assertions;
import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage {

    private final By PRODUCT_NAME = By.cssSelector("[data-test='product-name']");
    private final By ADD_PRODUCT_TO_CART = By.cssSelector("[data-test='add-to-cart']");
    private final By GO_TO_CART_BUTTON = By.cssSelector("[data-test='nav-cart']");

    public ProductDetailsPage verifyProductDetailsPage(String productName){
        Assertions.verifyTextContains(PRODUCT_NAME, productName);
        return this;
    }

    public ProductDetailsPage addProductToCart(){
        click(ADD_PRODUCT_TO_CART, "Add to cart");
        return this;
    }

    public CartPage goToCart(){
        click(GO_TO_CART_BUTTON, "Cart icon");
        return new CartPage();
    }
}
