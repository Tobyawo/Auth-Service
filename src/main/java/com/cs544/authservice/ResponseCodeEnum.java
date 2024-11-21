package com.cs544.authservice;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum implements IResponseCodeEnum {

    SUCCESS(0, "Success"),
    FAILED_AUTHENTICATION(-2, "Failed authentication");

    ResponseCodeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    private int code;
    private String description;

}
