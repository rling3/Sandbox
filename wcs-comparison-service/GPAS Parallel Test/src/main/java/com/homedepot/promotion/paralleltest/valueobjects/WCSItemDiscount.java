package com.homedepot.promotion.paralleltest.valueobjects;

import lombok.Data;

/**
 * Created by ruobinling on 3/24/16.
 */
@Data
public class WCSItemDiscount {
    private String itemId;
    private String discount;
    private String total;
    private String promotionDesc;
    private String promotionCode;
    private String quantity;
}
