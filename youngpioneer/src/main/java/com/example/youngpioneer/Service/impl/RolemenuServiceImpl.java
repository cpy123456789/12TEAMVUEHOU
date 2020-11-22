package com.example.youngpioneer.Service.impl;

import com.example.youngpioneer.Dao.RoleMapper;
import com.example.youngpioneer.Dao.RolemenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolemenuServiceImpl {
    @Autowired//这个注解必须得加，不然会发生空指针异常
    private RolemenuMapper rolemenuMapper=null;

}
