package com.example.sunny.coolweather.util;

/**
 * Created by Sunny on 16/7/18.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);

}
