package com.example.youngpioneer.Controller;

import com.example.youngpioneer.Service.UserService;
import com.example.youngpioneer.Service.impl.UserServiceImpl;
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

@RestController
@RequestMapping("/api/user")
public class UserController {

    public static final String TOKEN = "token";
    @Autowired
    private UserService userService=null;

    @RequestMapping("/register")//注册,判断用户名是否重复;
    @CrossOrigin
    public int addUser(String username,String nickname,String phone,String pwd,String school,String parentname) {
        System.out.println(username);
        String usernameMD5 = MD5Tools.string2MD5(username);//用户名转换成MD5形式;
        String pwdMD5 = MD5Tools.string2MD5(pwd);//用户名转换成MD5形式;
        User user = new User();
        user.setUsername(usernameMD5);
        user.setNickname(nickname);
        user.setPhone(phone);
        user.setPwd(pwdMD5);
        user.setSchool(school);
        user.setParentname(parentname);//封装对象;
        List<String> list = userService.getAllPrimaryKey();//获取所有用户名
        System.out.println(list);
        if(list.contains(username)) {
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
//        if(username != null){
//            String jwt = JwtUtil.generateToken(username);
//            jwt = URLEncoder.encode(jwt);
//            Cookie cookie_token = new Cookie(TOKEN, jwt);
//            cookie_token.setMaxAge(60*60*60);
//            cookie_token.setPath("/");
//            response.addCookie(cookie_token);
//        }
        int result = userService.checkLogin(usernameMD5,pwdMD5);
        System.out.println("登录验证结果"+result);
        return result;

    }



}
