package com.homedepot.promotion.paralleltest.controller;

import com.homedepot.promotion.paralleltest.AuthToken;
import com.homedepot.promotion.paralleltest.helper.ObjectMappingHelper;
import com.homedepot.promotion.paralleltest.valueobjects.Item;
import com.homedepot.promotion.paralleltest.valueobjects.WCSCart;
import com.homedepot.promotion.paralleltest.valueobjects.WCSItemDiscount;
import com.homedepot.promotion.priceadjust.request.CartRequestMapper;
import com.homedepot.promotion.priceadjust.response.CartResponseMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by ruobinling on 3/22/16.
 */
@RestController
public class WCSComparatorController {

    final String WCS_URL = "http://hd-qa72.homedepotdev.com/wcs/resources/api/v2/user/my/cart";
    final String WCS_AUTH_URL = "https://origin.api.hd-qa72.homedepotdev.com/webapp/wcs/stores/servlet/THDAPIController?client_id=internalTest&channel=API&client_type=internal&storeId=10051&langId=-1&response_type=activity&businessChannelId=-10&rememberMe=true";
    final String GPAS_URL = "http://origin-api.gcp-dev.homedepot.com/promotion/price-adjust-service";
    final String GPAS_TEST_URL = "http://localhost:8080/promotions/price-adjust-service";
    final int[] WCS_AUTH_COOKIE_INDICES = {0, 3, 4, 5, 7, 8};

    private RestTemplate restTemplate = new RestTemplate();
    private AuthToken token;
    private HttpHeaders requestHeaders;


    @CrossOrigin(origins = "http://localhost:63343")
    @RequestMapping(value = "/parallelTest/wcs/auth", method = RequestMethod.GET)
    public AuthToken retrieveWCSAuthToken() {
        if (null == requestHeaders) {
            System.out.println("THIS SHOULD ONLY PRINT ONCE ------ NULL HEADERS");
            ResponseEntity<AuthToken> responseEntity = restTemplate.getForEntity(WCS_AUTH_URL, AuthToken.class);
            token = responseEntity.getBody();
            HttpHeaders responseHeaders = responseEntity.getHeaders();
            List<String> responseHeaderCookies = responseHeaders.get("Set-Cookie");
            String cookieHeaderString = "";
            for (int i : WCS_AUTH_COOKIE_INDICES) {
                cookieHeaderString += responseHeaderCookies.get(i).split(";")[0] + "; ";
            }
            requestHeaders = new HttpHeaders();
            requestHeaders.add("Cookie", cookieHeaderString);
            requestHeaders.add("Authorization", token.getNonTlsEncodedActivityToken());
            requestHeaders.add("Content-Type", "application/xml");
        }
        return token;
    }

    @CrossOrigin(origins = "http://localhost:63343")
    @RequestMapping(value = "/parallelTest/gpas/arbitrate", method = RequestMethod.POST, consumes = "application/json")
    public CartResponseMapper callGPAS(@RequestBody CartRequestMapper cartRequestMapper) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        HttpEntity<CartRequestMapper> request = new HttpEntity<>(cartRequestMapper, headers);
        HttpEntity<CartResponseMapper> response = restTemplate.exchange(GPAS_TEST_URL, HttpMethod.POST, request, CartResponseMapper.class);
        return response.getBody();
    }

    @CrossOrigin(origins = "http://localhost:63343")
    @RequestMapping(value = "/parallelTest/wcs/addToCart", method = RequestMethod.POST, consumes="application/json")
    public WCSCart addToWCSCart(@RequestBody List<Item> items) throws IOException {
        StringBuilder addItemRequest = new StringBuilder("<cart>");
        addItemRequest.append("<localStoreId>").append(items.get(0).getStore()).append("</localStoreId>");
        addItemRequest.append(  "<lineItems>");
        for (Item item : items) {
            addItemRequest
                          .append(    "<lineItem>")
                          .append(        "<itemId>").append(item.getItemId()).append("</itemId>")
                          .append(            "<quantity>").append(item.getQuantity()).append("</quantity>")
                          .append(            "<fulfillmentLocation>").append(item.getFulfillmentLocation()).append("</fulfillmentLocation>")
                          .append(            "<fulfillmentMethod>").append(item.getFulfillmentMethod()).append("</fulfillmentMethod>")
                          .append("           </lineItem>");
        }
        addItemRequest.append(" </lineItems>");
        addItemRequest.append("</cart>");
        System.out.println("Request: " + addItemRequest);
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Request headers: " + requestHeaders);
        HttpEntity<String> request = new HttpEntity<>(addItemRequest.toString(), requestHeaders);
        HttpEntity<WCSCart> response = restTemplate.exchange(WCS_URL, HttpMethod.POST, request, WCSCart.class);
        WCSCart wcsCart = response.getBody();
        System.out.println("Response items: " + wcsCart.getLineItems());
        return wcsCart;
    }

    @CrossOrigin(origins = "http://localhost:63343")
    @RequestMapping(value = "/parallelTest/wcs/adjustments", method = RequestMethod.GET)
    public List<WCSItemDiscount> getWcsAdjustments() {
        HttpEntity<String> request = new HttpEntity<>(requestHeaders);
        HttpEntity<WCSCart> response = restTemplate.exchange(WCS_URL, HttpMethod.GET, request, WCSCart.class);
        WCSCart wcsCart = response.getBody();
        return ObjectMappingHelper.generateWCSDiscountList(wcsCart);
    }
}
