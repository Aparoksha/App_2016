package com.app.aparoksha.apro16;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;
import java.util.HashMap;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by rudraksha on 13-Mar-16.
 */
public class Contacts extends AppCompatActivity{
    private Toolbar toolbar;
    private SwipeMenuListView mList;
    String[] events_1;
    int[] images;
    String[] timing;
    String[] intents;
    TextView eventName,act_name;
    String[] numbers  = {"7752965396","8870666551","8172888611","9807732664","9559386146","9794326484","7275610131","7704914402",
            "8953346034","8953322927","9621467533","9999999999"

    } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("hello","maa chuda android studio");
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/JosefinSans-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
        setContentView(R.layout.eventsnow);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        act_name = (TextView)findViewById(R.id.activity_name);
        Typeface tf1 = Typeface.createFromAsset(getAssets(),
                "JosefinSans-Regular.ttf");

        act_name.setTypeface(tf1);
        act_name.setText("Contacts");

        mList = (SwipeMenuListView) findViewById(R.id.listView);
        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {

                // create "delete" item
                SwipeMenuItem callitem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                callitem.setBackground(new ColorDrawable(Color.rgb(0x28,
                        0x28, 0x28)));
                // set item width
                callitem.setWidth(dp2px(90));
                // set a icon
                callitem.setIcon(R.drawable.callicon);
                // add to menu
                menu.addMenuItem(callitem);
                // create "delete" item
                SwipeMenuItem mailitem= new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                mailitem.setBackground(new ColorDrawable(Color.rgb(0x28,
                        0x28, 0x28)));
                // set item width
                mailitem.setWidth(dp2px(90));
                // set a icon
                mailitem.setIcon(R.drawable.mailicon);
                // add to menu
                menu.addMenuItem(mailitem);
                // create "delete" item
                SwipeMenuItem smsitem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                smsitem.setBackground(new ColorDrawable(Color.rgb(0x28,
                        0x28, 0x28)));
                // set item width
                smsitem.setWidth(dp2px(90));
                // set a icon
                smsitem.setIcon(R.drawable.smsicon);
                // add to menu
                menu.addMenuItem(smsitem);
            }
        };
        // set creator
        mList.setMenuCreator(creator);
        mList.setOpenInterpolator(new BounceInterpolator());
        mList.setCloseInterpolator(new BounceInterpolator());



        //Add events in this array
        events_1 = new String[] {"Abhishek Menon","Sanjeev Nair","Utkarsh Agrawal","Anurag Das","Vishnu KS",
                "Rajsekar Banoth","Anurag Sharma","Saptak Sengupta","Kumar Sanyam","S. P. Harish","Himadri Shah"};

        images = new int[] {R.drawable.a1, R.drawable.s,R.drawable.u,R.drawable.a2,R.drawable.v,R.drawable.a1,R.drawable.a3,
                R.drawable.s,R.drawable.k,R.drawable.s,R.drawable.h, R.mipmap.ic_launcher};

        timing = new String[] {"Festival Coordinator","Head Marketing and Management","Head IPR","Head Workshops","Head Events(IT)",
                "Head Creative","Head Finance","Web Head","App Head","Head Registrations and Hospitality","Head of Security"};

        intents = new String[]{"DES", "DES", "DES", "DES", "DES", "DES", "DES", "DES", "DES","DES", "DES", "DES", "DES", "DES", "DES", "DES", "DES"};

        initList(events_1, images, timing, intents);

    }


    public void initList(String[] eventsArray, int[] imagesList, String[] timingList, String[] intentsList) {
        if(eventsArray.length != 0) {

            ArrayList<HashMap<String, String>> eventList = new ArrayList<HashMap<String, String>>();

            for(int i = 0; i < eventsArray.length; i++) {
                HashMap<String, String> candy = new HashMap<String, String>();
                candy.put("event", eventsArray[i]);
                candy.put("image", Integer.toString(imagesList[i]));
                candy.put("time", timingList[i]);
                candy.put("intent", "com.app.aparoksha.apro16."+intentsList[i].trim());
                eventList.add(candy);
            }

            ListAdapter adapter = new SimpleAdapter(
                    Contacts.this ,
                    eventList,
                    R.layout.list_item,
                    new String[] { "event", "image", "time", "intent" },
                    new int[] { R.id.event_name, R.id.eventImg, R.id.eventTime, R.id.intent }) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView item_name = (TextView)view.findViewById(R.id.event_name);

                    return view;
                }
            };

            mList.setAdapter(adapter);
        }

        mList.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        String number23 = numbers[position];
                        Intent callIntent23 = new Intent(Intent.ACTION_VIEW);
                        callIntent23.setData(Uri.parse("tel:+91" + number23));
                        //else {
                        startActivity(callIntent23);

                        break;
                    case 1:
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("text/plain");
                        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"team.aparoksha@iiita.ac.in"});
                        try {
                            startActivity(Intent.createChooser(i, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(Contacts.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:

                        String nm = numbers[position];
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"
                                + "+91" + nm)));
                        break;

                }
                return false;
            }
        });

    }
    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
