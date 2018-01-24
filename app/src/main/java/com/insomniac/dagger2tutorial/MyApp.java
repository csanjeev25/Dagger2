package com.insomniac.dagger2tutorial;

import android.app.Application;

/**
 * Created by Sanjeev on 1/23/2018.
 */

public class MyApp extends Application{
    private static MyApp sMyApp;
    private BasicComponent mBasicComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sMyApp = this;

        mBasicComponent = DaggerBasicComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();
    }

    public static MyApp getMyApp(){
        return sMyApp;
    }

    public BasicComponent getBasicComponent(){
        return mBasicComponent;
    }
}
