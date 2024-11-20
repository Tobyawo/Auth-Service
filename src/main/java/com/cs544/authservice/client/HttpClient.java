package com.cs544.authservice.client;

import com.cs544.authservice.entity.User;
import com.cs544.authservice.entity.request.UserRequest;
import com.cs544.authservice.entity.response.UserResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@Component
@Slf4j
public class HttpClient {

    @Autowired
    protected RestTemplate restTemplate;


    @Value("${user-details-url}")
    private String userSignupUrl;


    public User fetchUser(String email) throws URISyntaxException {

        log.info("Fetching user by user email {}, url: {}", email, userSignupUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        List<MediaType> acceptedMediaTypes = new ArrayList<>();
        acceptedMediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(acceptedMediaTypes);

        UserRequest userRequest = new UserRequest();
        userRequest.setEmail(email);
        Gson gson = new Gson();

        HttpEntity<String> entity = new HttpEntity<>(gson.toJson(userRequest), headers);

        ResponseEntity<Object> response = restTemplate.postForEntity(userSignupUrl, entity, Object.class);

        log.info("Response status: {}", response.getStatusCode());


        Object object = response.getBody();

        UserResponse response1 = gson.fromJson(gson.toJson(object), UserResponse.class);

        return response1.getUser();
    }


}
