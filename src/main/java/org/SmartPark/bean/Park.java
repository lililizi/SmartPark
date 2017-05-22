package org.SmartPark.bean;

import java.util.Date;

/**
 * Created by touch on 2017/5/20.
 */
public class Park {
    private long id;
    private String name;
    private String longtitude;
    private String latitude;
    private String address;
    private int parkNum;
    private int nowParks;
    private int futureParks;
    private Date startTime;
    private Date endTime;
    private byte priceType;
    private double price;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getParkNum() {
        return parkNum;
    }

    public void setParkNum(int parkNum) {
        this.parkNum = parkNum;
    }

    public int getNowParks() {
        return nowParks;
    }

    public void setNowParks(int nowParks) {
        this.nowParks = nowParks;
    }

    public int getFutureParks() {
        return futureParks;
    }

    public void setFutureParks(int futureParks) {
        this.futureParks = futureParks;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public byte getPriceType() {
        return priceType;
    }

    public void setPriceType(byte priceType) {
        this.priceType = priceType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
