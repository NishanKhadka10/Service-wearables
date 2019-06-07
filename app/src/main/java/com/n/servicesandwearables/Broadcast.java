package com.n.servicesandwearables;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Broadcast extends AppCompatActivity {
    BroadcastExample broadcastExample = new BroadcastExample();
    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcastExample,intentFilter);
    }


    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(broadcastExample);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);


    }

}
