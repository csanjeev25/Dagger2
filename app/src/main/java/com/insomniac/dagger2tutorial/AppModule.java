package com.insomniac.dagger2tutorial;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Sanjeev on 1/23/2018.
 */

@Module
public class AppModule {
    private Context mContext;

    public AppModule(Context context){
        mContext = context;
    }

    @Singleton
    @Provides
    public Context getContext(){
        return mContext;
    }

    @Singleton
    @Provides
    public SharedPreferences getSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Singleton
    @Provides
    public Gson getGson(){
        return new Gson();
    }

    @Singleton
    @Provides
    public ObjectManager getObjectManager(SharedPreferences sharedPreferences,Gson gson){
        return new ObjectManager(sharedPreferences,gson);
    }

}
