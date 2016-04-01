package com.homedepot.promotion.paralleltest.valueobjects;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

/**
 * Created by ruobinling on 3/3/16.
 */
@Data
public class Fulfillment {

    @JacksonXmlProperty(isAttribute = true)
    private Boolean selected;
    private String fulfillmentMethod;
    private ShippingAndHandling shippingAndHandling;
    private ScheduleDeliveryAndHandling scheduleDeliveryAndHandling;
    
}
