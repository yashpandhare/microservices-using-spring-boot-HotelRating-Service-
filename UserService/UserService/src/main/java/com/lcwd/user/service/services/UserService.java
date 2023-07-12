package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;

import java.lang.module.ResolutionException;
import java.util.List;

public interface UserService {
    // User operations

    //create
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user of given userId
    User getUser(String userId) throws ResourceNotFoundException;


    //TODO: delete
    //TODO: update

    // Update a user by userId
    User updateUserById(String userId, User updatedUser) throws ResourceNotFoundException;

    // Delete a user by userId
    void deleteUserById(String userId) throws ResourceNotFoundException;

}
