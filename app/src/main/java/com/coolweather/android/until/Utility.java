package com.coolweather.android.until;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/4/26.
 */
/*
解析处理返回的省的数据
 */
public class Utility {
    public static  boolean handleProvinceResponse(String response)
    {
            if(!TextUtils.isEmpty(response)) {
                try {
                    JSONArray allProvinces = new JSONArray(response);
                    for(int i= 0;i<allProvinces.length();i++) {
                        JSONObject provinceObject = allProvinces.getJSONObject(i);
                        Province province = new Province();
                        province.setProvinceName(provinceObject.getString("name"));
                        province.setProvinceCode(provinceObject.getInt("id"));
                        province.save();

                    }
                    return  true;
            }catch (JSONException e) {
                e.printStackTrace();
            }
            }
        return  false;
    }
    public static  boolean handleCityResponse(String response,int provinceId)
    {
        if(!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for(int i= 0;i<allCities.length();i++) {
                    JSONObject provinceObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(provinceObject.getString("name"));
                    city.setCityCode(provinceObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();

                }
                return  true;
            }catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
    public static boolean handleCouyntyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                    JSONArray allCounties = new JSONArray(response);
                for(int i = 0; i< allCounties.length();i++){
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatheerId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }


        }

        return  false;

    }
}
