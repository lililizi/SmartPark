package org.SmartPark.web;

import org.SmartPark.bean.Appoint;
import org.SmartPark.bean.ResponseInfo;
import org.SmartPark.service.AppointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by touch on 2017/5/21.
 */
@Controller
@RequestMapping("/appoint")
public class AppointController {
    @Autowired
    private AppointService appointService;
    @RequestMapping(value = "/list",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseInfo getParkList(Appoint appoint){
        ResponseInfo responseInfo=new ResponseInfo();
        responseInfo.setData(appoint);
        return appointService.getList(responseInfo);
    }


}
