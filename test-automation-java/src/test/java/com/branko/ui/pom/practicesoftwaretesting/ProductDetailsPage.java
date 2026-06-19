package com.branko.ui.pom.practicesoftwaretesting;

import com.branko.api.products.ProductData;
import com.branko.shared.Config;
import com.branko.shared.ConfigKey;
import com.branko.ui.base.BasePage;
import com.branko.ui.driver.DriverManager;
import com.branko.ui.utils.Assertions;
import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage {

    private final By PRODUCT_NAME = By.cssSelector("[data-test='product-name']");
    private final By ADD_PRODUCT_TO_CART = By.cssSelector("[data-test='add-to-cart']");
    private final By GO_TO_CART_BUTTON = By.cssSelector("[data-test='nav-cart']");
    private final By PRODUCT_PRICE = By.cssSelector("[data-test='unit-price']");
    private final By PRODUCT_CATEGORY = By.cssSelector("[aria-label='category']");
    private final By PRODUCT_BRAND = By.cssSelector("[aria-label='brand']");

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

    public static ProductDetailsPage open(String productId){
        DriverManager.getDriver().get(Config.get(ConfigKey.QA_PRACTICE_BASE_URL) + "/product/" + productId);
        return new ProductDetailsPage();
    }

    private void verifyProductPrice(String price){
        Assertions.verifyTextContains(PRODUCT_PRICE, price);
    }

    private void verifyProductBrand(String brand){
        Assertions.verifyTextContains(PRODUCT_BRAND, brand);
    }

    private void verifyProductCategory(String category){
        Assertions.verifyTextContains(PRODUCT_CATEGORY, category);
    }

    public ProductDetailsPage verifyProductDetails(ProductData product) {
        verifyProductDetailsPage(product.getName());
        verifyProductPrice(product.getPrice().toString());
        verifyProductBrand(product.getBrandName());
        verifyProductCategory(product.getCategoryName());
        return this;
    }
}
