package com.homedepot.promotion.priceadjust.response;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Krishna
 *
 */ 

@JsonInclude(Include.NON_NULL)  
@Data public class Discdetail {
	private String promoId;
	private String promoType;
	private String promoName;
	private String desc;
	private String discAmt;
	private String couponCode;
}
                  