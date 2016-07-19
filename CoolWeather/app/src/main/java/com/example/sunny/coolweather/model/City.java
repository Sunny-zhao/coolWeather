package com.example.sunny.coolweather.model;

/**
 * Created by Sunny on 16/7/18.
 */
public class City {

    private int id;
    private String cityName;
    private String cityCode;
    private int provinceId;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
