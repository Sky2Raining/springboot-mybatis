package com.skyraining.service.impl;

import com.skyraining.entity.UserEntity;
import com.skyraining.mapper.UserMapper;
import com.skyraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> findUsers() {
        return userMapper.getAll();
    }

    @Override
    public UserEntity findUserById(Long id) {
        return userMapper.getOne(id);
    }

    @Override
    public Boolean addUser(UserEntity userEntity) {
        return userMapper.insert(userEntity) > 0;
    }

    @Override
    public Boolean modifyByUser(UserEntity userEntity) {
        return userMapper.update(userEntity) > 0;
    }

    @Override
    public Boolean removeUserById(Long id) {
        return userMapper.delete(id) > 0;
    }
}
