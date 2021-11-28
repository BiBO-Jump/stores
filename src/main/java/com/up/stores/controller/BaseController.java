package com.up.stores.controller;

import com.up.stores.controller.ex.*;
import com.up.stores.service.ex.*;
import com.up.stores.until.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/** 控制器类的基类 */
@Controller
@ResponseBody
public class BaseController {
    /** 操作成功的状态码 */
    public static final int OK = 200;

    /** @ExceptionHandler用于统一处理方法抛出的异常 */
    @ExceptionHandler({ServiceException.class,FileUploadIOException.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<Void>(e);
        if (e instanceof UsernameDuplicateException) {
            result.setState(4000);
            result.setMessage("用户名已被占用");
        } else if (e instanceof UserNotFoundException) {
            result.setState(4001);
            result.setMessage("插入数据不存在");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("插入数据产生未知异常");
        } else if (e instanceof AddressCountLimitException) {
            result.setState(4003);
            result.setMessage("用户的收货地址超出上限异常");
        } else if (e instanceof AddressNotFoundException) {
            result.setState(4004);
            result.setMessage("用户收获地址数据不存在");
        } else if (e instanceof AccessDeniedException) {
            result.setState(4005);
            result.setMessage("用户收获地址数据非法访问的异常");
        } else if (e instanceof ProductNotFoundException) {
            result.setState(4006);
            result.setMessage("商品数据不存在的异常");
        } else if (e instanceof CartNotFoundException) {
            result.setState(4007);
            result.setMessage("购物车数据不存在的异常");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("用户名或密码错误的异常");
        } else if (e instanceof UpdateException) {
            result.setState(5001);
            result.setMessage("更新数据时产生未知的异常");
        } else if (e instanceof DeleteException) {
            result.setState(5002);
            result.setMessage("删除地址数据时产生未知的异常");
        } else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }
        return result;
    }

    //获取当前登录uid，参数session对象，返回uid
    protected final Integer getuidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }
    //获取当前登录用户的username，参数session，返回用户名
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}