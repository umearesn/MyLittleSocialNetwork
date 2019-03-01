package com.network.akhme.myLittleSocialNetwork.di;

import android.app.Application;

public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .context(this)
                .build();
    }

}
