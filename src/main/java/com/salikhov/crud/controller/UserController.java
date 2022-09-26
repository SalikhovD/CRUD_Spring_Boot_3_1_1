package com.salikhov.crud.controller;


import com.salikhov.crud.entity.User;
import com.salikhov.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService service;

    @Autowired
    UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String showAllUsers(Model model) {
        List<User> userList = service.listUsers();
        model.addAttribute("userList", userList);
        return "all-users";
    }

    @PostMapping(value = "/delete-user")
    public String deleteUser(@RequestParam Long id) {
        service.deleteUser(id);
        return "redirect:/";
    }

    @PostMapping("/updateInfo")
    public String updateUser(@RequestParam Long id, Model model) {
        User user = service.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @GetMapping("/new-user")
    public String saveUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @PostMapping("/save-or-update-user")
    public String userInfo(@ModelAttribute("user") User user) {
        service.saveOrUpdate(user);
        return "redirect:/";
    }
}