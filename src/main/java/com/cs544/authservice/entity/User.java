package com.cs544.authservice.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Integer id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String photos;

    private boolean enabled;

    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", + password " + password + " firstName=" + firstName + ", lastName=" + lastName
                + ", roles=" + roles + "]";
    }

}