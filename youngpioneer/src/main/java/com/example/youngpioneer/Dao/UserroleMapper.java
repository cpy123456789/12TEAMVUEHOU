package com.example.youngpioneer.Dao;

import com.example.youngpioneer.pojo.Userrole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//表示了这是一个Mybatis的mapper类
@Repository
public interface UserroleMapper {
    int insert(Userrole record);

    int insertSelective(Userrole record);

    //根据用户id查询角色
    List<Userrole> selectByUid(String uId);
}
