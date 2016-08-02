package com.homedepot.auth;

import lombok.Data;

@Data
public class THDVaultAccessException extends RuntimeException {

    private String msg;
    private Throwable cause;

    public THDVaultAccessException(String msg, Exception e){
        this.cause = e;
        this.msg = msg;
    }

    public THDVaultAccessException(String msg){
        this.msg = msg;
    }
}
