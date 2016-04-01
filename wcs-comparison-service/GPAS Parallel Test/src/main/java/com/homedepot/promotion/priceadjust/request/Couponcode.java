package com.homedepot.promotion.priceadjust.request;

import lombok.Data;

/**
 * @author Krishna
 *
 */
@Data public class Couponcode {
	private String value;
	private String type;
	private String status;
	private String source;
	private String message;
}
