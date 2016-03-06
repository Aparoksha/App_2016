package com.app.aparoksha.apro16;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by Satyam Poddar on 30-Jan-16.
 */
public class Schedule extends Activity {
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

        CustomGrid adapter = new CustomGrid(Schedule.this, text, imageId);
        grid=(GridView)findViewById(R.id.gridSchedule);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(Schedule.this, "You Clicked at " + text[+position], Toast.LENGTH_SHORT).show();

            }
        });

    }

}
