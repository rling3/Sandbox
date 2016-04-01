package com.homedepot.promotion.paralleltest;

import lombok.Data;

/**
 * Created by ruobinling on 2/26/16.
 */

@Data
public class AuthToken {
    private String encodedActivityToken;
    private String nonTlsEncodedActivityToken;
    private String userId;
    private String logonId;
}
