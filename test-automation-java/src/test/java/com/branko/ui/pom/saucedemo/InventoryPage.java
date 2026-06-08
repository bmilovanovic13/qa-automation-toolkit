package com.branko.ui.pom.saucedemo;

import org.openqa.selenium.By;
import com.branko.ui.base.BasePage;

import static com.branko.ui.utils.Assertions.*;

public class InventoryPage extends BasePage {

    // Locators
    private static final By PAGE_TITLE = By.cssSelector("[data-test='title']");
    private static final By SHOPPING_CART_BADGE = By.cssSelector("[data-test='shopping-cart-badge']");

    private By addToCartButton(String productName) {
        String slug = productName.toLowerCase().replace(" ", "-");
        return By.cssSelector("[data-test='add-to-cart-" + slug + "']");
    }

    private By removeButton(String productName) {
        String slug = productName.toLowerCase().replace(" ", "-");
        return By.cssSelector("[data-test='remove-" + slug + "']");
    }

    // Methods
    public InventoryPage verifyInventoryPageIsDisplayed(){
        verifyElementIsDisplayed(PAGE_TITLE, "Product page title");
        verifyTextIsEqual(PAGE_TITLE, "Products");
        return this;
    }

    public InventoryPage addProductToCart(String productName){
        click(addToCartButton(productName),String.format("Add to cart for %s", productName));
        return this;
    }
    public CartPage goToCart() {
        click(SHOPPING_CART_BADGE,"Shopping cart");
        return new CartPage();
    }

    public InventoryPage verifyCartBadgeIsNotDisplayed(){
        verifyElementIsNotDisplayed(SHOPPING_CART_BADGE,"Shopping cart badge");
        return this;
    }
    public InventoryPage verifyNumberInCartBadge(String number){
        verifyTextIsEqual(SHOPPING_CART_BADGE, number);
        return this;
    }

    public InventoryPage verifyRemoveButton(String productName){
        verifyElementIsDisplayed(removeButton(productName),String.format("Remove button for '%s'", productName));
        return this;
    }

    public InventoryPage clickRemoveButton(String productName){
        click(removeButton(productName),String.format("Remove button for '%s'",productName));
        return this;
    }

    public InventoryPage verifyAddButtonIsDisplayed(String productName){
        verifyElementIsDisplayed(addToCartButton(productName),String.format("Add to cart button for '%s'", productName));
        return this;
    }

}
