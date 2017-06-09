package org.SmartPark.dao;

import org.SmartPark.bean.Appoint;

import java.util.List;

/**
 * Created by touch on 2017/5/21.
 */
public interface AppointDao {
    public int insertAppoint(Appoint appoint);
    public List<Appoint> getList(Appoint appoint);
    public int getNowAppoint(Appoint appoint);
    public int arrivelParkOrCancel(Appoint appoint);
}
