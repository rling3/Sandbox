package com.homedepot.auth;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

@Component
public class VaultImpl {

    RestTemplate restTemplate = new RestTemplate();
    private String vaultLogin = "127.0.0.1/login";
    private String vaultAddr = "127.0.0.1";

    private String getLocalMACAddress() {
        InetAddress ip;
        String address = "";

        int retryCounter = 0;
        while (retryCounter < 5) {
            try {
                ip = InetAddress.getLocalHost();
                NetworkInterface network = NetworkInterface.getByInetAddress(ip);
                byte[] mac = network.getHardwareAddress();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                }
                address = sb.toString();
            } catch (UnknownHostException | SocketException e) {
                retryCounter++;
                if (retryCounter == 3) {
                    throw new THDVaultAccessException("Failed to initialize connection with THD Vault for retrieving secret credentials. Exception while retrieving MAC address.", e);
                }
            }
        }
        if (!StringUtils.isEmpty(address)) {
            return address;
        } else throw new THDVaultAccessException("Failed to initialize connection with THD Vault for retrieving secret credentials. Returned MAC address was empty.");
    }

    public String vaultLogin(String appId, String userId){
        String request = "{\"Appid\":\"" + appId + "\",\"userId\":\"" + userId + "\"}";
        VaultLoginResponse response = null;

        int retryCounter = 0;
        while (retryCounter < 5) {
            try {
                response = restTemplate.postForObject(vaultLogin, request, VaultLoginResponse.class, new Object());
            } catch (HttpServerErrorException e) {
                retryCounter++;
                if (retryCounter == 3) {
                    throw new THDVaultAccessException("Failed to initialize connection with THD Vault for retrieving secret credentials. Exception while logging into Vault.", e);
                }
            }
        }
        if (!StringUtils.isEmpty(response)) {
            return response.getAuth().getClient_token();
        } else throw new THDVaultAccessException("Failed to initialize connection with THD Vault for retrieving secret credentials. Returned Vault token was empty.");
    }

    public THDCredentials getCredentials(String token) {

        return null;

    }
}
