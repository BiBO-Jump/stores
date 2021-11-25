package com.up.stores.service;

import com.up.stores.entity.User;

//用户模块接口
public interface IUserService {
    //用户注册方法，传user用户数据对象
    void reg(User user);
    //传用户名和密码，返回用户名，若没有，返回null
    User login(String username,String password);
    //修改密码
    void changePassword(Integer uid, String username, String oldPassword, String newPassword);
}
