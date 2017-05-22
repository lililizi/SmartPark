package org.SmartPark.dao;

import org.SmartPark.bean.Appoint;
import org.SmartPark.bean.User;

/**
 * Created by touch on 2017/5/20.
 */
public interface UserDao {
    /**
     * 获取用户接口，做用户校验用
     * @param user
     * @return
     */
    public User getUser(User user);

    /**
     * 注册用户接口 需要账户 真实姓名 密码
     * @param user
     * @return
     */
    public int registerUser(User user);

    /**
     * 取消预约接口
     * @param user
     * @return
     */
    public int cancleAppoint(User user);

    /**
     * 预约到达接口  分按时和迟到两周情况
     * @param appoint 需要将系统时间传入createTime 做校验用
     * @return
     */
    public int arriverl(Appoint appoint);
}
