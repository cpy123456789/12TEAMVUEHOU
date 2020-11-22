package com.example.youngpioneer.Service.impl;

import com.example.youngpioneer.Dao.RoleMapper;
import com.example.youngpioneer.Dao.UserMapper;
import com.example.youngpioneer.Service.RoleService;
import com.example.youngpioneer.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired//这个注解必须得加，不然会发生空指针异常
    private RoleMapper roleMapper1=null;


}
