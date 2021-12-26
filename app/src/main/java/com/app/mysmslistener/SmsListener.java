package com.app.mysmslistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Arrays;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class SmsListener extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Log.d("cuongnb", "onReceive: ");
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            WorkManager
                    .getInstance(context)
                    .beginWith(Arrays.asList(new OneTimeWorkRequest.Builder(MySecondWorker.class).build()))
                    .then(new OneTimeWorkRequest.Builder(MyThirdWorker.class).build()).enqueue();
        }
    }
}