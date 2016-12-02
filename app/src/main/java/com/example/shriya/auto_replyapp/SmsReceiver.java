package com.example.shriya.auto_replyapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

/**
 * Created by Shriya on 02-Dec-16.
 */

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive (Context context, Intent intent){

        Bundle bundle = intent.getExtras();

        if (bundle != null){
            Object[] pdus =(Object[]) bundle.get("pdus");
            String senderNumber = null;
            for (int i = 0; i < pdus.length; i++){
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdus[i]);
                senderNumber = sms.getOriginatingAddress();
            }

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(senderNumber,null,MainActivity.messageDefault, null, null);
        }
    }
}
