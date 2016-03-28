package com.app.aparoksha.apro16;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Eventlog extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;

    RecyclerView formalRecycler, informalRecycler, onlineRecycler, signatureRecycler;
    CardAdapter formalAdapter, informalAdapter, onlineAdapter, signatureAdapter;
    List<Event> formalEvents, informalEvents, onlineEvents, signatureEvents;
    Button b1,b2,b3,b4,b5,b6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventlog);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);


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
                    @Override
                    public void onItemClick(View view, int position) {
                        //Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                        switch (position) {
                            case 0:
                                Intent i0 = new Intent(Eventlog.this, Eventlist_Alkhwarizm.class);
                                startActivity(i0);
                                break;
                            case 1:
                                Intent i1= new Intent(Eventlog.this, Eventlist_HackInTheNorth.class);
                                startActivity(i1);
                                break;
                            case 2:
                                Intent i2= new Intent(Eventlog.this, Eventlist_HumbleFoolCup.class);
                                startActivity(i2);
                                break;
                            case 3:
                                Intent i3= new Intent(Eventlog.this, Eventlist_Talks.class);
                                startActivity(i3);
                                break;
                            case 4:
                                Intent i4= new Intent(Eventlog.this, Eventlist_TriHackerCup.class);
                                startActivity(i4);
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
                    @Override
                    public void onItemClick(View view, int position) {
                       // Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                        switch (position){
                            case 0:
                                Intent i0 = new Intent(Eventlog.this, Eventlist_Backbone.class);
                                startActivity(i0);
                                break;
                            case 1:
                                Intent i1 = new Intent(Eventlog.this, Eventlist_BioMeda.class);
                                startActivity( i1);
                                break;
                            case 2:
                                Intent i2 = new Intent(Eventlog.this, Eventlist_BlackBox.class);
                                startActivity( i2);
                                break;
                            case 3:
                                Intent i3 = new Intent(Eventlog.this, Eventlist_Bolt.class);
                                startActivity( i3);
                                break;
                            case 4:
                                Intent i4 = new Intent(Eventlog.this, Eventlist_CFresh.class);
                                startActivity( i4);
                                break;
                            case 5:
                                Intent i5 = new Intent(Eventlog.this, Eventlist_CHunt.class);
                                startActivity( i5);
                                break;
                            case 6:
                                Intent i6 = new Intent(Eventlog.this, Eventlist_CMaster.class);
                                startActivity( i6);
                                break;
                            case 7:
                                Intent i7 = new Intent(Eventlog.this, Eventlist_Coldfire.class);
                                startActivity( i7);
                                break;
                            case 8:
                                Intent i8 = new Intent(Eventlog.this, Eventlist_Eureka.class);
                                startActivity( i8);
                                break;
                            case 9:
                                Intent i9 = new Intent(Eventlog.this, Eventlist_GITHero.class);
                                startActivity( i9);
                                break;
                            case 10:
                                Intent i10 = new Intent(Eventlog.this, Eventlist_ITQuiz.class);
                                startActivity( i10);
                                break;
                            case 11:
                                Intent i11 = new Intent(Eventlog.this, Eventlist_Infinitum.class);
                                startActivity( i11);
                                break;
                            case 12:
                                Intent i12 = new Intent(Eventlog.this, Eventlist_PoolRunner.class);
                                startActivity( i12);
                                break;
                            case 13:
                                Intent i13 = new Intent(Eventlog.this, Eventlist_Riddilonics.class);
                                startActivity( i13);
                                break;
                            case 14:
                                Intent i14 = new Intent(Eventlog.this, Eventlist_TechDebate.class);
                                startActivity( i14);
                                break;
                            case 15:
                                Intent i15 = new Intent(Eventlog.this, Eventlist_TechnoFault.class);
                                startActivity( i15);
                                break;
                            case 16:
                                Intent i16 = new Intent(Eventlog.this, Eventlist_ThreeMusketeers.class);
                                startActivity( i16);
                                break;
                            case 17:
                                Intent i17 = new Intent(Eventlog.this, Eventlist_Webkriti.class);
                                startActivity( i17);
                                break;
                            case 18:
                                Intent i18 = new Intent(Eventlog.this, Eventlist_Wolfof2311.class);
                                startActivity( i18);
                                break;

                        }
                    }
                })
        );

        initializeInformalEvents();
        informalAdapter = new CardAdapter(informalEvents);
        informalRecycler.setAdapter(informalAdapter);
        informalRecycler.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                        switch(position){
                            case 0:
                                Intent i0 = new Intent(Eventlog.this, Eventlist_AgeofEmpiresIII.class);
                                startActivity(i0);
                                break;
                            case 1:
                                Intent i1 = new Intent(Eventlog.this, Eventlist_AndroidQuiz.class);
                                startActivity(i1);
                                break;
                            case 2:
                                Intent i2 = new Intent(Eventlog.this, Eventlist_BlindWar.class);
                                startActivity(i2);
                                break;
                            case 3:
                                Intent i3 = new Intent(Eventlog.this, Eventlist_ClashofClans.class);
                                startActivity(i3);
                                break;
                            case 4:
                                Intent i4 = new Intent(Eventlog.this, Eventlist_CounterStrike.class);
                                startActivity(i4);
                                break;
                            case 5:
                                Intent i5 = new Intent(Eventlog.this, Eventlist_FBSharingContest.class);
                                startActivity(i5);
                                break;
                            case 6:
                                Intent i6 = new Intent(Eventlog.this, Eventlist_FIFA.class);
                                startActivity(i6);
                                break;
                            case 7:
                                Intent i7 = new Intent(Eventlog.this, Eventlist_FlappyBird.class);
                                startActivity(i7);
                                break;
                            case 8:
                                Intent i8 = new Intent(Eventlog.this, Eventlist_LogoDesign.class);
                                startActivity(i8);
                                break;
                            case 9:
                                Intent i9 = new Intent(Eventlog.this, Eventlist_MRGoogler.class);
                                startActivity(i9);
                                break;
                            case 10:
                                Intent i10 = new Intent(Eventlog.this, Eventlist_PencilSketching.class);
                                startActivity(i10);
                                break;
                            case 11:
                                Intent i11 = new Intent(Eventlog.this, Eventlist_SplitSecond.class);
                                startActivity(i11);
                                break;
                            case 12:
                                Intent i12 = new Intent(Eventlog.this, Eventlist_Tekken.class);
                                startActivity(i12);
                                break;
                            case 13:
                                Intent i13 = new Intent(Eventlog.this, Eventlist_TinderTime.class);
                                startActivity(i13);
                                break;
                            case 14:
                                Intent i14 = new Intent(Eventlog.this, Eventlist_TreasureHunt.class);
                                startActivity(i14);
                                break;
                            case 15:
                                Intent i15 = new Intent(Eventlog.this, Eventlist_QWERTYWars.class);
                                startActivity(i15);
                                break;
                            case 16:
                                Intent i16 = new Intent(Eventlog.this, Eventlist_VFlare.class);
                                startActivity(i16);
                                break;
                        }
                    }
                })
        );

        initializeOnlineEvents();
        onlineAdapter = new CardAdapter(onlineEvents);
        onlineRecycler.setAdapter(onlineAdapter);
        onlineRecycler.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                        switch(position){
                            case 0:
                                Intent i0 = new Intent(Eventlog.this, Eventlist_ExMachina.class);
                                startActivity(i0);
                                break;
                            case 1:
                                Intent i1 = new Intent(Eventlog.this, Eventlist_TechnoBooz.class);
                                startActivity(i1);
                                break;
                            case 2:
                                Intent i2 = new Intent(Eventlog.this, Eventlist_Platzen.class);
                                startActivity(i2);
                                break;
                        }
                    }
                })
        );


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
        signatureEvents.add(new Event("Alkhwarizm", R.drawable.first));
        signatureEvents.add(new Event("Hack in the North", R.drawable.hackinthenorth));
        signatureEvents.add(new Event("Humble Fool Cup", R.drawable.humblefool));
        signatureEvents.add(new Event("Tech Talks", R.drawable.first));
        signatureEvents.add(new Event("Tri Hacker Cup", R.drawable.first));

    }






    private void initializeFormalEvents() {
        formalEvents = new ArrayList<>();
        formalEvents.add(new Event("Backbone", R.drawable.backbone));
        formalEvents.add(new Event("Bio Meda", R.drawable.first));
        formalEvents.add(new Event("Black Box", R.drawable.blackbox));
        formalEvents.add(new Event("Bolt", R.drawable.bolt));
        formalEvents.add(new Event("C Fresh", R.drawable.cfresh));
        formalEvents.add(new Event("C Hunt", R.drawable.chunt));
        formalEvents.add(new Event("C Master", R.drawable.first));
        formalEvents.add(new Event("Coldfire", R.drawable.third));
        formalEvents.add(new Event("Eureka", R.drawable.eureka));
        formalEvents.add(new Event("GIT Hero", R.drawable.githero));
        formalEvents.add(new Event("IT Quiz", R.drawable.second));
        formalEvents.add(new Event("Infinitum", R.drawable.infinitum));
        formalEvents.add(new Event("Pool Runner", R.drawable.pool));
        formalEvents.add(new Event("Riddilonics", R.drawable.riddlonics));
        formalEvents.add(new Event("Tech Debate", R.drawable.techdebate));
        formalEvents.add(new Event("Techno Fault", R.drawable.technofault));
        formalEvents.add(new Event("Three Musketeers", R.drawable.threemuski));
        formalEvents.add(new Event("Webkriti", R.drawable.webkrit));
        formalEvents.add(new Event("Wolf of 2311", R.drawable.wolfof));

    }


    private void initializeInformalEvents() {
        informalEvents = new ArrayList<>();
        informalEvents.add(new Event("Age of Empires III", R.drawable.ageofempire));
        informalEvents.add(new Event("Android Quiz", R.drawable.android));

        informalEvents.add(new Event("Blind War", R.drawable.blindwar));
        informalEvents.add(new Event("Clash of Clans", R.drawable.third));
        informalEvents.add(new Event("Counter Strike", R.drawable.first));
        informalEvents.add(new Event("FB Sharing Contest", R.drawable.fbshare));
        informalEvents.add(new Event("FIFA", R.drawable.third));
        informalEvents.add(new Event("Flappy Bird", R.drawable.flappy));
        informalEvents.add(new Event("Logo Design", R.drawable.logodesigning));
        informalEvents.add(new Event("Mr. Googler", R.drawable.mrgoogler));
        informalEvents.add(new Event("Pencil Sketching", R.drawable.pencilsketck));
        informalEvents.add(new Event("Split Second", R.drawable.splitsecond));
        informalEvents.add(new Event("Tekken 6", R.drawable.first));
        informalEvents.add(new Event("Tinder Time", R.drawable.first));
        informalEvents.add(new Event("Tresure Hunt", R.drawable.treasurehunt));
        informalEvents.add(new Event("Qwerty Wars", R.drawable.qwertywars));
        informalEvents.add(new Event("V Flare", R.drawable.first));
    }

    private void initializeOnlineEvents() {
        onlineEvents = new ArrayList<>();
        onlineEvents.add(new Event("Ex-Machina", R.drawable.exmachina));
        onlineEvents.add(new Event("Techno Booz", R.drawable.first));
        onlineEvents.add(new Event("Platzen", R.drawable.first));

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
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                Intent i1 = new Intent(Eventlog.this, Cat_coding.class);
                startActivity(i1);
                break;
            case R.id.button2:
                //Log.d("hello","button2");
                Intent i2 = new Intent(Eventlog.this,Cat_development.class);
                startActivity(i2);
                break;
            case R.id.button3:
                Intent i3 = new Intent(Eventlog.this, Cat_electronics.class);
                startActivity(i3);
                break;
            case R.id.button4:
                Intent i4 = new Intent(Eventlog.this, Cat_quiz.class);
                startActivity(i4);
                break;
            case R.id.button5:
                Intent i5 = new Intent(Eventlog.this, Cat_games.class);
                startActivity(i5);
                break;
            case R.id.button6:
                Intent i6 = new Intent(Eventlog.this, Cat_misc.class);
                startActivity(i6);
                break;
        }
    }
}






