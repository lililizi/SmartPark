package org.SmartPark.web;

import org.SmartPark.bean.ResponseInfo;
import org.SmartPark.bean.User;
import org.SmartPark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by touch on 2017/5/21.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseInfo userLogin(User user){
        if (user==null)
            return new ResponseInfo(false,"数据为空");
        ResponseInfo responseInfo=new ResponseInfo();
        responseInfo.setData(user);
        responseInfo=userService.UserLogin(responseInfo);
        return responseInfo;
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseInfo userRegister(User user){
        if (user==null)
            return new ResponseInfo(false,"数据为空");
        ResponseInfo responseInfo=new ResponseInfo();
        responseInfo.setData(user);
        responseInfo=userService.UserRegister(responseInfo);
        return responseInfo;
    }

}
