package com.branko.api.tests;

import com.branko.api.cart.CartClient;
import com.branko.api.products.ProductData;
import com.branko.api.products.ProductsClient;
import org.testng.annotations.Test;

public class CartTest {
    ProductsClient productsClient = new ProductsClient();
    CartClient cart = new CartClient();

    @Test(groups = {"api", "smoke-api"}, description = "Verify product is added to cart successfully")
    public void shouldAddProductsToCartSuccessfully(){
        ProductData productInfo = productsClient.getProductInfo();

        String cartId = cart.createCart();

        cart.addProductToCart(cartId, productInfo.getId());

        cart.verifyProductDetailsInCart(productInfo,cartId);
    }

    @Test(groups = {"api", "smoke-api"}, description = "Verify product can be deleted from cart successfully")
    public void shouldDeleteProductFromCartSuccessfully(){
        ProductData productInfo = productsClient.getProductInfo();

        String cartId = cart.createCart();
        String productId = productInfo.getId();

        cart.addProductToCart(cartId, productId);
        cart.verifyProductDetailsInCart(productInfo,cartId);

        cart.deleteProductFromCart(cartId, productId);
        cart.verifyCartIsEmpty(cartId);
    }
}