package org.SmartPark.web;

import org.SmartPark.bean.Appoint;
import org.SmartPark.bean.Park;
import org.SmartPark.bean.ResponseInfo;
import org.SmartPark.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by touch on 2017/5/21.
 */
@Controller
@RequestMapping("/park")
public class ParkController {
    @Autowired
    private ParkService parkService;
    @RequestMapping(value = "/list",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseInfo getParkList(ResponseInfo responseInfo){
        return parkService.getParkList(responseInfo);
    }

    @RequestMapping(value = "/get",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseInfo getPark(Park park){
        ResponseInfo responseInfo=new ResponseInfo();
        responseInfo.setData(park);
        return parkService.getParkInfo(responseInfo);
    }

    @RequestMapping(value = "/appoint",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseInfo appointPark(Appoint appoint){
        ResponseInfo responseInfo=new ResponseInfo();
        responseInfo.setData(appoint);
        return parkService.appointPark(responseInfo);
    }

    @RequestMapping(value = "/ArrivelOrCancle",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseInfo ArrivelCancle(Appoint appoint){
        ResponseInfo responseInfo=new ResponseInfo();
        responseInfo.setData(appoint);
        return parkService.arrivelParkOrCancel(responseInfo);
    }
}
