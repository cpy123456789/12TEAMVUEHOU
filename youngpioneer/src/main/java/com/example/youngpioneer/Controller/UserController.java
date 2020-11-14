package com.example.youngpioneer.Controller;

import com.example.youngpioneer.Service.UserService;
import com.example.youngpioneer.Service.impl.UserServiceImpl;
import com.example.youngpioneer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService=null;

    @RequestMapping("/register")//注册,判断用户名是否重复;
    @CrossOrigin
    public int addUser(String username,String nickname,String phone,String pwd,String school,String parentname) {
        System.out.println(username);
        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        user.setPhone(phone);
        user.setPwd(pwd);
        user.setSchool(school);
        user.setParentname(parentname);//封装对象;
        List<String> list = userService.getAllPrimaryKey();
        System.out.println(list);
        if(list.contains(username)) {
            return 0;
        }//判断用户名是否已经存在;
        else {
            userService.addUser(user);
            return 1;
        }


}
    @RequestMapping("/login")//注册,判断用户名是否重复;
    @CrossOrigin
    public int Login(String username,String pwd) {
        int result = userService.checkLogin(username,pwd);
        System.out.println("登录验证结果"+result);
        return result;
    }


}
