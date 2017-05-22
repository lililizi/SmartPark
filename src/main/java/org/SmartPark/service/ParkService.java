package org.SmartPark.service;

import org.SmartPark.bean.ResponseInfo;

/**
 * Created by touch on 2017/5/21.
 */
public interface ParkService {
    public ResponseInfo getParkList(ResponseInfo responseInfo);
    public ResponseInfo appointPark(ResponseInfo responseInfo);
    public ResponseInfo arrivePark(ResponseInfo responseInfo);
}
