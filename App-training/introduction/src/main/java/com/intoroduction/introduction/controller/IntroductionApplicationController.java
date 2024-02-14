package com.intoroduction.introduction.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntroductionApplicationController {
    @RequestMapping("/") // ルートへこのメソッドをマップする
    public String getId(@RequestParam(value = "id", required = false) String id) {
        return "your id is " + (id != null ? id : "00000");
    }
}
