package com.homedepot.promotion.priceadjust.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.homedepot.promotion.priceadjust.request.Couponcode;

import lombok.Data;

/**
 * @author Krishna
 *
 */
@JsonInclude(Include.NON_NULL)  
@Data public class CartResponse {
	private String custId;
	private String orderId;
	private String custType;
	private String email;
	private String pmtType;
	private List<ResponseItem> items;
    private List<Couponcode> coupons;
}
