package com.gomore.adv.myreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.gomore.adv.MainActivity;

/**
 * Created by asus on 2018/1/25.
 */

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
