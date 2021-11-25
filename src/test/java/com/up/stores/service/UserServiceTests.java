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
            user.setUsername("test01");
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
        User user = iuserService.login("test01", "123456");
        System.out.println(user);
    }

    //测试改变密码
    @Test
    public void changePassword(){
        iuserService.changePassword(18,"管理员","123456","root");
    }

    //测试获取到用户名称
    @Test
    public void getByUid() {
        try {
            Integer uid = 18;
            User user = iuserService.getByUid(uid);
            System.out.println(user);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    //测试修改个人资料
    @Test
    public void changeInfo() {
        try {
            Integer uid = 18;
            String username = "数据管理员";
            User user = new User();
            user.setPhone("15512328888");
            user.setEmail("admin03@cy.cn");
            user.setGender(2);
            iuserService.changeInfo(uid, username, user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    //测试上传用户头像图片
    @Test
    public void changAvatar(){
        iuserService.changeAvatar(
                18,"小明","/upload/test.png"
        );
    }

}