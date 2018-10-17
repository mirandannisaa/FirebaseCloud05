package com.example.miranda.platform05fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCM_MIRANDA";


    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.e("NEW_TOKEN",s);
        //2018-10-16 21:46:14.867 27240-27298/com.example.miranda.platform05fcm E/NEW_TOKEN: eicMoGui5jw:APA91bFs2-6b4YkHTkJlzmv6JLYdHzawP2TzpdzC36HH77LWUgxvUSNcSroXi89ZqJitsLZ6SmBxt5eTSjSfkeC3DpXti_0_fkN8nV-dDE8gv9S1JgB9XbsbE3a21TRH8eM5-DEVfZY5
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d(TAG, "Pengirim: " + remoteMessage.getFrom());

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG,"Pesannya adalah : " + remoteMessage.getData().get("body"));
        }

        //panggil display notif dr class notifmgr
        MyNotificationManager.getInstance(this).displayNotification(remoteMessage.getData().get("body"), remoteMessage.getData().get("tittle"));
    }
}