package com.skyraining.service;

import com.skyraining.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findUsers();

    UserEntity findUserById(Long id);

    Boolean addUser(UserEntity userEntity);

    Boolean modifyByUser(UserEntity userEntity);

    Boolean removeUserById(Long id);

}
