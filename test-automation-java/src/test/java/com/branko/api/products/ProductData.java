package com.branko.api.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductData {

    private String id;
    private String name;
    private String categoryName;
    private String brandName;
}