package com.denisimus.it.onesignalplagin;

import com.onesignal.OSNotification;
import com.onesignal.OneSignal;
import com.unity3d.player.UnityPlayer;

import org.json.JSONException;

import java.util.Iterator;

public class YourAppClass implements OneSignal.NotificationReceivedHandler  {

    public static void start(String id) {
        OneSignal.init(UnityPlayer.currentActivity, (String) null, id);
    }

    public static void sendTag(String key, String value) {
        OneSignal.sendTag(key, value);
    }

    @Override
    public void notificationReceived(OSNotification notification) {

        Iterator<String> keys = notification.payload.additionalData.keys();
        while (keys.hasNext()) {
            String key = keys.next();

            try {
                OneSignal.sendTag(key, notification.payload.additionalData.get(key).toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}

