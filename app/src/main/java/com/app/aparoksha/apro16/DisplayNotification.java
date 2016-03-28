package com.app.aparoksha.apro16;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.MenuItem;

/**
 * Created by Satyam Poddar on 07-Mar-16.
 */
public class DisplayNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_notification);

        //---get the notification ID for the notification;
        // passed in by the MainActivity---
        int notifID = getIntent().getExtras().getInt("NotifID");
        String event = getIntent().getExtras().getString("event");
        String address = getIntent().getExtras().getString("address");
        //---PendingIntent to launch activity if the user selects
        // the notification---
        //Intent i = new Intent("net.learn2develop.AlarmDetails");
        //i.putExtra("NotifID", notifID);

        //PendingIntent detailsIntent =
        //  PendingIntent.getActivity(this, 0, i, 0);



        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("Reminder");
        mBuilder.setContentText("Hi, " + event + " is about to start!");
        mBuilder.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
        mBuilder.setAutoCancel(true);
        mBuilder.setLights(Color.YELLOW, 3000, 3000);

        Intent resultIntent = new Intent(address);
        resultIntent.putExtra("NotifID", notifID);
        //resultIntent.putExtra("event", event);
        resultIntent.putExtra("address", address);
        PendingIntent pi = PendingIntent.getActivity(this,0,resultIntent,0);
        mBuilder.setContentIntent(pi);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());
        //LED




        //mNotificationManager.cancel(notifID);
        /*NotificationManager nm = (NotificationManager)
            getSystemService(NOTIFICATION_SERVICE);
        Notification notif = new Notification(
            R.drawable.images,
            "Time's up!",
            System.currentTimeMillis());

        CharSequence from = "AlarmManager - Time's up!";
        CharSequence message = "This is your alert, courtesy of the AlarmManager";
        notif.setLatestEventInfo(this, from, message, detailsIntent);

        //---100ms delay, vibrate for 250ms, pause for 100 ms and
        // then vibrate for 500ms---
        notif.vibrate = new long[] { 100, 250, 100, 500};
        nm.notify(notifID, notif);*/
        //---destroy the activity---
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
