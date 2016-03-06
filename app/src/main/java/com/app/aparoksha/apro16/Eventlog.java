package com.app.aparoksha.apro16;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Eventlog extends AppCompatActivity {

    RecyclerView formalRecycler, informalRecycler, onlineRecycler, signatureRecycler;
    CardAdapter formalAdapter, informalAdapter, onlineAdapter, signatureAdapter;
    List<Event> formalEvents, informalEvents, onlineEvents, signatureEvents;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventlog);

        formalRecycler = (RecyclerView) findViewById(R.id.formalEventList);
        informalRecycler = (RecyclerView) findViewById(R.id.informalEventList);
        onlineRecycler = (RecyclerView) findViewById(R.id.onlineEventList);
        signatureRecycler = (RecyclerView) findViewById(R.id.signatureEventList);


        LinearLayoutManager ll0 = new LinearLayoutManager(this);
        ll0.setOrientation(LinearLayoutManager.HORIZONTAL);

        LinearLayoutManager ll1 = new LinearLayoutManager(this);
        ll1.setOrientation(LinearLayoutManager.HORIZONTAL);

        LinearLayoutManager ll2 = new LinearLayoutManager(this);
        ll2.setOrientation(LinearLayoutManager.HORIZONTAL);

        LinearLayoutManager ll3 = new LinearLayoutManager(this);
        ll3.setOrientation(LinearLayoutManager.HORIZONTAL);

        signatureRecycler.setLayoutManager(ll0);
        formalRecycler.setLayoutManager(ll1);
        informalRecycler.setLayoutManager(ll2);
        onlineRecycler.setLayoutManager(ll3);

        initializeSignatureEvents();
        signatureAdapter = new CardAdapter(signatureEvents);
        signatureRecycler.setAdapter(signatureAdapter);
        signatureRecycler.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        //Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                        switch(position)
                        {
                            case 0 :
                                Intent i0 =  new Intent(Eventlog.this,Description.class);
                                startActivity(i0);
                                break;
                            case 1 :
                                break;
                            case 2 :
                                break;
                            case 3 :
                                break;
                            case 4 :
                                break;
                        }
                    }
                })
        );

        initializeFormalEvents();
        formalAdapter = new CardAdapter(formalEvents);
        formalRecycler.setAdapter(formalAdapter);
        formalRecycler.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                    }
                })
        );

        initializeInformalEvents();
        informalAdapter = new CardAdapter(informalEvents);
        informalRecycler.setAdapter(informalAdapter);

        initializeOnlineEvents();
        onlineAdapter = new CardAdapter(onlineEvents);
        onlineRecycler.setAdapter(onlineAdapter);


//        final ImageView imageView = (ImageView) findViewById(R.id.imageAnimation);

 /*       final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i=0;
            public void run() {
                imageView.setImageResource(imageArray[i]);
                i++;
                if(i>imageArray.length-1)
                {
                    i=0;
                }
                handler.postDelayed(this, 2500);  //for interval...
            }
        };
        handler.postDelayed(runnable, 2000); //for initial delay..

   */


    }



    private void initializeSignatureEvents() {
        signatureEvents = new ArrayList<>();
        signatureEvents.add(new Event(" signature event 1", R.drawable.first));
        signatureEvents.add(new Event(" signature event 2", R.drawable.second));
        signatureEvents.add(new Event(" signature event 3", R.drawable.third));
        signatureEvents.add(new Event(" signature event 4", R.drawable.fourth));
        signatureEvents.add(new Event(" signature event 5", R.mipmap.ic_launcher));

    }






    private void initializeFormalEvents() {
        formalEvents = new ArrayList<>();
        formalEvents.add(new Event(" formal event 1", R.drawable.first));
        formalEvents.add(new Event("formal event 2", R.drawable.second));
        formalEvents.add(new Event("formal event 3", R.drawable.third));
        formalEvents.add(new Event("formal event 4", R.drawable.fourth));
        formalEvents.add(new Event("formal event 5", R.mipmap.ic_launcher));

    }


    private void initializeInformalEvents() {
        informalEvents = new ArrayList<>();
        informalEvents.add(new Event(" informal event 1", R.drawable.first));
        informalEvents.add(new Event("informal event 2", R.drawable.second));
        informalEvents.add(new Event("informal event 3", R.drawable.third));
        informalEvents.add(new Event("informal event 4", R.drawable.fourth));
        informalEvents.add(new Event("informal event 5", R.mipmap.ic_launcher));
    }

    private void initializeOnlineEvents() {
        onlineEvents = new ArrayList<>();
        onlineEvents.add(new Event(" online event 1", R.drawable.first));
        onlineEvents.add(new Event("online event 2", R.drawable.second));
        onlineEvents.add(new Event("online event 3", R.mipmap.ic_launcher));
        onlineEvents.add(new Event("online event 4", R.drawable.third));
        onlineEvents.add(new Event("online event 5", R.drawable.fourth));
        onlineEvents.add(new Event("event 6", R.mipmap.ic_launcher));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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






