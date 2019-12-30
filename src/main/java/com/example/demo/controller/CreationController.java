package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/create")
public class CreationController {
    @Autowired
    UserService userService;

    @GetMapping(value = {"/user"})
    @ResponseBody
    public String getCreateUser(Model model, @RequestParam("username") String username,
                                @RequestParam("email") String email,
                                @RequestParam("password") String password){
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userService.save(user);
        return user.toString() + " is successfully finished";
    }

}
