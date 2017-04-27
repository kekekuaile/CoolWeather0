package com.coolweather.android.until;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/4/26.
 */

public class HttpUntil {
    public static     String Url = "http://guolin.tech/api/china/";
    public static void  sendOkHttpRequeset(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
