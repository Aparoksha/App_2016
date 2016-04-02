package com.app.aparoksha.apro16;

import android.content.Intent;
import android.graphics.Typeface;
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

import DBManager.DBFavs;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Favorites extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mList;
    private Toolbar toolbar;
    TextView act_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/JosefinSans-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
        setContentView(R.layout.favorites);
        toolbar = (Toolbar) findViewById(R.id.app_bar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        act_name = (TextView)findViewById(R.id.activity_name);
        Typeface tf1 = Typeface.createFromAsset(getAssets(),
                "JosefinSans-Regular.ttf");

        act_name.setTypeface(tf1);
        act_name.setText("Favorites");

        mList = (ListView)findViewById(R.id.listFav);

        //retrieving data
        DBFavs retrieve = new DBFavs(this);
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

        for(int i = 0; i < events.size(); i++) {
            HashMap<String, String> candy = new HashMap<String, String>();
            candy.put("event", events.get(i));
            //  candy.put("image", Integer.toString(imagesList[i]));
            //candy.put("time", timingList[i]);
            candy.put("intent", intents.get(i));
            eventList.add(candy);
        }

        ListAdapter adapter = new SimpleAdapter(
                Favorites.this ,
                eventList,
                R.layout.fav_item,
                new String[] { "event", "intent" },
                new int[] { R.id.favname, R.id.code}) ;

        mList.setAdapter(adapter);
        mList.setOnItemClickListener(this);



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
        else if(id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView  getIntentName = (TextView) view.findViewById(R.id.code);
        String intentToOpen = getIntentName.getText().toString();

        Intent i = new Intent(intentToOpen);
        i.putExtra("INTENT", intentToOpen);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
