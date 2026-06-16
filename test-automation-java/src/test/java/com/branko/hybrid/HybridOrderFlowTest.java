package com.branko.hybrid;

import com.branko.api.login.LoginClient;
import com.branko.api.products.ProductData;
import com.branko.api.products.ProductsClient;
import com.branko.ui.base.BaseTest;
import com.branko.ui.pom.practicesoftwaretesting.ProductsPage;
import com.branko.shared.AuthenticationHelper;
import org.testng.annotations.Test;

public class HybridOrderFlowTest extends BaseTest {
    private final LoginClient loginClient = new LoginClient();
    private final ProductsClient productsClient = new ProductsClient();
    @Test(groups = {"hybrid", "smoke-hybrid"}, description = "Verify order can be completed successfully using API authentication and UI checkout flow")
    public void shouldCompleteOrderUsingHybridApiUiFlow(){
        String token = loginClient.loginAsCustomerAndGetToken();

        ProductData productInfo = productsClient.getAvailableProduct();

        String productName = productInfo.getName();
        AuthenticationHelper.loginWithToken(token);
        ProductsPage.open()
                .selectProduct(productName)
                .verifyProductDetailsPage(productName)
                .addProductToCart()
                .goToCart()
                .verifyProductInCart(productName)
                .proceedToSignInPage()
                .verifyUserIsAlreadySignedIn()
                .proceedToBillingPage()
                .verifyBillingPageIsDisplayed()
                .fillBillingDetails("Serbia","11060","13","Test street","Belgrade","Test State")
                .proceedToPaymentPage()
                .verifyPaymentPageIsDisplayed()
                .payWith("Cash on Delivery")
                .verifyPaymentIsSuccessful();

    }
}
