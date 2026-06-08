package com.branko.api.tests;

import com.branko.api.cart.CartClient;
import com.branko.api.login.LoginClient;
import com.branko.api.payment.PaymentClient;
import com.branko.api.products.ProductData;
import com.branko.api.products.ProductsClient;
import com.branko.api.users.UsersClient;
import org.testng.annotations.Test;

public class OrderTest {

    private final LoginClient loginClient = new LoginClient();
    private final UsersClient usersClient = new UsersClient();
    private final ProductsClient productsClient = new ProductsClient();
    private final CartClient cart = new CartClient();
    private final PaymentClient paymentClient = new PaymentClient();
    @Test(groups = {"api", "smoke-api"}, description = "Verify order can be completed successfully")
    public void shouldCompleteOrderSuccessfully(){

        String token = loginClient.loginAsCustomerAndGetToken();
        usersClient.verifyCustomerIsLoggedIn(token);

        ProductData product = productsClient.getAvailableProduct();
        String cartId = cart.createCart();
        cart.addProductToCart(cartId, product.getId());
        cart.verifyProductDetailsInCart(product,cartId);

        paymentClient.completePaymentWith(paymentClient.creditCard());
    }
}
