package com.lcwd.user.service.services.impl;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        // Generates unique userId
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) throws ResourceNotFoundException {

        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found on server !! : "+userId));
    }

//    @Override
//    public User updateUser(User user) {
//        return null;
//    }

    @Override
    public User updateUserById(String userId, User updatedUser) throws ResourceNotFoundException{
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with ID " + userId + " not found"));

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setAbout(updatedUser.getAbout());

        return userRepository.save(existingUser);
    }

    @Override
public void deleteUserById(String userId) throws ResourceNotFoundException{
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with ID " + userId + " not found"));

        userRepository.delete(existingUser);
    }

}
