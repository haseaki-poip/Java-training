package com.intoroduction.introduction.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.intoroduction.introduction.model.UserData;
import com.intoroduction.introduction.model.UserIdRequest;

@RestController
public class IntroductionApplicationController {
    @GetMapping("/") // ルートへこのメソッドをマップする
    public String getId(@RequestParam(value = "id", required = false) String id) {
        return "your id is " + (id != null ? id : "00000");
    }

    @PostMapping("/")
    public ResponseEntity<UserData> postUser(@RequestBody UserIdRequest request) {
        String id = request.getId();
        UserData resData = new UserData(id, "John Doe", 30);
        return ResponseEntity.ok(resData);
    }

}
