package com.app.aparoksha.apro16;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Satyam Poddar on 30-Jan-16.
 */
public class Day1 extends AppCompatActivity{
    private Toolbar toolbar;
    private SwipeMenuListView mList;
    String[] events_1;
    int[] images;
    String[] timing;
    String[]venue;
    String[] intents;
    TextView eventName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventsnow);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mList = (SwipeMenuListView) findViewById(R.id.listView);
        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0x38, 0x8e,
                        0x3c)));
                // set item width
                openItem.setWidth(dp2px(90));
                // set item title
                openItem.setTitle("Open");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xff,
                        0x00, 0x00)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_settings);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        // set creator
        mList.setMenuCreator(creator);
        mList.setOpenInterpolator(new BounceInterpolator());
        mList.setCloseInterpolator(new BounceInterpolator());



        //Add events in this array
        events_1 = new String[] {"Hack In The North", "Workshops", "NuVision", "Humble Fool Cup Finals", "Biomeda Round 1","Riddilonics Round 1","Pencil Sketching","Blind Wars","Tech Talks-Ashoke Sen","Techno Fault(Round 1)","Wolf of 2311(Round 1)","Tech Quiz(Round 1)","Movie-Ex Machina","Tech Debate(Round 1)","QWERTY Wars","Counter Strike","Movie","Movie"};

        images = new int[] {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher };

        timing = new String[] {"1 PM - 6 PM","1 PM - 2 PM","1.30 PM - 3 PM","3 PM - 4.30 PM","4 PM - 6 PM","5 PM","5 PM - 6 PM","6.30 PM - 7.30 PM","7.30 PM - 8.00 PM","8.30 PM","8.30 PM - 10.30 PM","10.30 PM - 2 AM","10.30 PM","10 PM","1 AM"};

        venue = new String[]{"CC3","CC3","CC3","CC3","CC3","Cafeteria","CC3","Main Audi","CC3","CC3","CC3","LT","Admin Audi","CC3","CC3","LT","LT"};

        intents = new String[]{"DES","DES","DES","DES","DES","DES","DES","DES","DES","DES","DES","DES","DES","DES","DES","DES","DES","DES" };

        initList(events_1, images, timing, venue, intents);

    }


    public void initList(String[] eventsArray, int[] imagesList, String[] timingList, String[] venue,String[] intentsList) {
        if(eventsArray.length != 0) {

            ArrayList<HashMap<String, String>> eventList = new ArrayList<HashMap<String, String>>();

            for(int i = 0; i < eventsArray.length; i++) {
                HashMap<String, String> candy = new HashMap<String, String>();
                candy.put("event", eventsArray[i]);
                candy.put("image", Integer.toString(imagesList[i]));
                candy.put("time", timingList[i]);
                candy.put("venue", venue[i]);
                candy.put("intent", "com.app.aparoksha.apro16."+intentsList[i].trim());
                eventList.add(candy);
            }

            ListAdapter adapter = new SimpleAdapter(
                    Day1.this ,
                    eventList,
                    R.layout.list_item,
                    new String[] { "event", "image", "time","venue", "intent" },
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
                        // open

                        String intentToOpen = "com.app.aparoksha.apro16." + intents[position];

                        Intent i = new Intent(intentToOpen);
                        i.putExtra("INTENT", intentToOpen);
                        startActivity(i);

                        break;
                    case 1:
                        Intent it = new Intent("com.app.aparoksha.apro16.SN");
                        it.putExtra("event", events_1[position]);
                        it.putExtra("address","com.app.aparoksha.apro16."+ intents[position]);
                        startActivity(it);
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
}
