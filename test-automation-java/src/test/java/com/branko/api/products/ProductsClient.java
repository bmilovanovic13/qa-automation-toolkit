package com.branko.api.products;

import com.branko.api.core.ApiAssertions;
import com.branko.api.core.RequestHelper;
import com.branko.shared.AllureUtils;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ProductsClient extends RequestHelper {

    private static final String PRODUCTS_ENDPOINT = "/products";

    private String getProductEndpoint(String productId){
        return String.format("%s/%s", PRODUCTS_ENDPOINT, productId);
    }

    private String getProductRelatedEndpoint(String productId){
        return String.format("%s/%s/related", PRODUCTS_ENDPOINT, productId);
    }

    public ProductData getProductInfo(){
        Response response = sendGet(PRODUCTS_ENDPOINT);
        return new ProductData(
                extractFromJsonBody(response,"data[0].id", String.class),
                extractFromJsonBody(response,"data[0].name", String.class),
                extractFromJsonBody(response,"data[0].category.name", String.class),
                extractFromJsonBody(response,"data[0].brand.name", String.class)
        );
    }
     public void getAndVerifyProductDetails(ProductData productData){
        Response response = sendGet(getProductEndpoint(productData.getId()));

        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertField(response, "id", productData.getId(), String.class);
        ApiAssertions.assertField(response, "name", productData.getName(), String.class);
        ApiAssertions.assertFieldIsPositive(response,"price");
        ApiAssertions.assertFieldIsNotNull(response, "in_stock",Boolean.class);
        ApiAssertions.assertField(response, "category.name", productData.getCategoryName(), String.class);
        ApiAssertions.assertField(response, "brand.name", productData.getBrandName(), String.class);
    }

    public void getAndVerifyRelatedProducts(String productId) {
        Response response = sendGet(getProductRelatedEndpoint(productId));

        ApiAssertions.assertStatusCode(response, 200);

        List<Map<String, Object>> relatedProducts = response.jsonPath().getList("");

        assertThat(relatedProducts).isNotEmpty();

        for (Map<String, Object> product : relatedProducts) {
            Object relatedProductId = product.get("id");

            AllureUtils.step("Verify product id is valid", () -> {
                assertThat(relatedProductId)
                        .withFailMessage("Related product id is null")
                        .isNotNull();

                assertThat(relatedProductId.toString())
                        .withFailMessage("Related product '%s' id is blank", product.get("name"))
                        .isNotBlank();
            });

            AllureUtils.step("Verify name is valid", () -> {
                Object name = product.get("name");

                assertThat(name)
                        .withFailMessage("Field '%s' is null", name)
                        .isNotNull();

                assertThat(name.toString())
                        .withFailMessage("Related productId '%s' Name is blank", relatedProductId)
                        .isNotBlank();
            });

            AllureUtils.step("Verify price is valid", () -> {
                Object price = product.get("price");

                assertThat(price)
                        .withFailMessage("Related productId '%s' price is Null", relatedProductId)
                        .isNotNull();

                assertThat(new BigDecimal(price.toString()))
                        .withFailMessage("Related productId '%s' price is not positive, it is '%s'", relatedProductId, price)
                        .isPositive();
            });

            AllureUtils.step("Verify in_stock is valid", () -> {
                assertThat(product.get("in_stock"))
                        .withFailMessage("Related productId '%s' in stock value is Null", relatedProductId)
                        .isNotNull();
            });

            AllureUtils.step("Verify category name is valid", () -> {
                @SuppressWarnings("unchecked")
                Map<String, Object> category = (Map<String, Object>) product.get("category");

                Object categoryName = category.get("name");

                assertThat(categoryName)
                        .withFailMessage("Related productId '%s' category is null")
                        .isNotNull();

                assertThat(category.get("name").toString())
                        .withFailMessage("Related productId '%s' category is blank", relatedProductId)
                        .isNotBlank();
            });

            AllureUtils.step("Verify brand name is valid", () -> {
                @SuppressWarnings("unchecked")
                Map<String, Object> brand = (Map<String, Object>) product.get("brand");

                Object brandName = brand.get("name");

                assertThat(brandName)
                        .withFailMessage("Related productId '%s' brand is null")
                        .isNotNull();

                assertThat(brandName.toString())
                        .withFailMessage("Related productId '%s' brand is blank", relatedProductId)
                        .isNotBlank();
            });
        }
    }

}
