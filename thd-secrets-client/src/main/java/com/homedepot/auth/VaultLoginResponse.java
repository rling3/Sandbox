package com.homedepot.auth;

import lombok.Data;

@Data
public class VaultLoginResponse {
    private String lease_id;
    private Boolean renewable;
    private long lease_duration;
    private String data;
    private String warnings;
    private Auth auth;

    public static void main(String[] args){

    }
}
