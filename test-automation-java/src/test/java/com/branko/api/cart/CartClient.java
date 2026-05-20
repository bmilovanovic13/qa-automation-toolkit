package com.branko.api.cart;

import com.branko.api.core.ApiAssertions;
import com.branko.api.core.RequestHelper;
import com.branko.api.products.ProductData;
import io.restassured.response.Response;

import java.util.Collections;
import java.util.Map;

public class CartClient extends RequestHelper {

    private final String CARTS_ENDPOINT = "/carts";
    private String cartEndpoint(String id){
        return String.format("%s/%s", CARTS_ENDPOINT, id);
    }
    private String deleteProductFromCartEndpoint(String cartId, String productId){
        return String.format("%s/%s/product/%s", CARTS_ENDPOINT, cartId, productId);
    }

    private  String cartItemPath(String field){
        return String.format("%s[0].%s", "cart_items", field);
    }

    public String createCart(){
        Response response = sendPost(CARTS_ENDPOINT, Collections.emptyMap());
        ApiAssertions.assertStatusCode(response, 201);
        return response.jsonPath().get("id");
    }

    public void addProductToCart(String cartId, String productId){
        Map<String, Object> body = Map.of(
                "product_id", productId,
                "quantity", 2
        );
       Response response =  sendPost(cartEndpoint(cartId), body);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertField(response, "result","item added or updated", String.class);
    }

    public void verifyProductDetailsInCart(ProductData productData, String cartId){
        Response response = sendGet(cartEndpoint(cartId));
        ApiAssertions.assertFieldNotBlank(response, "id");
        ApiAssertions.assertFieldIsNotEmpty(response, "cart_items");
        ApiAssertions.assertFieldNotBlank(response, cartItemPath("id"));
        ApiAssertions.assertField(response, cartItemPath("quantity"),2, Integer.class);
        ApiAssertions.assertField(response, cartItemPath("cart_id"), response.jsonPath().getString("id"), String.class);
        ApiAssertions.assertField(response, cartItemPath("product_id"),productData.getId(), String.class);
        ApiAssertions.assertField(response, cartItemPath("product.name"),productData.getName(), String.class);
        ApiAssertions.assertFieldIsPositive(response, cartItemPath("product.price"));
        ApiAssertions.assertFieldIsNotNull(response, cartItemPath("product.in_stock"), Boolean.class);
    }

    public void deleteProductFromCart(String cartId, String productId){
        Response response = sendDelete(deleteProductFromCartEndpoint(cartId, productId));
        ApiAssertions.assertStatusCode(response, 204);
    }

    public void verifyCartIsEmpty(String cartId){
        Response response = sendGet(cartEndpoint(cartId));
        ApiAssertions.assertFieldIsEmpty(response, "cart_items");
    }
}
