package com.app.aparoksha.apro16;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Ratul on 29-Mar-16.
 */
public class parse_config extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this,"b6M7rAxtdYoUgGMgGkzmYmpDWiN2T6M8c2RTJ5Zg","Xsqyd44kUtgiOMMvwP8gyVjmdZLvXLxuynmGqqNX");
    }
}

