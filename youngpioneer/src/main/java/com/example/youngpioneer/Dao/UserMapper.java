package com.example.youngpioneer.Dao;

import com.example.youngpioneer.pojo.Role;
import com.example.youngpioneer.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//表示了这是一个Mybatis的mapper类
@Repository
public interface UserMapper {
    //逆向工程生成
    int deleteByPrimaryKey(String username);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //手动添加
    List<String> selectAllusername();

    String selectPwdByusername(String username);
    //根据用户ID查询对应的角色
    List<Role> selectRoles(String id);

    String selectuidByusername(String username);

}
