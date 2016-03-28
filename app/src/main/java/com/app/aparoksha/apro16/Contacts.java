package com.app.aparoksha.apro16;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Satyam Poddar on 30-Jan-16.
 */
public class Contacts extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
