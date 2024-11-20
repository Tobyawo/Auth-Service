package com.cs544.authservice.security;

import com.cs544.authservice.client.HttpClient;
import com.cs544.authservice.entity.Role;
import com.cs544.authservice.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Component
public class EAUserDetailsService implements UserDetailsService {


    @Autowired
    private HttpClient client;

    private User userRes;

    private static final Logger LOGGER = LoggerFactory.getLogger(EAUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {

            LOGGER.info("Trying to findUser with email = " + email);
            userRes = client.fetchUser(email);
        } catch (URISyntaxException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
        // No user found
        if(userRes == null){
            LOGGER.info("Could not findUser with email = " + email);
            throw new UsernameNotFoundException("Could not findUser with email = " + email);}
        // Return a User Details object using the fetched User information
//        User userLogin = userRes;
        return new org.springframework.security.core.userdetails.User(
                email,
                userRes.getPassword(),
                getAuthorities()); // Sets the role of the found user
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> rolesN = userRes.getRoles();

        List<SimpleGrantedAuthority> authories = new ArrayList<>();

        for (Role role : rolesN) {
            authories.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
        }

        return authories;
    }



}
