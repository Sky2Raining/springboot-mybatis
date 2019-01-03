package com.skyraining.mapper;

import java.util.List;

import com.skyraining.entity.UserEntity;

public interface UserMapper {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	int insert(UserEntity user);

	int update(UserEntity user);

	int delete(Long id);

}