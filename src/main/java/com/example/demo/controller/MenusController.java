package com.example.demo.controller;


import com.example.demo.service.MenusManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/menus")
@CrossOrigin(origins = "*")
public class MenusController {

        @Autowired
        MenusManager M;

        @PostMapping("/getmenus")
        public String getMenus() {
            return M.getMenus();
        }

        @PostMapping("/getmenusbyrole")
        public String getMenusByRole(@RequestBody Map<String, String> data) {
                return M.getMenusByRole(data.get("csrid"));
        }


}
