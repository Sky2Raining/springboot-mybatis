package com.skyraining.controller;

import java.util.List;

import com.skyraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skyraining.entity.UserEntity;
import com.skyraining.mapper.UserMapper;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userService.findUsers();
		return users;
	}
	
    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
    	UserEntity user=userService.findUserById(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(UserEntity user) {
        userService.addUser(user);
    }
    
    @RequestMapping(value="update")
    public void update(UserEntity user) {
        userService.modifyByUser(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.removeUserById(id);
    }
    
    
}