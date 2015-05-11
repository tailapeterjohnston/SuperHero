package com.example.tailajohnston.superhero;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.Button;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by tailajohnston on 9/05/15.
 */
public class MainActivity extends AppCompatActivity implements LocationListener {

    private static final String TAG = "tailasMessage";


    Button gpsSMSButton;
    Button emergencyContactsButton;

    TextView txtLat;


    // ADDED FOR LOCATION
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    String lat;
    String provider;
    protected String latitude,longitude;
    protected boolean gps_enabled,network_enabled;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gpsSMSButton = (Button)findViewById(R.id.gpsSMSButton);
        emergencyContactsButton = (Button)findViewById(R.id.emergencyButton);
        txtLat = (TextView)findViewById(R.id.latLongTextView);


//        //start LatAndLongService
//        Intent i = new Intent(this, FindLatLongService.class);
//        startService(i);
//        Log.i(TAG, "LatAndLongService has been executed in MainActivity ");
//
//        txtLat.setText(FindLatLongService.latnLong);
//

        // set onClick listener for GPS Button
        gpsSMSButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                // We want to send Data via HTTP Connection.
                // Make Connection
                // Find Location
                // Get Emergency Contacts
                getLocationChange();
                gpsSMSButton.setTextColor(Color.RED);
                Log.i(TAG, "gps Button pressed");

            }
        });



        emergencyContactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // We go to contacts page.
                emergencyContactsButton.setTextColor(Color.RED);
                
                Log.i(TAG, "Emergency Contacts button pressed");

            }
        });


        //Log
        Log.i(TAG, "onCreate");
    }

    public void getLocationChange() {

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        onLocationChanged(location);

        Log.i(TAG, "getLocationChange");


    }

    public void onLocationChanged(Location location) {
        txtLat = (TextView) findViewById(R.id.latLongTextView);
        txtLat.setText("Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
        Log.i(TAG, "onLocationChanged");
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude","disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude", "status");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");

    }



}
