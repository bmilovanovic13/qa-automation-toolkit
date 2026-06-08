package com.branko.api.tests;

import com.branko.api.cart.CartClient;
import com.branko.api.products.ProductData;
import com.branko.api.products.ProductsClient;
import org.testng.annotations.Test;

public class CartTest {
    private final ProductsClient productsClient = new ProductsClient();
    private final CartClient cart = new CartClient();

    @Test(groups = {"api", "smoke-api"}, description = "Verify product is added to cart successfully")
    public void shouldAddProductsToCartSuccessfully(){
        ProductData product = productsClient.getAvailableProduct();

        String cartId = cart.createCart();

        cart.addProductToCart(cartId, product.getId());

        cart.verifyProductDetailsInCart(product,cartId);
    }

    @Test(groups = {"api", "smoke-api"}, description = "Verify product can be deleted from cart successfully")
    public void shouldDeleteProductFromCartSuccessfully(){
        ProductData product = productsClient.getAvailableProduct();

        String cartId = cart.createCart();

        cart.addProductToCart(cartId, product.getId());
        cart.verifyProductDetailsInCart(product,cartId);

        cart.deleteProductFromCart(cartId, product.getId());
        cart.verifyCartIsEmpty(cartId);
    }
}