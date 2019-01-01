package com.skyraining.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skyraining.entity.UserEntity;
import com.skyraining.enums.UserSexEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper UserMapper;

	@Test
	public void testInsert() throws Exception {
		UserMapper.insert(new UserEntity("aa1", "a123456", UserSexEnum.MAN, "aa"));
		UserMapper.insert(new UserEntity("bb1", "b123456", UserSexEnum.WOMAN, "bb"));
		UserMapper.insert(new UserEntity("cc1", "b123456", UserSexEnum.WOMAN, "cc"));

		Assert.assertEquals(3, UserMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = UserMapper.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users.toString());
		}
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.getOne(1l);
		System.out.println(user.toString());
		user.setNickName("skyraining");
		UserMapper.update(user);
		Assert.assertTrue(("skyraining".equals(UserMapper.getOne(1l).getNickName())));
	}

}