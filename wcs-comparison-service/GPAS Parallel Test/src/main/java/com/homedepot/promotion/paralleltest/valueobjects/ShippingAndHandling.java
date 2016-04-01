package com.homedepot.promotion.paralleltest.valueobjects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.homedepot.promotion.paralleltest.helper.WcsComparatorDeserializer;
import com.homedepot.promotion.paralleltest.helper.WcsComparatorSerializer;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by ruobinling on 3/3/16.
 */
@Data
public class ShippingAndHandling {
    @JsonDeserialize(using = WcsComparatorDeserializer.class)
    @JsonSerialize(using = WcsComparatorSerializer.class)
    private Date estStartDeliveryDate;
    @JsonDeserialize(using = WcsComparatorDeserializer.class)
    @JsonSerialize(using = WcsComparatorSerializer.class)
    private Date estEndDeliveryDate;
    
}
