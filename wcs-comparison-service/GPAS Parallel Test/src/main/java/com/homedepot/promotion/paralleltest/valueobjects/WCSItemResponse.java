package com.homedepot.promotion.paralleltest.valueobjects;

import lombok.Data;

/**
 * Created by ruobinling on 3/3/16.
 */

@Data
public class WCSItemResponse {
    private String itemId;
    private String quantity;
    private String unitPrice;
    private String totalPrice;

}
