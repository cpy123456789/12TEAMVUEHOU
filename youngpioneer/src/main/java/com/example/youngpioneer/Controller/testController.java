package com.example.youngpioneer.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class testController {
    @RequestMapping("/indextest")//注册,判断用户名是否重复;
    @CrossOrigin
    public String test(String s) {
        System.out.println(s);
        return s;
    }


}
