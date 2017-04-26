package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/4/26.
 */

public class County extends DataSupport {
    private int id ;
    private  String countyName;
    private String WeatheerId;
    private  int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeatheerId() {
        return WeatheerId;
    }

    public void setWeatheerId(String weatheerId) {
        WeatheerId = weatheerId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
