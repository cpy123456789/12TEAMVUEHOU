package com.example.youngpioneer.Service.impl;

import com.example.youngpioneer.Dao.UserMapper;
import com.example.youngpioneer.Dao.UserroleMapper;
import com.example.youngpioneer.Service.UserService;
import com.example.youngpioneer.pojo.Role;
import com.example.youngpioneer.pojo.User;
import com.example.youngpioneer.pojo.Userrole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired//这个注解必须得加，不然会发生空指针异常
    private UserMapper userMapper1=null;


    @Autowired
    private UserroleMapper userroleMapper;
    @Override
    //添加用户
    public int addUser(User record) {
        userMapper1.insert(record);
        return 1;
    }

    @Override
    //获取数据库所有用户名
    public List<String> getAllusername() {
        List<String> list = userMapper1.selectAllusername();
        return list;
    }




    @Override
    //用户登录验证
    public int checkLogin(String username, String pwd) {
        System.out.println(username);
        System.out.println(pwd);
        String pwd2 = userMapper1.selectPwdByusername(username);//根据用户名查询数据库中对应密码;
        if(pwd2!=null) {//避免空指针异常;
            if(pwd2.equals(pwd)) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            return 0;
        }


    }

    //
    @Override
    public List<Userrole> selectRoles(String username) {

        String id = userMapper1.selectuidByusername(username);
        //List<Role> roleList = userMapper1.selectRoles(id);

        List<Userrole> list = userroleMapper.selectByUid(id);

        
        return list;


    }

}
