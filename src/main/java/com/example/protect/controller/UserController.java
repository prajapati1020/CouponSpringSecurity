package com.example.protect.controller;

import com.example.protect.model.User;
import com.example.protect.repos.UserRepo;
import com.example.protect.security.SecurityService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    SecurityService securityService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/showReg")
    public String showRegistration(){
        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
     return "login";
    }


    @GetMapping("/")
    public String showLoginPage(){
        return "login";
    }


    public String login(String email , String password, HttpServletRequest request, HttpServletResponse response){
        boolean loginResponse = securityService.login(email,password,request,response);
        if(loginResponse){
            return "index";
        }
        return "login";

    }


}
