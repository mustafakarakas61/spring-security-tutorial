package com.mustafa.springsecurity.repository;

import com.mustafa.springsecurity.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);

}
