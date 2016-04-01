package com.homedepot.promotion.paralleltest.helper;

import com.homedepot.promotion.paralleltest.valueobjects.*;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by ruobinling on 3/24/16.
 */
public class ObjectMappingHelper {

    /**
     * Generate a mapping of item ID to its WCS discount details
     * @param wcsCart WCSCart response/request object
     * @return mapping of item ID to its WCS discount
     */
    public static List<WCSItemDiscount> generateWCSDiscountList(WCSCart wcsCart) {

        List<Promotion> promotions = wcsCart.getPromotions();
        List<LineItem> lineItems = wcsCart.getLineItems();
        if (CollectionUtils.isNotEmpty(promotions)) {
            List<WCSItemDiscount> wcsItemDiscounts = new ArrayList<>();
            // Iterate applied promotions
            for (Promotion promotion : promotions) {
                List<LineItemPromotion> lineItemPromotions = promotion.getLineItemPromotions();
                // Construct response for each item with promotion applied
                for (LineItemPromotion lineItemPromotion : lineItemPromotions) {
                    // Find the LineItem corresponding to the ID given by the LineItemPromotion
                    LineItem lineItem = lineItems.stream()
                            .filter(s->s.getLineItemId().equals(lineItemPromotion.getAppliedOn()))
                            .collect(Collectors.toList()).get(0);
                    WCSItemDiscount wcsItemDiscount = new WCSItemDiscount();
                    wcsItemDiscount.setItemId(lineItem.getItemId());
                    wcsItemDiscount.setDiscount(lineItemPromotion.getAppliedDiscount());
                    wcsItemDiscount.setTotal(lineItem.getTotalItemPrice());
                    wcsItemDiscount.setPromotionCode(promotion.getDescription());
                    wcsItemDiscount.setPromotionDesc(promotion.getLongDescription());
                    wcsItemDiscount.setQuantity(lineItem.getQuantity());
                    wcsItemDiscounts.add(wcsItemDiscount);
                }
            }
            return wcsItemDiscounts;
        } else return new ArrayList<>();
    }
}





















