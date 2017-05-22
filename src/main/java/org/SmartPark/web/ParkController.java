package org.SmartPark.web;

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
        System.out.println(responseInfo.getSearch());
        return parkService.getParkList(responseInfo);
    }

}
