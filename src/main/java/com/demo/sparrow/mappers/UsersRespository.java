package com.demo.sparrow.mappers;

import com.demo.sparrow.domains.Users;

import java.util.List;

public interface UsersRespository {
    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}