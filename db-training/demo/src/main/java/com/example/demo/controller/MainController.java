package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.User;
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

    @GetMapping("/user/name/{name}") // ルートへこのメソッドをマップする
    public String getUsersByName(@PathVariable("name") String name) {
        List<User> userList = userService.searchByName(name);
        System.out.println(userList);
        return "search by name";
    }

    @GetMapping("/user/id/{id}") // ルートへこのメソッドをマップする
    public String getUsersById(@PathVariable("id") Long id) {
        User user = userService.searchById(id);
        System.out.println(user);
        return "search by id";
    }
}
