package com.renfo.product.productPriceIncrement.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ProductDto {
    Integer productId;
    String productName;
    Integer productPrice;
    Date creationDate;
}
