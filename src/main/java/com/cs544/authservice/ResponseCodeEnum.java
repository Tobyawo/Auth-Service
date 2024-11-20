package com.cs544.authservice;

import lombok.Getter;

@Getter
public enum  ResponseCodeEnum implements IResponseCodeEnum {

    SUCCESS(0, "Success"),
    ERROR(-1, "Error"),
    FAILED_AUTHENTICATION(-2, "Failed authentication"),
    INVALID_INPUT(-3, "Invalid input was provided"),
    INACTIVE_ACCOUNT(-4, "Inactive Account"),
    BLACKLISTED_KIT(-5, "Device is blacklisted"),
    INCOMPLETE_BIOMETRICS(-6, "Incomplete biometrics"),
    ACCOUNT_ALREADY_IN_USE(-7, "User account is already in use"),
    SUBSCRIPTION_EXPIRED(-8, "User's subscription has expired"),
    INVALID_ORG_ID(-9, "Invalid orgId was provided"),
    NO_CONCURRENT_SETTINGS(-10, "The provided organization does not have concurrent settings"),
    LOCKED_USER(-11, "This user has been locked"),;

    ResponseCodeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    private int code;
    private String description;

}
