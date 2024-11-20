package com.cs544.authservice.entity.request;


import com.cs544.authservice.entity.Role;
import com.cs544.authservice.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public record LoggedInUser (
     String email,
     String firstName,
     String lastName,
     boolean enabled,
     List<String> roles
    ){


    public static LoggedInUser getInstance(User user ){
        List<String> userRoles = new ArrayList<>();
        if(user.getRoles() != null){
            userRoles = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
        }
        return new LoggedInUser(user.getEmail(), user.getFirstName(), user.getLastName(), user.isEnabled(), userRoles);

    }
}
