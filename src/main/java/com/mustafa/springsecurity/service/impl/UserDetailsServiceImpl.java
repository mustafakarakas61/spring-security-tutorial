package com.mustafa.springsecurity.service.impl;

import com.mustafa.springsecurity.entity.Users;
import com.mustafa.springsecurity.repository.UsersRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;

    public UserDetailsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(username);

        if (users == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(users.getEnmRole().name()));

        return new org.springframework.security.core.userdetails.User(
                users.getUsername(), users.getPassword(),authorities);
    }
}
