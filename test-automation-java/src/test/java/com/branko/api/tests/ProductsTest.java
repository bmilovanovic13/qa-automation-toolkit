package com.branko.api.tests;

import com.branko.api.products.ProductData;
import com.branko.api.products.ProductsClient;
import org.testng.annotations.Test;

public class ProductsTest {

    @Test(groups = {"api", "smoke-api"}, description = "Verify product details are valid")
    public void shouldGetProductSuccessfully(){

        ProductsClient productsClient = new ProductsClient();

        ProductData productInfo = productsClient.getProductInfo();

        productsClient.getAndVerifyProductDetails(productInfo);
    }

    @Test(groups = {"api", "smoke-api"}, description = "Verify related product details are valid")
    public void shouldGetRelatedProductsSuccessfully(){

        ProductsClient productsClient = new ProductsClient();

        ProductData productInfo = productsClient.getProductInfo();

        productsClient.getAndVerifyRelatedProducts(productInfo.getId());
    }
}
