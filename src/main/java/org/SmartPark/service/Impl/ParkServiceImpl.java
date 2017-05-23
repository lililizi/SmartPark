package org.SmartPark.service.Impl;

import org.SmartPark.bean.Appoint;
import org.SmartPark.bean.Park;
import org.SmartPark.bean.ResponseInfo;
import org.SmartPark.dao.AppointDao;
import org.SmartPark.dao.OrderDao;
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
    @Autowired
    private OrderDao orderDao;

    public ResponseInfo getParkList(ResponseInfo responseInfo) {
        responseInfo.setNowTime(new Time(new Date().getTime()).toString());
        List<Park> parkList=parkDao.getParkList(responseInfo);
        System.out.println(parkList.toString());
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
        //确认是否已有预约
        Appoint appoint1=appointDao.getNowAppoint(appoint);
        if (appoint1==null)
            return new ResponseInfo(false,"已有预约未完成");
        int count=parkDao.appointPark(park);
        if (count!=1)
            return new ResponseInfo(false,"系统错误");
        appoint.setAppointTime(new Date());
        count=appointDao.insertAppoint(appoint);
        if (count==1)
            return new ResponseInfo(true);
        return new ResponseInfo(false,"系统异常");
    }

    /**
     * 到达停车场 取消预约
     * @param responseInfo
     * @return
     */
    public ResponseInfo arrivelParkOrCancel(ResponseInfo responseInfo) {
        Appoint appoint=(Appoint) responseInfo.getData();
        if (appointDao.arrivelParkOrCancel(appoint)==1?true:false){
            if (appoint.getState()==2){
                return new ResponseInfo(true);
            }else{
                if (orderDao.insertOrder(appoint)==1?true:false)
                    return new ResponseInfo(true);
            }
        }
        return new ResponseInfo(false,"系统异常");
    }

    public ResponseInfo getParkInfo(ResponseInfo responseInfo) {
        Park park=(Park)responseInfo.getData();
        Appoint appoint=new Appoint();
        appoint.setpId(park.getId());
        park=parkDao.getPark(appoint);
        return new ResponseInfo(true,park);
    }
}
