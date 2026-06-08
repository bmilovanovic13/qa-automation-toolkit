package com.branko.api.products;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductData {

    private String id;
    private String name;
    private BigDecimal price;
    @JsonProperty("in_stock")
    private boolean inStock;
    private String categoryName;
    private String brandName;
}