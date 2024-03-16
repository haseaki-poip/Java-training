package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
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

    // コントローラごとにエラーハンドリングを設定する時
    // @ExceptionHandler(NotFoundException.class)
    // public ResponseEntity<?> handleNotFoundException(NotFoundException ex) {
    // // エラーメッセージと共に404ステータスを返す
    // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    // }
}
