package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/user") // ルートへこのメソッドをマップする
    public String getAllUser() {
        List<User> userList = userService.searchAll();
        System.out.println(userList);
        return "get";
    }
}
