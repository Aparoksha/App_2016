package com.app.aparoksha.apro16;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParsePush;
import com.parse.SaveCallback;

/**
 * Created by user on 3/29/2016.
 */
public class parse_config extends Application {

    private static String TAG = parse_config.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "b6M7rAxtdYoUgGMgGkzmYmpDWiN2T6M8c2RTJ5Zg", "Xsqyd44kUtgiOMMvwP8gyVjmdZLvXLxuynmGqqNX");
        ParsePush.subscribeInBackground("Apro_2016", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                Log.e(TAG, "Successfully subscribed to Parse!");
            }


        });
        Log.d(TAG, "not rgtd.");
    }
}
