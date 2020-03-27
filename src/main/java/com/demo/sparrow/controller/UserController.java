package com.demo.sparrow.controller;

import com.demo.sparrow.domains.Users;
import com.demo.sparrow.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    UsersService usersService;

    public UserController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping("/add")
    public int add(){
        return this.usersService.insertlUser();
    }

    @GetMapping("/{id}")
    public Users getUser(@PathVariable("id") Long id){
        return this.usersService.getUserById(id);
    }
}
