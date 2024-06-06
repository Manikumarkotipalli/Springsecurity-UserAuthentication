package com.Authentication.UserAuthentication.Controller;

import com.Authentication.UserAuthentication.Model.Myuser;

import com.Authentication.UserAuthentication.Repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController

public class AuthControlller {


    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register/user")
    public String registerUser(@RequestBody Myuser user) {
     user.setPassword(passwordEncoder.encode(user.getPassword()));

             userRepo.save(user);
             return "userhome";
    }



}
