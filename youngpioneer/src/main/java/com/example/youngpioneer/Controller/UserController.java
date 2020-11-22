package com.example.youngpioneer.Controller;

import com.example.youngpioneer.Service.UserService;
import com.example.youngpioneer.Service.impl.UserServiceImpl;
import com.example.youngpioneer.pojo.Role;
import com.example.youngpioneer.pojo.User;
import com.example.youngpioneer.utils.JwtUtil;
import com.example.youngpioneer.utils.MD5Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {

    public static final String TOKEN = "token";
    @Autowired
    private UserService userService=null;

    @RequestMapping("/register")//注册,判断用户名是否重复;
    @CrossOrigin
    public int addUser(User user) {
        System.out.println(user);
        String usernameMD5 = MD5Tools.string2MD5(user.getUsername());//用户名转换成MD5形式;
        String pwdMD5 = MD5Tools.string2MD5(user.getPwd());//用户名转换成MD5形式;
        //User user = new User();
        UUID id = UUID.randomUUID();
        System.out.println(id);
        String id2 = id.toString().replace("-","");
        user.setId(id2);
//        user.setUsername(usernameMD5);
//        user.setNickname(nickname);
//        user.setPhone(phone);
//        user.setPwd(pwdMD5);
//        user.setSchool(school);
//        user.setParentname(parentname);//封装对象;
        List<String> list = userService.getAllusername();//获取所有用户名
        System.out.println(list);
        if(list.contains(user.getUsername())) {
            return 0;
        }//判断用户名是否已经存在;
        else {
            userService.addUser(user);
            return 1;
        }


}
    @RequestMapping("/login")//判断用户名是否重复;
    @CrossOrigin
    public int Login(String username, String pwd) {
        String usernameMD5 = MD5Tools.string2MD5(username);//用户名转换成MD5形式;
        String pwdMD5 = MD5Tools.string2MD5(pwd);//用户名转换成MD5形式;

        int result = userService.checkLogin(usernameMD5,pwdMD5);
        //返回该用户的状态码
        if (result>0){
            //

        }
        System.out.println("登录验证结果"+result);
        return result;

    }



}
