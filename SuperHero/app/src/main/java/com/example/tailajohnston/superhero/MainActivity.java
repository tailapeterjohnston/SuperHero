package com.example.tailajohnston.superhero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.Button;
import android.util.Log;
import android.view.View;

/**
 * Created by tailajohnston on 9/05/15.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "tailasMessage";


    Button gpsSMSButton;
    Button emergencyContactsButton;


//    public MainActivity(Bundle savedInstance) {
//
//        //set the layout for a new activity
//        super.onCreate(savedInstance);
//
//
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gpsSMSButton = (Button)findViewById(R.id.gpsSMSButton);
        emergencyContactsButton = (Button)findViewById(R.id.emergencyButton);

        // set onClick listener for GPS Button
        gpsSMSButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                // We want to send Data via HTTP Connection.
                // Make Connection
                // Find Location
                // Get Emergency Contacts

                Log.i(TAG, "gps Button pressed");
            }
        });



        //Log
        Log.i(TAG, "onCreate");
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
