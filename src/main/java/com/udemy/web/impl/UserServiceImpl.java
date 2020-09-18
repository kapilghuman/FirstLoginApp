package com.udemy.web.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.web.dto.UserDto;
import com.udemy.web.io.entity.UserEntity;
import com.udemy.web.repo.UserRepository;
import com.udemy.web.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto user) {

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
//		userEntity.setEncryptedPassword("aaa");
		userEntity.setUserId("123");
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		return returnValue;
	}

}
