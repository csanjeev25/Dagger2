package com.insomniac.dagger2tutorial;

import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by Sanjeev on 1/23/2018.
 */

public class ObjectManager {
    private SharedPreferences mSharedPreferences;
    private Gson mGson;

    public ObjectManager(SharedPreferences sharedPreferences, Gson gson) {
        mSharedPreferences = sharedPreferences;
        mGson = gson;
    }

    public void save(Object o,String key){
        mSharedPreferences.edit()
                .putString(key,mGson.toJson(o))
                .apply();

    }

    public <T> T get(String key,Class<T> type){
        String json = mSharedPreferences.getString(key,null);
        if(json == null)
            return null;

        return mGson.fromJson(json,type);
    }
}
