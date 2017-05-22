package org.SmartPark.service.Impl;

import org.SmartPark.bean.Appoint;
import org.SmartPark.bean.Park;
import org.SmartPark.bean.ResponseInfo;
import org.SmartPark.dao.AppointDao;
import org.SmartPark.dao.ParkDao;
import org.SmartPark.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Created by touch on 2017/5/21.
 */
@Service
public class ParkServiceImpl implements ParkService {
    @Autowired
    private ParkDao parkDao;
    @Autowired
    private AppointDao appointDao;
    public ResponseInfo getParkList(ResponseInfo responseInfo) {
        responseInfo.setNowTime(new Time(new Date().getTime()));
        System.out.println(responseInfo.getNowTime());
        List<Park> parkList=parkDao.getParkList(responseInfo);
        if (parkList.size()!=0){
            return new ResponseInfo(true,parkList);
        }else{
            return new ResponseInfo(false,"无停车场");
        }
    }

    /**
     * 确定停车位情况，操作停车场数据，加预约
     * @param responseInfo
     * @return
     */
    public ResponseInfo appointPark(ResponseInfo responseInfo) {
        Appoint appoint=(Appoint) responseInfo.getData();
        Park park=parkDao.getPark(appoint);
        if (park.getParkNum()==0){
            return new ResponseInfo(false,"车位已全部占用");
        }
        int count=parkDao.appointPark(park);
        if (count!=1)
            return new ResponseInfo(false,"系统错误");
        appoint.setAppointTime(new Date());
        count=appointDao.insertAppoint(appoint);
        if (count==1)
            return new ResponseInfo(true);
        return new ResponseInfo(false,"系统异常");
    }

    public ResponseInfo arrivePark(ResponseInfo responseInfo) {
        return null;
    }
}
