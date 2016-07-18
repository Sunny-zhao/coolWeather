package com.example.sunny.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sunny on 16/7/18.
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {

    //Province 表Sql
    public  static final String CREATE_PROVINCE = "create table if not exists Province(id integer primary key autoincrement,province_name text,province_code text)";
    //city 表Sql
    public  static final String CREATE_City = "create table if not exists City(id integer primary key autoincrement,city_name text,city_code text,province_id integer)";
    // County 表Sql
    public  static final String CREATE_County = "create table if not exists County(id integer primary key autoincrement,county_name text,county_code text,city_id integer)";

    public CoolWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL(CREATE_PROVINCE);
        db.execSQL(CREATE_City);
        db.execSQL(CREATE_County);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db,int oldVersion, int mewVersion){

    }
}
