package com.udemy.web.repo;

import org.springframework.data.repository.CrudRepository;

import com.udemy.web.io.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long > {
	
	UserEntity findUserByEmail(String email);
}
