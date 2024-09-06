package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.model.User;
import com.crm.repository.UserRepository;
import com.crm.service.CurrentLoggedInUserService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CurrentLoggedInUserService currentLoggedInUserService;

    @GetMapping
    public User getProfile() {
        return userRepository.findByEmail(currentLoggedInUserService.getCurrentUserName()).get();
    }

    @PutMapping
    public User updateProfile(@RequestBody User user) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User existingUser = userRepository.findByEmail(userDetails.getUsername()).get();
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }
}
