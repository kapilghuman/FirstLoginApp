package com.udemy.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.web.dto.UserDto;
import com.udemy.web.request.UserDetailRequestModel;
import com.udemy.web.response.UserRest;
import com.udemy.web.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping
	public String user()
	{
		return "in get";
	}
	
	@PostMapping 
	public UserRest addUser(@RequestBody UserDetailRequestModel userDetails)
	{
		UserRest returnValue = new UserRest();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails,userDto); //request come into userDetails then we are copying data to userDto to store it in database
		
		UserDto createUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createUser, returnValue);
		return returnValue;
	}

}