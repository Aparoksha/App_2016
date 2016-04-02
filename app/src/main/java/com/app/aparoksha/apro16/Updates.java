package com.app.aparoksha.apro16;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import DBManager.DBNotif;

/**
 * Created by Satyam Poddar on 30-Jan-16.
 */

public class Updates extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Integer temp;
    TextView tv;
    private Toolbar toolbar;
    private ListView mList;
    private View shad;
    String[] events = new String[20];
    int[] images;
    String[] timing = new String[20];
    String[] venue = new String[20];
    String[] intents = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // getWindow().requestFeature((Window.FEATURE_ACTION_BAR_OVERLAY));
        super.onCreate(savedInstanceState);

        setContentView(R.layout.updates);

        toolbar = (Toolbar) findViewById(R.id.app_bar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //dont forget to change the list ID
        mList = (ListView) findViewById(R.id.listUpdate);
        //shad = (View) findViewById(R.id.shadow);
        //   mList = (ListView)findViewById(R.id.listFav);

        //retrieving data
        DBNotif retrieve = new DBNotif(this);
        retrieve.openandwrite();
        Object[] obj = new Object[2];
        ArrayList<String> events = new ArrayList<String>();
        ArrayList<String> intents = new ArrayList<String>();
        obj = retrieve.getData(0);
        events = (ArrayList<String>) obj[0];
        intents = (ArrayList<String>) obj[1];
        Log.d("hello",events + " " + intents);
        retrieve.close();
        //retreival closed

        ArrayList<HashMap<String, String>> eventList = new ArrayList<HashMap<String, String>>();

        for(int i = (events.size()-1); i >= 0; i--) {
            HashMap<String, String> candy = new HashMap<String, String>();
            candy.put("event", events.get(i));
            //  candy.put("image", Integer.toString(imagesList[i]));
            //candy.put("time", timingList[i]);
            candy.put("intent", intents.get(i));
            eventList.add(candy);
        }

        ListAdapter adapter = new SimpleAdapter(
                Updates.this ,
                eventList,
                R.layout.update_items,
                new String[] { "event", "intent" },
                new int[] { R.id.event_name, R.id.intent}) ;

        mList.setAdapter(adapter);
        mList.setOnItemClickListener(this);

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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView  getIntentName = (TextView) view.findViewById(R.id.intent);
        String intentToOpen = getIntentName.getText().toString();

        Intent i = new Intent(intentToOpen);
        i.putExtra("INTENT", intentToOpen);
        startActivity(i);
    }
}

