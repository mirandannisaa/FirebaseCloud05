package com.example.miranda.platform05fcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class MyNotificationManager {

    private Context myContext;
    private static MyNotificationManager mInstance;

    private MyNotificationManager(Context context){
        myContext = context;
    }

    public static synchronized MyNotificationManager getInstance(Context context){
        if(mInstance == null){
            mInstance = new MyNotificationManager(context);
        }
        return mInstance;
    }

    public void displayNotification(String tittle, String body){
        String CHANNEL_ID = "my_channel_01";

        //klik konten di notif intent ke main act
        Intent resultIntent = new Intent(myContext, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(myContext, 0, resultIntent, PendingIntent.FLAG_ONE_SHOT);

        //parsing ke main act
        MainActivity.tittle = tittle;
        MainActivity.body = body;

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(myContext, CHANNEL_ID).setSmallIcon(R.drawable.ic_stat_name).setContentTitle(tittle).setContentText(body).setAutoCancel(true).setSound(defaultSoundUri).setContentIntent(pendingIntent);

        NotificationManager mNotifyMgr = (NotificationManager)myContext.getSystemService(Context.NOTIFICATION_SERVICE);

        if(mNotifyMgr != null){
            mNotifyMgr.notify(1, mBuilder.build());
        }
    }
}
