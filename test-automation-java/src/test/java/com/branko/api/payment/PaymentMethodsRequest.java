package com.branko.api.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentMethodsRequest {
    private String payment_method;
    private Map<String, Object> payment_details;
}
