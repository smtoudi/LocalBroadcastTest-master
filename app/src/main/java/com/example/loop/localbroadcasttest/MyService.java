package com.example.loop.localbroadcasttest;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by loop on 28/02/17.
 */

public class MyService extends IntentService {


    public static final String MY_ACTION = "com.loop.example.myaction";

    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent messageIntent = new Intent(MY_ACTION);
        messageIntent.putExtra("message", SimpleDateFormat.getDateTimeInstance().format(new Date()));
        LocalBroadcastManager.getInstance(this).sendBroadcast(messageIntent);
    }
}
