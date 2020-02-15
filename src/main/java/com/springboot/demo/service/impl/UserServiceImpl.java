package com.springboot.demo.service.impl;

import com.springboot.demo.dao.UserDao;
import com.springboot.demo.entity.User;
import com.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public User save(User user) {
        int i = userDao.insertSelective(user);
        return user;
    }

    @Override
    public User findById(String id) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        List<User> userList = userDao.selectByExample(example);
        return userList.get(0);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> findAll() {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(new User());
        return userDao.selectByExample(example);
    }
}
