package com.annotation.mysql_data_jpa_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.annotation.mysql_data_jpa_project.model.User;
import com.annotation.mysql_data_jpa_project.repository.UserRepository;


@RestController // controller +response body
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value="/get",method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK) // 200 OK
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @RequestMapping(value="/save",method=RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

     @RequestMapping(value="/update",method=RequestMethod.PUT) // PUT->UPDATE
     @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody User user) {
        return userRepository.saveAndFlush(user);
    }

    @RequestMapping(value="/delete",method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 No Content        
    public void deleteUser(@RequestParam("id") Integer id) {
        userRepository.deleteById(id);
        
    }

    


}
