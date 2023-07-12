package com.lcwd.user.service.controllers;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //single user get
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) throws ResourceNotFoundException{
        User user = userService.getUser(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //all user get
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.getAllUser();
        if (!allUser.isEmpty()) {
            return ResponseEntity.ok(allUser);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // Update user by userId
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User updatedUserData) throws ResourceNotFoundException{
        User updatedUser = userService.updateUserById(userId, updatedUserData);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete user by userId
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) throws ResourceNotFoundException{
        userService.deleteUserById(userId);
        String message = "User with ID " + userId + " has been successfully deleted.";
        return ResponseEntity.ok(message);
    }

//    @DeleteMapping("/{userId}")
//    public ResponseEntity<String> deleteUser(@PathVariable String userId) throws ResourceNotFoundException {
//        userService.deleteUserById(userId);
//        String message = "User with ID " + userId + " has been successfully deleted.";
//        return ResponseEntity.ok(message);
//    }

}
