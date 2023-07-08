package com.mustafa.springsecurity.entity;

import com.mustafa.springsecurity.enm.EnmRole;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private EnmRole enmRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EnmRole getEnmRole() {
        return enmRole;
    }

    public void setEnmRole(EnmRole enmRole) {
        this.enmRole = enmRole;
    }
}
