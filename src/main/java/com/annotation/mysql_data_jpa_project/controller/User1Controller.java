package com.annotation.mysql_data_jpa_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.annotation.mysql_data_jpa_project.exception.PhoneNumberException;
import com.annotation.mysql_data_jpa_project.exception.UserNotFoundException;
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
        return "Welcome " + firstName + " " + lastName + " to the Spring Boot application!";
    }

    @GetMapping("/greet/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String greet(@PathVariable("name") String name) {
        return "Hello, welcome to the Spring Boot application! " + name;
    }

    @GetMapping("/test-header")
    @ResponseStatus(HttpStatus.OK)
    public String testHeader(@RequestHeader("firstName") String firstName, @RequestHeader("lastName") String lastName) {

        return "Welcome " + firstName + " " + lastName + " to the Spring Boot application!";
    }

    @GetMapping("/getByEmail")
    @ResponseStatus(HttpStatus.OK) // 200 OK
    public User getUserGetByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email).get();
    }

    @PatchMapping("/updatePartial")
    @ResponseStatus(HttpStatus.OK)
    public User updateUserPartial(@RequestParam Integer id, @RequestBody User partialUser) {
        User existingUser = userRepository.findById(id).orElse(null); // name: ramesh,email:s@gmail.com,adrress:mmumbai,password:123456,phoneNumber:123456789
        if (existingUser == null) {
            return null; // Or throw an exception for not found
        }
        // Update only non-null fields from partialUser
        if (partialUser.getName() != null) {
            existingUser.setName(partialUser.getName());
        }
        if (partialUser.getEmail() != null) {
            existingUser.setEmail(partialUser.getEmail()); // email:r@gmail.com
        }
        if (partialUser.getPassword() != null) {
            existingUser.setPassword(partialUser.getPassword());
        }
        if (partialUser.getPhoneNumber() != null) {
            existingUser.setPhoneNumber(partialUser.getPhoneNumber());
        }
        if (partialUser.getAddress() != null) {
            existingUser.setAddress(partialUser.getAddress());
        }

        //name: ramesh,email:r@gmail.com,adrress:mmumbai,password:123456,phoneNumber:123456789
        return userRepository.saveAndFlush(existingUser);
    }

    @GetMapping("/email")
    @ResponseStatus(HttpStatus.OK) // 200 OK    
    public User getException(@RequestParam String email) throws UserNotFoundException {

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            throw new UserNotFoundException("User not found with email: " + email);
        }
        return user;
    }

    @GetMapping("/mobile")
    @ResponseStatus(HttpStatus.OK) // 200 OK    
    public String geMobileException(@RequestParam String mobile) throws PhoneNumberException {
        if (mobile == null || mobile.isEmpty()) {
            throw new IllegalArgumentException("Mobile number cannot be null or empty");
        }

        if (mobile.length() != 10) {
            throw new PhoneNumberException("Mobile number must be 10 digits long");
        }
        return "Your mobile number is: " + mobile;
    }
}
