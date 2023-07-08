package com.mustafa.springsecurity.controller;

import com.mustafa.springsecurity.dto.UsersDto;
import com.mustafa.springsecurity.entity.Users;
import com.mustafa.springsecurity.repository.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {

    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsersController(UsersRepository usersRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(path = "/")
    public Users addUser(@RequestBody UsersDto usersDto, @RequestParam String password) {
        Users newUser = new Users();
        newUser.setUsername(usersDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(password));
        return usersRepository.save(newUser);
    }

    @GetMapping(path = "/")
    public List<UsersDto> listUser() {
        List<UsersDto> usersDtoList = new ArrayList<>();
        for (Users users :
                usersRepository.findAll()) {
            usersDtoList.add(new UsersDto(users.getUsername(), users.getEnmRole()));
        }

        return usersDtoList;
    }
}
