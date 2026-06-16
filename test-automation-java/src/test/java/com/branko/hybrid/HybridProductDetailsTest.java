package com.branko.hybrid;

import com.branko.api.products.ProductData;
import com.branko.api.products.ProductsClient;
import com.branko.ui.base.BaseTest;
import com.branko.ui.pom.practicesoftwaretesting.ProductDetailsPage;
import org.testng.annotations.Test;

public class HybridProductDetailsTest extends BaseTest {
    private final ProductsClient productsClient = new ProductsClient();
    @Test(groups = {"hybrid", "smoke-hybrid"}, description = "Verify product name, price, brand and category match API response")
    public void shouldDisplayProductDetailsMatchingApiData(){
        ProductData expectedProduct = productsClient.getProductInfo();

        ProductDetailsPage.open(expectedProduct.getId())
                .verifyProductDetails(expectedProduct);
    }
}
