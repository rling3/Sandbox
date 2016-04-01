package com.homedepot.promotion.paralleltest.valueobjects;

import lombok.Data;

import java.util.List;

/**
 * Created by ruobinling on 3/3/16.
 */
@Data
public class LineItem {

    private String lineItemType;
    private String lineItemId;
    private String itemId;
    private String storeSKU;
    private String description;
    private String quantity;
    private String unitPrice;
    private String totalItemPrice;
    private List<Fulfillment> fulfillmentOptions;

}
