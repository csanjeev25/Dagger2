package com.insomniac.dagger2tutorial;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Sanjeev on 1/23/2018.
 */

@Component(modules = AppModule.class)
@Singleton
public interface BasicComponent{

    void inject(MainActivity mainActivity);

}
