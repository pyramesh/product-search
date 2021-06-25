package com.example.exception;

import lombok.*;

import java.io.Serializable;

/**
 * @author Ramesh.Yaleru on 6/25/2021
 */
@Getter
@Setter
@Builder
public class ErrorMessage implements Serializable {
    private String errorCode;
    private String messageEn;
    private String messageAr;

    ErrorMessage(){

    }
    public ErrorMessage(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.messageEn = errorMessage;
    }

    public ErrorMessage(String errorCode, String errorMessageEn, String errorMessageAr) {
        this.errorCode = errorCode;
        this.messageEn = errorMessageEn;
        this.messageAr = errorMessageAr;
    }
}
