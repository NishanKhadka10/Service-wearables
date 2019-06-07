package com.n.servicesandwearables;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import createchannel.CreateChannel;

public class BroadcastExample extends BroadcastReceiver {
    private NotificationManagerCompat notificationManagerCompat;
    Context context;

    public BroadcastExample(Context context) {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean noConnectivity;
        notificationManagerCompat = NotificationManagerCompat.from(context);
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

            if (noConnectivity) {
                Toast.makeText(context, "Disconnected", Toast.LENGTH_LONG).show();
                DisplayNotification();


            } else {
                Toast.makeText(context, "Connected", Toast.LENGTH_LONG).show();
                DisplayNotification2();
            }
        }
    }

    private void DisplayNotification()
    {
        Notification notification = new NotificationCompat.Builder(context, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_sms)
                .setContentTitle("No connection")
                .setContentText("No connectivity , please connect")
                .setCategory(NotificationCompat.CATEGORY_SYSTEM)
                .build();

        notificationManagerCompat.notify(1,notification);
    }

    private void DisplayNotification2(){
        Notification notification = new NotificationCompat.Builder(context,CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_sms)
                .setContentTitle("Connected")
                .setContentText("You have been connected to the network")
                .setCategory(NotificationCompat.CATEGORY_SYSTEM)
                .build();

        notificationManagerCompat.notify(2,notification);
    }
}
