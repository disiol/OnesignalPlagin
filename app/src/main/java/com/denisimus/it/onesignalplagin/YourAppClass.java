package com.denisimus.it.onesignalplagin;
import com.unity3d.player.UnityPlayer;

public class YourAppClass {

    public static void start(String id) {
        OneSignal.init(UnityPlayer.currentActivity, (String)null, id);
    }

    public static void nobot() {
        OneSignal.sendTag("nobot", "1");
    }
}

