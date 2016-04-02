package com.app.aparoksha.apro16;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by Satyam Poddar on 30-Jan-16.
 */
public class Schedule extends AppCompatActivity {
    private Toolbar toolbar;
    GridView grid;
    String[] text = {
            "Day 1",
            "Day 2",
            "Day 3",
            "Day 4"

    } ;
    int[] imageId = {
            R.drawable.day1,
            R.drawable.day2,
            R.drawable.day3,
            R.drawable.day4,

    };
    TextView act_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        act_name = (TextView)findViewById(R.id.activity_name);
        Typeface tf1 = Typeface.createFromAsset(getAssets(),
                "JosefinSans-Regular.ttf");

        act_name.setTypeface(tf1);
        act_name.setText("Schedule");

        CustomGrid adapter = new CustomGrid(Schedule.this, text, imageId);
        grid=(GridView)findViewById(R.id.gridSchedule);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(Schedule.this, "You Clicked at " + text[+position], Toast.LENGTH_SHORT).show();
                switch(position){
                    case 0:
                        Intent i0 = new Intent(Schedule.this,Day0.class);
                        startActivity(i0);
                        break;
                    case 1:
                        Intent i1 = new Intent(Schedule.this,Day1.class);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(Schedule.this,Day2.class);
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(Schedule.this,Day3.class);
                        startActivity(i3);
                        break;
                }
            }
        });

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
    protected void onDestroy() {
        super.onDestroy();
    }
}
