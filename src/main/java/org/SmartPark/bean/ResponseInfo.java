package org.SmartPark.bean;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gaoli on 2017/4/5.
 */
public class ResponseInfo<T>{
    private boolean success;
    private T data;
    private String error;
    private String search;
    private String nowTime;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getNowTime() {
        return nowTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    public ResponseInfo() {
    }

    public ResponseInfo(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public ResponseInfo(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public ResponseInfo(boolean success) {
        this.success = success;
    }
}
