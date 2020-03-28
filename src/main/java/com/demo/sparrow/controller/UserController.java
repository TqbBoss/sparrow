package com.demo.sparrow.controller;

import com.demo.sparrow.domains.UserDetail;
import com.demo.sparrow.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "user", tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    UsersService usersService;

    public UserController(UsersService usersService){
        this.usersService = usersService;
    }

    @ApiOperation(value = "添加用户")
    @GetMapping("/add")
    public int add(){
        return this.usersService.insertlUser();
    }

    @ApiOperation(value = "查询用户信息", notes = "根据id查询用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "Long", example = "1")
    @GetMapping("/{id}")
    public UserDetail getUser(@PathVariable("id") Long id){
        return this.usersService.getUserById(id);
    }
}
