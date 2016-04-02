package com.app.aparoksha.apro16;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Navigate extends AppCompatActivity implements View.OnClickListener {
    LinearLayout audi, iiita, cc3, ground;
    TextView act_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);


        act_name = (TextView)findViewById(R.id.activity_name);
        Typeface tf1 = Typeface.createFromAsset(getAssets(),
                "JosefinSans-Regular.ttf");

        act_name.setTypeface(tf1);
        act_name.setText("Navigate");

        audi = (LinearLayout) findViewById(R.id.audi);
        iiita = (LinearLayout) findViewById(R.id.iiit);
        cc3 = (LinearLayout) findViewById(R.id.cc3);
        ground = (LinearLayout) findViewById(R.id.ground);
        audi.setOnClickListener(this);
        iiita.setOnClickListener(this);
        cc3.setOnClickListener(this);
        ground.setOnClickListener(this);


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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iiit:
                LocationManager locationManager3 = (LocationManager) getSystemService(LOCATION_SERVICE);

                // Creating a criteria object to retrieve provider
                Criteria criteria3 = new Criteria();

                // Getting the name of the best provider
                String provider3 = locationManager3.getBestProvider(criteria3, true);

                // Getting Current Location
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    Toast.makeText(this, "Grant the permissions", Toast.LENGTH_SHORT);
                    return;
                }
                Location location3 = locationManager3.getLastKnownLocation(provider3);

                String s3 = "25.429269, 81.773089";
                if (location3 != null) {
                    double lat = location3.getLatitude();
                    double lon = location3.getLongitude();
                    s3 = "";
                    s3 = String.format("%f,%f", lat, lon);
                }
                Intent intent3 = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=" + s3 + "&daddr=25.4296393,81.7700871"));
                intent3.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent3);
                break;
            case R.id.audi:
                LocationManager locationManager2 = (LocationManager) getSystemService(LOCATION_SERVICE);

                // Creating a criteria object to retrieve provider
                Criteria criteria2 = new Criteria();

                // Getting the name of the best provider
                String provider2 = locationManager2.getBestProvider(criteria2, true);

                // Getting Current Location
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    Toast.makeText(this, "Grant the permissions", Toast.LENGTH_SHORT);
                    return;
                }
                Location location2 = locationManager2.getLastKnownLocation(provider2);

                String s2 = "25.429269, 81.773089";
                if (location2 != null) {
                    double lat = location2.getLatitude();
                    double lon = location2.getLongitude();
                    s2 = "";
                    s2 = String.format("%f,%f", lat, lon);
                }
                Intent intent2 = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=" + s2 + "&daddr=25.4307681,81.7701595"));
                intent2.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent2);
                break;
            case R.id.ground:

                LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

                // Creating a criteria object to retrieve provider
                Criteria criteria = new Criteria();

                // Getting the name of the best provider
                String provider = locationManager.getBestProvider(criteria, true);

                // Getting Current Location
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    Toast.makeText(this, "Grant the permissions", Toast.LENGTH_SHORT);
                    return;
                }
                Location location = locationManager.getLastKnownLocation(provider);

                String s = "25.429269, 81.773089";
                if (location != null) {
                    double lat = location.getLatitude();
                    double lon = location.getLongitude();
                    s = "";
                    s = String.format("%f,%f", lat, lon);
                }
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=" + s + "&daddr=25.429050, 81.771413"));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
                break;
            case R.id.cc3:

                LocationManager locationManager1 = (LocationManager) getSystemService(LOCATION_SERVICE);

                // Creating a criteria object to retrieve provider
                Criteria criteria1 = new Criteria();

                // Getting the name of the best provider
                String provider1 = locationManager1.getBestProvider(criteria1, true);

                // Getting Current Location
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    Toast.makeText(this, "Grant the permissions", Toast.LENGTH_SHORT);
                    return;
                }
                Location location1 = locationManager1.getLastKnownLocation(provider1);

                String s1 = "25.429269, 81.773089";
                if(location1!=null){
                    double lat = location1.getLatitude();
                    double lon = location1.getLongitude();
                    s1 = "";
                    s1 = String.format("%f,%f", lat, lon);
                }
                Intent intent1 = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=" + s1 + "&daddr=25.4318993,81.7703311"));
                intent1.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent1);
                break;
        }
    }
}
