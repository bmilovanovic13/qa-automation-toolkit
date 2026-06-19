package com.branko.api.payment;

import com.branko.api.core.ApiAssertions;
import com.branko.api.core.RequestHelper;
import io.restassured.response.Response;

import java.util.Collections;
import java.util.Map;

public class PaymentClient extends RequestHelper {

    private static final String PAYMENT_ENDPOINT = "/payment/check";

    public PaymentMethodsRequest cashOnDelivery(){
        return new PaymentMethodsRequest(
                "cash-on-delivery",
                Collections.emptyMap()
        );
    }
    public PaymentMethodsRequest creditCard(){
        return new PaymentMethodsRequest(
                "credit-card",
                Map.of(
                        "credit_card_number","1234-1234-1234-1234",
                        "expiration_date","10/2030",
                        "cvv","123",
                        "card_holder_name","John Doe"
                )
        );
    }

    public PaymentMethodsRequest giftCard(){
        return new PaymentMethodsRequest(
                "gift-card",
                Map.of(
                        "gift_card_number","123456789ABCdefg",
                        "validation_code","1234"
                )
        );
    }
    public PaymentMethodsRequest buyNowPayLater(){
        return new PaymentMethodsRequest(
                "buy-now-pay-later",
                Map.of(
                        "monthly_installments","3"
                )
        );
    }

    public PaymentMethodsRequest bankTransfer(){
        return new PaymentMethodsRequest(
                "bank-transfer",
                Map.of(
                        "bank_name","Test Bank",
                        "account_name","Test account",
                        "account_number","12345"
                )
        );
    }

    public void completePaymentWith(PaymentMethodsRequest paymentMethod){
        Response response = sendPost(PAYMENT_ENDPOINT, paymentMethod);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertField(response, "message", "Payment was successful", String.class);
    }
}
