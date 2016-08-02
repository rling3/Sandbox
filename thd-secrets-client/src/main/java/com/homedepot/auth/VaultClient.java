package com.homedepot.auth;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class VaultClient {

    @Autowired
    VaultImpl vault;

    private static String token;

    public String getCredentials(String appId, String userId){
        /**
         * 1. Login to Vault and get token (with hashed IP)
         * 2. Get credentials with token
         */
        token = vault.vaultLogin(appId, userId);
        THDCredentials credentials = vault.getCredentials(token);
        return "";
    }

    public static void main(String[] args) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");

        SecretKeySpec secret_key = new SecretKeySpec("127.0.0.1".getBytes(), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        String hash = Base64.encodeBase64String(sha256_HMAC.doFinal("test".getBytes("UTF-8")));
        String hash2 = "qbty0DbOLbBeWJOIIxvtSEP798Rw+ruxZUJftQULdB4=% ".trim();
        System.out.println(hash);
        System.out.println(hash2);
        System.out.println(hash.equals(hash2));
    }
}
