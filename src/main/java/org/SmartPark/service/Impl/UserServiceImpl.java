package org.SmartPark.service.Impl;

import org.SmartPark.bean.ResponseInfo;
import org.SmartPark.bean.User;
import org.SmartPark.dao.UserDao;
import org.SmartPark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by touch on 2017/5/21.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    public ResponseInfo UserRegister(ResponseInfo responseInfo) {
        User user =(User) responseInfo.getData();
        User user1=userDao.getUser(user);
        if (user1!=null)
            return new ResponseInfo(false,"账号已存在");
        if (userDao.registerUser(user)==1?true:false){
            return new ResponseInfo(true);
        }
        return new ResponseInfo(false,"系统错误");
    }

    public ResponseInfo UserLogin(ResponseInfo responseInfo) {
        User user =(User) responseInfo.getData();
        User user1=userDao.getUser(user);
        if(user1!=null&&user.getPsw().toString().equals(user1.getPsw().toString())){
            return new ResponseInfo(true,user1);
        }
        return new ResponseInfo(false,"请检查用户名和密码");
    }
}
