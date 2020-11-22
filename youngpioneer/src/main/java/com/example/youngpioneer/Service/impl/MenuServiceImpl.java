package com.example.youngpioneer.Service.impl;

import com.example.youngpioneer.Dao.MenuMapper;
import com.example.youngpioneer.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl {
    @Autowired
    private MenuMapper menuMapper = null;
}
