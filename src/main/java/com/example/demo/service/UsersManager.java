package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;
import com.example.demo.repo.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UsersManager {

    @Autowired
    userRepository UR;

    @Autowired
    EmailManager EM;

    @Autowired
    JwtManager JM;

    public String addUser(User U) {
        if(UR.validateEmail(U.getEmail()) > 0)
            return "401::Email already exist";
        UR.save(U);
        return "200::User Registered Successfully";

    }


    public List<User> getAllUsers()
    {
        return UR.findAll();
    }


    public String recoverPassword(String email)
    {
        User U = UR.findById(email).get();
        String message = String.format("Dear %s, \n \n Your Password is : %s",U.getFullname(),U.getPassword());
        return EM.sendEmail(U.getEmail(), "JobPortal : Password Recovery", message);
    }

    public String validateCredentials(String email , String password)
    {
        if(UR.validateCredentials(email, password) > 0)
        {
            String token = JM.generateToken(email);
            return "200::"+token;
        }
        return "401:invalid data";
    }

    public String getFullname(String token)
    {
        String email = JM.validateToken(token);
        if(email.compareTo("401") == 0)
            return "401::Token Expired!";
        User U = UR.findById(email).get();
        return U.getFullname();
    }
}