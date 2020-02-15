package com.springboot.demo.dao;

import com.springboot.demo.entity.User;
import tk.mybatis.mapper.common.Mapper;


public interface UserDao extends Mapper<User> {

    //User findById(String id);
}
