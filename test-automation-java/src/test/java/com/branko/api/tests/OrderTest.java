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
        //Login
        String token = loginClient.loginAsCustomerAndGetToken();
        usersClient.verifyCustomerIsLoggedIn(token);

        //Add Product to cart
        ProductData productInfo = productsClient.getProductInfo();
        String cartId = cart.createCart();
        cart.addProductToCart(cartId, productInfo.getId());
        cart.verifyProductDetailsInCart(productInfo,cartId);

        //Payment
        paymentClient.completePaymentWith(paymentClient.creditCard());
    }
}
