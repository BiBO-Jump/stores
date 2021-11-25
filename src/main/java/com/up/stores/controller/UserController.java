package com.up.stores.controller;

import com.up.stores.entity.User;
import com.up.stores.service.IUserService;
import com.up.stores.service.ex.InsertException;
import com.up.stores.service.ex.UsernameDuplicateException;
import com.up.stores.until.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/** 处理用户相关请求的控制器类 */

@RestController
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;
    //约定大于配置的开发思想，省略大量的配置甚至注解的编号
    //1.接受数据方式:请求处理方法的参数列表设置为pojo类型来接受前端数据
    //Springboot将前端的url地址中的参数名和pojo类属性名比较，如果两个
    // 名称相同，则将注入到到pojo类中对应的属性上
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        // 调用业务对象执行注册
        userService.reg(user);
        // 返回
        return new JsonResult<Void>(OK);
    }
    //2.接受数据方式:请求处理方法的参数列表设置为非pojo类型
    //Springboot将请求的参数名和方法的参数名直接进行比较
    // 如果名称相同，则将自动完成值依赖注入
    @RequestMapping("login")
    public JsonResult<User> login(String username,
                                  String password,
                                  HttpSession session){
        User data = userService.login(username,password);
        //想session对象中完成数据的绑定(session全局的)
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());
        //获取session中绑定的数据
        System.out.println("数据库行数:"+getuidFromSession(session));
        System.out.println("用户"+getUsernameFromSession(session)+"登录成功！");
        return new JsonResult<User>(OK,data);
    }
    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword,
                                           String newPassword,
                                           HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid,username,oldPassword,newPassword);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        // 从HttpSession对象中获取uid
        Integer uid = getuidFromSession(session);
        // 调用业务对象执行获取数据
        User data = userService.getByUid(uid);
        // 响应成功和数据
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user,HttpSession session){
        // 从HttpSession对象中获取uid和username
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行修改用户资料
        userService.changeInfo(uid, username, user);
        // 响应成功
        return new JsonResult<Void>(OK);
    }
}
//    @RequestMapping("reg")
//    public JsonResult<Void> reg(User user){
//        //创建响应结果对象
//        JsonResult<Void> result = new JsonResult<Void>();
//            try{
//                userService.reg(user);
//                result.setState(200);
//                result.setMessage("用户注册成功");
//            }catch (UsernameDuplicateException e){
//                result.setState(4000);
//                result.setMessage("用户名被占用");
//            }catch (InsertException e){
//                result.setState(5000);
//                result.setMessage("注册时产生未知数据,请联系管理员");
//            }
//            return result;
//
//    }

