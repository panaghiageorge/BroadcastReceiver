package com.example.user.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NextActivity extends AppCompatActivity {
    Button start;
   Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextcctivity_main);
         start = (Button) findViewById(R.id.btnstart);

        start.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent intent = new Intent("com.journaldev.broadcastreceiver.START_NOTIFICATION");

                sendBroadcast(intent);

            }

        });



   stop = (Button) findViewById(R.id.btnstop);

        stop.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent intent = new Intent("com.journaldev.broadcastreceiver.STOP_NOTIFICATION");

                sendBroadcast(intent);

            }

        });
    }
}