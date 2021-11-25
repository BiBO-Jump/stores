package com.up.stores.mapper;

import com.up.stores.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;


//用户模块持久层接口
@Mapper
public interface UserMapper{

    Integer insert(User user);

    User findByUsername(String username);

    Integer updatePasswordByUid(//根据uid修改用户密码，id，执行人，修改时间，返回行数
            @Param("uid") Integer uid,
            @Param("password") String password,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

    User findByUid(Integer uid);//根据id查询用户数据

    Integer updateInfoByUid(User user);//根据uid更新用户资料,user封装用户id和新个人资料，返回行数

    Integer updateAvatarByUid(
            @Param("uid") Integer uid,
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

}
