package com.todo.demo.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.todo.demo.entities.User;
import com.todo.demo.services.UserService;
import com.todo.demo.shared.dto.UserDto;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
    @PostMapping(path="/signUp",consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> signUp(@RequestBody UserDto userDto) throws Exception{
        if(userDto.getName().isEmpty() || userDto.getEmail().isEmpty() || userDto.getPassword().isEmpty())
            throw new RuntimeException("vous oublier des champs obligatoire");
        UserDto savedUserDto =  userService.signUp(userDto);
        User savedUser = new User();
        BeanUtils.copyProperties(savedUserDto, savedUser);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }
    
    @PostMapping(path="/login", consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> logIn(@RequestBody UserDto userDto){
        UserDto authUser = userService.logIn(userDto);
        User user = new User();
        BeanUtils.copyProperties(authUser, user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

}
