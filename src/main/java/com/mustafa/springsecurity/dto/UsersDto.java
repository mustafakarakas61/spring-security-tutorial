package com.mustafa.springsecurity.dto;

import com.mustafa.springsecurity.enm.EnmRole;

public class UsersDto {
    private String username;
    private EnmRole enmRole;

    public UsersDto(String username, EnmRole enmRole) {
        this.username = username;
        this.enmRole = enmRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public EnmRole getEnmRole() {
        return enmRole;
    }

    public void setEnmRole(EnmRole enmRole) {
        this.enmRole = enmRole;
    }
}
