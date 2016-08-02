package com.homedepot.auth;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Auth {

    private String client_token;
    private List<String> policies;
    private Map<String, String> metadata;
    private long lease_duration;
    private Boolean renewable;
}
