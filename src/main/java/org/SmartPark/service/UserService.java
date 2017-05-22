package org.SmartPark.service;

import org.SmartPark.bean.ResponseInfo;

/**
 * Created by touch on 2017/5/21.
 */
public interface UserService {
    public ResponseInfo UserRegister(ResponseInfo responseInfo);
    public ResponseInfo UserLogin(ResponseInfo responseInfo);
}
