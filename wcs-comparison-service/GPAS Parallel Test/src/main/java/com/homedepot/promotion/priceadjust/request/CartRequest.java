package com.homedepot.promotion.priceadjust.request;

import java.util.List;

import lombok.Data;

/**
 * @author Krishna
 *
 */
@Data public class CartRequest {
	private String custId;
	//mandatory
	private String orderId;
	private String custType;
	private String email;
	private String pmtType;
	private List<RequestItem> items;
	private List<Couponcode> coupons;
	private String evalOrdPromo;
}
