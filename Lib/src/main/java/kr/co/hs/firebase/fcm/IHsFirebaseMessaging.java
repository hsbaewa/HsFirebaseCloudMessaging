package kr.co.hs.firebase.fcm;

import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Bae on 2016-12-27.
 */

public interface IHsFirebaseMessaging {
    void subscribe(String topic);
    void unsubscribe(String topic);
    void send(RemoteMessage remoteMessage);
}
