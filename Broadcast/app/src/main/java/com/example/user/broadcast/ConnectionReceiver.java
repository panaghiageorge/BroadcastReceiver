package com.example.user.broadcast;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import static android.content.Context.NOTIFICATION_SERVICE;

public class ConnectionReceiver extends BroadcastReceiver {

    @Override

    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("com.journaldev.broadcastreceiver.START_NOTIFICATION")){

            Toast.makeText(context, "START_NOTIFICATION is received", Toast.LENGTH_LONG).show();



            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

            builder.setSmallIcon(android.R.drawable.ic_dialog_alert);

            Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.journaldev.com/"));

            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intentView, 0);

            builder.setContentIntent(pendingIntent);

            builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher));

            builder.setContentTitle("Notifications Title");

            builder.setContentText("Your notification content here.");

            builder.setSubText("Tap to view the website.");



            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);



            // Will display the notification in the notification bar

            notificationManager.notify(1, builder.build());



        } else  if(intent.getAction().equals("com.journaldev.broadcastreceiver.STOP_NOTIFICATION")){

            Toast.makeText(context, "STOP_NOTIFICATION is received", Toast.LENGTH_LONG).show();



            String ns = NOTIFICATION_SERVICE;

            NotificationManager nMgr = (NotificationManager) context.getApplicationContext().getSystemService(ns);

            nMgr.cancel(1);

        }

    }
}
