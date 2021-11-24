package com.up.stores.mapper;

import com.up.stores.entity.User;
import org.apache.ibatis.annotations.Mapper;


//用户模块持久层接口
@Mapper
public interface UserMapper{
    Integer insert(User user);

    User findByUsername(String username);
}
