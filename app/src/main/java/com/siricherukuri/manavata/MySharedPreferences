package com.siricherukuri.manavata;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MySharedPreferences {
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String USER_DISPLAY_NAME = "USER_DISPLAY_NAME";
    public static final String AUTH_TYPE = "AUTH_TYPE";
    public static final String GOOGLE = "GOOGLE";
    public static final String FACEBOOK = "FACEBOOK";
    public static final String USER_DAILY_SCHEDULE = "USER_DAILY_SCHEDULE";
    public static final String FIRST_TIME = "FIRST_TIME";
    private Context context;
    SharedPreferences preferences;

    public MySharedPreferences(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }



    public void saveCurrentUser(String displayName, String type){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER_DISPLAY_NAME, displayName);
        editor.putString(AUTH_TYPE, type);
        editor.apply();
    }

    public void saveDailySchedule (List<String> scheduleList){
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(scheduleList);
        editor.putString(USER_DAILY_SCHEDULE, json);
        editor.apply();
    }

    public ArrayList<String> getDailySchedule(){
        Gson gson = new Gson();
        String json = preferences.getString(USER_DAILY_SCHEDULE, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }

    public void removeCurrentUser(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(USER_DISPLAY_NAME);
        editor.remove(AUTH_TYPE);
        editor.apply();
    }

    public String getUserDisplayName(){
        return preferences.getString(USER_DISPLAY_NAME, "");
    }

    public Boolean isFirstTimeUser(){
        return preferences.getBoolean(FIRST_TIME, true);
    }

    public void setFirstTimeUser(Boolean isFirst){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(FIRST_TIME, isFirst);
        editor.apply();
    }

    public String getAuthType(){
        return preferences.getString(AUTH_TYPE, "");
    }
}
