package com.example.youngpioneer.Service;

import com.example.youngpioneer.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {

    public int addUser(User user);
    public List<String> getAllPrimaryKey();

    //用户登录验证
    public int checkLogin(String username,String pwd);
}
