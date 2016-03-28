package com.app.aparoksha.apro16;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by Satyam Poddar on 30-Jan-16.
 */
public class Schedule extends AppCompatActivity {
    private Toolbar toolbar;
    GridView grid;
    String[] text = {
            "Prelims",
            "Day 1",
            "Day 2",
            "Day 3"

    } ;
    int[] imageId = {
            R.drawable.b1,
            R.drawable.b2,
            R.drawable.b3,
            R.drawable.b4,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CustomGrid adapter = new CustomGrid(Schedule.this, text, imageId);
        grid=(GridView)findViewById(R.id.gridSchedule);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(Schedule.this, "You Clicked at " + text[+position], Toast.LENGTH_SHORT).show();
                Intent i;
                if(text[+position].equals("Prelims")) {
                     i = new Intent(Schedule.this, Day0.class);
                }
                else if(text[+position].equals("Day 1")) {
                     i = new Intent(Schedule.this, Day1.class);
                }
                else if(text[+position].equals("Day 2")) {
                     i = new Intent(Schedule.this, Day2.class);
                }
                else{
                     i = new Intent(Schedule.this, Day3.class);
                }

                startActivity(i);

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
