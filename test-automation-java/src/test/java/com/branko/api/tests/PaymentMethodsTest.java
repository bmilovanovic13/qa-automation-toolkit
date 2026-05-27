package com.branko.api.tests;

import com.branko.api.payment.PaymentClient;
import org.testng.annotations.Test;

public class PaymentMethodsTest {

    private final PaymentClient paymentClient = new PaymentClient();
    @Test(groups = {"api", "smoke-api"}, description = "Verify payment method cash on delivery can be processed")
    public void shouldProcessCashOnDeliveryPayment(){
        paymentClient.completePaymentWith(paymentClient.cashOnDelivery());
    }

    @Test(groups = {"api", "smoke-api"}, description = "Verify payment method credit card can be processed")
    public void shouldProcessCreditCardPayment(){
        paymentClient.completePaymentWith(paymentClient.creditCard());
    }

    @Test(groups = {"api", "smoke-api"}, description = "Verify payment method gift card can be processed")
    public void shouldProcessGiftCardPayment(){
        paymentClient.completePaymentWith(paymentClient.giftCard());
    }
    @Test(groups = {"api", "smoke-api"}, description = "Verify payment method buy now pay later can be processed")
    public void shouldProcessBuyNowPayLaterPayment(){
        paymentClient.completePaymentWith(paymentClient.buyNowPayLater());
    }

    @Test(groups = {"api", "smoke-api"}, description = "Verify payment method bank transfer can be processed")
    public void shouldProcessBankTransferPayment(){
        paymentClient.completePaymentWith(paymentClient.bankTransfer());
    }
}
