package com.homedepot.promotion.priceadjust.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.homedepot.promotion.common.Item;

import lombok.Data;

/**
 * @author Krishna
 *
 */
@JsonInclude(Include.NON_NULL)  
@Data public class ResponseItem extends Item{
	private Discounts discounts;
}
