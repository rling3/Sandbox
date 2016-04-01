package com.homedepot.promotion.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * @author Krishna
 *
 */
@JsonInclude(Include.NON_NULL)  
@Data
public class Item {
	//mandatory
	private String itemId;
	//mandatory
	private String refId;
	//mandatory
	private String qty;
	//mandatory
	private String price;
	private String store;
	private String channel;
	private boolean hasDisc;
}
