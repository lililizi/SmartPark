package org.SmartPark.service.Impl;

import org.SmartPark.bean.Appoint;
import org.SmartPark.bean.ResponseInfo;
import org.SmartPark.dao.AppointDao;
import org.SmartPark.service.AppointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by touch on 2017/5/22.
 */
@Service
public class AppointServiceImpl implements AppointService {
    @Autowired
    private AppointDao appointDao;
    public ResponseInfo getList(ResponseInfo responseInfo) {
        Appoint appoint=(Appoint)responseInfo.getData();
        List<Appoint> list=appointDao.getList(appoint);
        if (list.size()!=0)
            return new ResponseInfo(true,list);
        return new ResponseInfo(false,"没有预约信息");
    }
}
