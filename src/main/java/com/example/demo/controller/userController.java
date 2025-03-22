package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UsersManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class userController {

    @Autowired
    UsersManager UM;

    @PostMapping("/signup")
    public String signup(@RequestBody User u) {
        return UM.addUser(u);
    }

    @PostMapping("/Login")
    public String login(@RequestBody User u) {
        return UM.validateCredentials(u.getEmail() , u.getPassword());

    }


    @GetMapping("/forgotpassword/{email}")
    public String forgotPassword(@PathVariable("email") String email) {
        return UM.recoverPassword(email);
    }


    @GetMapping("/all")
    public List<User> getAll() {
        return UM.getAllUsers();
    }

    @PostMapping("/getfullname")
    public String getFullname(@RequestBody Map<String, String> data)
    {
        return UM.getFullname(data.get("csrid"));
    }


}


