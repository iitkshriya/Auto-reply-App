package com.example.shriya.auto_replyapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

/**
 * Created by Shriya on 30-Nov-16.
 */

public class NotificationService extends NotificationListenerService{
    Context context;

    @Override

    public void onCreate() {

        super.onCreate();
        context = getApplicationContext();

    }

    @Override

    public void onNotificationPosted(StatusBarNotification sbn) {

        String pack = sbn.getPackageName();
        String ticker = sbn.getNotification().tickerText.toString();
        Bundle extras = sbn.getNotification().extras;
        String title = extras.getString("android.title");
        String text = extras.getCharSequence("android.text").toString();
        String origin = extras.getString("android.userId");

        if (pack.equals("com.facebook")){
            String url = "http://www.facebook.com/messages/"++origin ;
            Intent opnpage = new Intent(Intent.ACTION_SEND);
            opnpage.setData(Uri.parse(url));
            opnpage.putExtra(Intent.EXTRA_TEXT, MainActivity.messageDefault);
            opnpage.setPackage(""); /*set browser to be chosen*/
            startActivity(opnpage);


        }
        if (pack.equals("com.whatsapp")){

            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, MainActivity.messageDefault);
            sendIntent.putExtra(Intent.EXTRA_TITLE, title );
            sendIntent.setType("text/plain");
            sendIntent.setPackage(pack);
            startActivity(sendIntent);
    }

}
