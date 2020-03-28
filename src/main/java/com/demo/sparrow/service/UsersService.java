package com.demo.sparrow.service;

import com.demo.sparrow.datasource.DynamicDataSource;
import com.demo.sparrow.datasource.DynamicDataSourceType;
import com.demo.sparrow.domains.Users;
import com.demo.sparrow.mappers.UsersRespository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersService {

    @Resource
    UsersRespository usersRepository;

    public int insertlUser(){
        Users users = new Users();
        users.setName("王小二");
        users.setEmail("wxe@163.com");
        users.setTelephone("027-8888888");
        return this.usersRepository.insert(users);
    }

    @DynamicDataSource(DynamicDataSourceType.slave)
    public Users getUserById(Long id){
        return this.usersRepository.getUserDetailById(id);
    }
}
