package com.annotation.mysql_data_jpa_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.annotation.mysql_data_jpa_project.model.User;
import com.annotation.mysql_data_jpa_project.repository.UserRepository;

@RestController
@RequestMapping("/user") // Base URL for this controller
public class User1Controller {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK) // 200 OK
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @PostMapping("/save")
     @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

     @PutMapping("/update") // PUT->UPDATE
     @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody User user) {
        return userRepository.saveAndFlush(user);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 No Content        
    public void deleteUser(@RequestParam("id") Integer id) {
        userRepository.deleteById(id);
        
    }


    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)  
    public String test(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return "Welcome "+ firstName + " " + lastName + " to the Spring Boot application!";
    }

    @GetMapping("/greet/{name}")
    @ResponseStatus(HttpStatus.OK)  
    public String greet(@PathVariable("name") String name) {
        return "Hello, welcome to the Spring Boot application! "+name;
    }

    @GetMapping("/test-header")
    @ResponseStatus(HttpStatus.OK)  
    public String testHeader(@RequestHeader("firstName") String firstName, @RequestHeader("lastName") String lastName) {
        
      
        return "Welcome "+ firstName + " " + lastName + " to the Spring Boot application!";
    }


     @GetMapping("/getByEmail")
    @ResponseStatus(HttpStatus.OK) // 200 OK
    public User getUserGetByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email);
    }
}
