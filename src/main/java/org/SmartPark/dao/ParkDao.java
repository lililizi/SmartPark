package org.SmartPark.dao;

import org.SmartPark.bean.Appoint;
import org.SmartPark.bean.Park;
import org.SmartPark.bean.ResponseInfo;

import java.util.List;

/**
 * Created by touch on 2017/5/21.
 */
public interface ParkDao {
    /**
     * 获取停车场列表（含搜索）
     * @param responseInfo
     * @return
     */
    public List<Park> getParkList(ResponseInfo responseInfo);

    /**
     * 预约停车场
     * @param park
     * @return
     */
    public int appointPark(Park park);
    public int arrivePark(Park park);
    public Park getPark(Appoint appoint);
}
