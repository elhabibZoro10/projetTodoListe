package com.todo.demo.services.impl;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.demo.entities.User;
import com.todo.demo.repositories.UserRepository;
import com.todo.demo.services.UserService;
import com.todo.demo.shared.dto.UserDto;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;

	
	@Override
	public UserDto signUp(UserDto userDto) {
		User user = new User();
        BeanUtils.copyProperties(userDto,user);
        User savedUser = userRepository.save(user);
        UserDto savedUserDto = new UserDto();
        BeanUtils.copyProperties(savedUser, savedUserDto);
		return savedUserDto;
	}

	@Override
	public UserDto logIn(UserDto userDto) {
		User user = userRepository.findUserByEmail(userDto.getEmail());
		if(user!=null) {
			if(user.getPassword().equals(userDto.getPassword())) {
				UserDto authUserDto = new UserDto();
				BeanUtils.copyProperties(user, authUserDto);
				return authUserDto;
			}
		}
		return null;
	}

}
