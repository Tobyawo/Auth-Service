package com.cs544.authservice.service;


import com.cs544.authservice.ResponseCodeEnum;
import com.cs544.authservice.client.HttpClient;
import com.cs544.authservice.entity.User;
import com.cs544.authservice.entity.request.LoggedInUser;
import com.cs544.authservice.entity.response.LoginResponse;
import com.cs544.authservice.producer.LoginEventProducer;
import com.cs544.authservice.security.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;


@Service
@Slf4j
public class AuthService {

    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private HttpClient client;

    @Autowired
    private LoginEventProducer loginEventProducer;


    public LoginResponse handleLogin(String email, String password) {
        LoginResponse response;
        LoggedInUser loggedInUser = null;
        String token;
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(email, password);

            Authentication principal = authManager.authenticate(authInputToken);
            if (principal != null) {
                log.info("user {} successfully authenticated", email);
                User user = client.fetchUser(email);
                loggedInUser = LoggedInUser.getInstance(user);

                token = jwtUtil.generateToken(email);
                if (token == null) {
                    log.info("User successfully authenticated but Failed to generate token for {}", email);
                }
            } else {
                return new LoginResponse(ResponseCodeEnum.FAILED_AUTHENTICATION, ResponseCodeEnum.FAILED_AUTHENTICATION.getDescription());
            }

            response = new LoginResponse(ResponseCodeEnum.SUCCESS, ResponseCodeEnum.SUCCESS.getDescription());
            response.setToken(token);
            response.setLoggedInUser(loggedInUser);

            return response;

        } catch (AuthenticationException authExc) {
            log.info("Authentication failed for {}", email, authExc);
            return new LoginResponse(ResponseCodeEnum.FAILED_AUTHENTICATION, "Invalid Login Credentials");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }


}
