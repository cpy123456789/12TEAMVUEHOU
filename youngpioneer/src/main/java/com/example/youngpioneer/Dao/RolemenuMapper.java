package com.example.youngpioneer.Dao;

import com.example.youngpioneer.pojo.Menu;
import com.example.youngpioneer.pojo.Rolemenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//表示了这是一个Mybatis的mapper类
@Repository
public interface RolemenuMapper {
    int insert(Rolemenu record);

    int insertSelective(Rolemenu record);

    //根据角色id查询功能菜单

    List<Menu> selectByRid(Integer rid);
}
