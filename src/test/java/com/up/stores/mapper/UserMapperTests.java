package com.up.stores.mapper;

import com.up.stores.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    //测试插入一个新用户
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tim4");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }
    //测试匹配到刚注册的新用户
    @Test
    public void findByUsername() {
        String username = "tim4";
        User result = userMapper.findByUsername(username);
        System.out.println(result);
    }
}