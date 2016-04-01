package com.homedepot.promotion.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
* @author Krishna
* 
*/ 

public class PromotionConstants {

	public static final String HDUS_STORE= "hdus";
	public static final String STATUS_ACTIVE = "active";
	public static final String STATUS_INACTIVE = "inactive";
	public static final int ACTIVE = 1;
	public static final int INACTIVE = 0;
	public static final String AM = "AM";
	public static final String PM = "PM";
	public static final int TWELEVE_HR_INCREMETER = 12;
	public static final String REDEMPTION_QP = "Qualifying purchase";
	public static final String REDEMPTION_RPC = "Requires promotion codes";
	public static final int CD_REQUIRED_QP = 0;
	public static final int CD_REQUIRED_RPC = 1;
	public static final String LAST_UPDATED_BY_UI = "Promotion Admin Service";
	public static final String COMBINATION_C = "Combine with other promotions";
	public static final String COMBINATION_G = "'Exclusive within the same group";
	public static final String COMBINATION_O = "Exclusive within an order";
	public static final int EXCLUSIVE_C = 0;
	public static final int EXCLUSIVE_G = 1;
	public static final int EXCLUSIVE_O = 2;
	public static final String PROMODEF_SCHEMA_ACTION_CREATE="create";
	public static final String PROMODEF_SCHEMA_VERSION ="V0.1";
	public static final String PROMOTYPE_PERCENTAGE ="PERCNTOFF";
	public static final String PROMOTYPE_AMOUNT="AMTOFF";
	public static final String ATTR_GRP_PATH = "/attributes?group=promotions";
	public static final String CATEGORY_GUID = "WEB_HIERARCHY_PATH";
	public static final String UOM_QUANTITY = "Quantity";
	public static final String UOM_AMOUNT = "Amount";
    public static final String QUERY_PARAM_PRODUCTID = "&productId=";
    public static final String QUERY_PARAM_CODE = "&code=";

	/*Mfg Brand
	THD Browse OnlineStatus
	BOPIS eligible
	THD Dot Com OnlineStatus
	Saving Center
	Online Purchase Item Limit
	Do Not Turn Online Until Flag
	Hide SKU on Web Site
	Vendor Processing Days
	Item Level Free Ship
	EligibleFreeShip
	Back Orders Allowed
	Orders Limits*/
	public static final Map<String, String> ATTR_NAME_GUID_MAP;
	static
	{
	Map<String, String> enumMap = new HashMap<String, String>();
	 
	enumMap.put("MFG Brand Name", "29d438d9-64f2-4623-8f4e-09f9368e93bb");
	//THD Browse OnlineStatus
	enumMap.put("bopis eligible", "d9fd4421-ab85-4015-a228-fb2d2e4f9081");
	//THD Dot Com OnlineStatus
	enumMap.put("THD ONLINE STATUS", "f6ef55f4-9f5b-46d9-869d-40b671d668c1");
	enumMap.put("SAVINGS CENTER", "9e55d09e-6f22-4884-af64-3e86942266b2");
	enumMap.put("Online Purchase Item Limit", "8cac27a4-bef6-419f-9958-3f3ad37f22ec");
	// Do Not Turn Online Until Flag
	enumMap.put("Hide SKU on Web Site", "3099803b-b76a-4abb-a364-f5f8bf8308c8");
	enumMap.put("Vendor Processing Days", "a91fa6bd-c9c5-43b5-a05b-87607b5c15a2");
	//Item Level Free Ship
	enumMap.put("EligibleFreeShip", "19e476b8-e751-4b8d-b372-d4d2b62b6a21");
	enumMap.put("BackOrdersAllowed", "82904470-0dbd-4e33-a681-6fef5e2992fe");
	//Orders Limits
	 
	ATTR_NAME_GUID_MAP = Collections.unmodifiableMap(enumMap);
	}
}
