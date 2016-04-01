package com.homedepot.promotion.paralleltest.valueobjects;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by ruobinling on 3/3/16.
 */
@Data
@XmlRootElement(name = "cart")
public class WCSCart {

    private String cartId;
    private String userId;
    private String localStoreId;
    private String merchandiseItemsSubTotal;
    private String merchandiseItemsGrandTotal;
    private String cartTotal;
    private String currency;
    private String totalItemCount;
    private List<Adjustment> cartAdjustments;
    private List<Message> messages;
    private List<Promotion> promotions;
    @JacksonXmlElementWrapper(useWrapping = true)
    private List<LineItem> lineItems;
}
