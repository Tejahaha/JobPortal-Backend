package com.example.demo.service;

import com.example.demo.model.Menus;
import com.example.demo.model.User;
import com.example.demo.repo.MenusRepository;
import com.example.demo.repo.userRepository;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenusManager {

    @Autowired
    private MenusRepository MR;

    @Autowired
    JwtManager JWT;

    @Autowired
    userRepository UR;

    public String getMenus() {
        List<String> menulist = new ArrayList<String>();
        for(Menus M : MR.findAll())
            menulist.add(new GsonBuilder().create().toJson(M));
        return menulist.toString();
    }

    public String getMenusByRole(String token) {
        String email = JWT.validateToken(token);
        if(email.equals("401"))
            return "401::Invalid Token";
        User U = UR.findById(email).get();
        List<Menus> menuList = MR.findByRole(U.getRole());

        return new GsonBuilder().create().toJson(menuList).toString();
    }

}
