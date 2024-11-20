package com.cs544.authservice.entity.request;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String email;
    private String password;
}
