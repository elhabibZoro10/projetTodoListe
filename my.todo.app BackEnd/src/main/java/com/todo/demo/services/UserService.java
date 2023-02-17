package com.todo.demo.services;

import com.todo.demo.shared.dto.UserDto;

public interface UserService {
    UserDto signUp(UserDto userDto);
    UserDto logIn(UserDto userDto);
}
