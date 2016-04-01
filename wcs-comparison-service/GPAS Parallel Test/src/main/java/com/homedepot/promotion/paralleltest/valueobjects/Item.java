package com.homedepot.promotion.paralleltest.valueobjects;

import lombok.Data;

/**
 * Created by ruobinling on 2/26/16.
 */

@Data
public class Item {
    private String store;
    private String itemId;
    private String quantity;
    private String fulfillmentLocation;
    private String fulfillmentMethod;
}
