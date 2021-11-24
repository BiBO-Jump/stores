package com.up.stores.service;

import com.up.stores.entity.User;
import com.up.stores.mapper.UserMapper;
import com.up.stores.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
    @Autowired
    private IUserService iuserService;

    //测试加密过的注册新用户，并获取到对应信息
    @Test
    public void reg(){
        try{
            User user = new User();
            user.setUsername("register1");
            user.setPassword("123456");
           iuserService.reg(user);
           System.out.println("OK");
        }catch (ServiceException e){
            //获取异常类名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常类信息
            System.out.println(e.getMessage());
        }
    }

    //登录用户验证测试
    @Test
    public void login() {
        User user = iuserService.login("register1", "123456");
        System.out.println(user);
    }
}