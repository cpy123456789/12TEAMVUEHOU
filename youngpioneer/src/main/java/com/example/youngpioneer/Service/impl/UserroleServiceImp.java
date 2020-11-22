package com.example.youngpioneer.Service.impl;

import com.example.youngpioneer.Dao.RoleMapper;
import com.example.youngpioneer.Dao.UserroleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserroleServiceImp {
    @Autowired//这个注解必须得加，不然会发生空指针异常
    private UserroleMapper userroleMapper=null;
}
