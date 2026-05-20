package com.branko.api.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductData {

    private String id;
    private String name;
    private BigDecimal price;
    private String categoryName;
    private String brandName;
}