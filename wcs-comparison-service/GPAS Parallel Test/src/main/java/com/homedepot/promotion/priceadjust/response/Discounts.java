package com.homedepot.promotion.priceadjust.response;

import java.util.List;

import lombok.Data;

/**
 * @author Krishna
 *
 */

@Data
public class Discounts {
	private String totalLineItemDiscAmt;
	private List<Discdetail> discDetails;
}
