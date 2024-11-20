package com.cs544.authservice.controllers;


import com.cs544.authservice.entity.request.LoginRequestDto;
import com.cs544.authservice.entity.response.LoginResponse;
import com.cs544.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth")
public class AuthController {


   @Autowired
   private AuthService service;


    @PostMapping()
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto loginRequestDto){
        LoginResponse response = service.handleLogin(loginRequestDto.getEmail(),
                loginRequestDto.getPassword());
        return ResponseEntity.ok(response);
    }


}
