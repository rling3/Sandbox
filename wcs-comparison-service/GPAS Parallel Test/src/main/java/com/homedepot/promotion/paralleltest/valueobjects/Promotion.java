package com.homedepot.promotion.paralleltest.valueobjects;

import lombok.Data;

import java.util.List;

/**
 * Created by ruobinling on 3/22/16.
 */
@Data
public class Promotion {

    private String description;
    private String longDescription;
    private String promotionType;
    private String appliedDiscount;
    private List<LineItemPromotion> lineItemPromotions;

}
