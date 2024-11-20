package com.cs544.authservice.producer;

import lombok.Data;

@Data
public class LoginEvent {
    private String username;
    private String loginTime;

}

