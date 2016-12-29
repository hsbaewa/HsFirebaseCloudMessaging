package kr.co.hs.firebase.fcm.app;

import com.google.firebase.messaging.RemoteMessage;

import kr.co.hs.firebase.app.HsFirebaseApplication;
import kr.co.hs.firebase.fcm.HsFirebaseMessagingUtils;
import kr.co.hs.firebase.fcm.IHsFirebaseMessaging;

/**
 * Created by Bae on 2016-12-27.
 */

public class HsFirebaseMessagingApplication extends HsFirebaseApplication implements IHsFirebaseMessaging {

    @Override
    public void subscribe(String topic) {
        HsFirebaseMessagingUtils.getInstance().subscribe(topic);
    }

    @Override
    public void unsubscribe(String topic) {
        HsFirebaseMessagingUtils.getInstance().unsubscribe(topic);
    }

    @Override
    public void send(RemoteMessage remoteMessage) {
        HsFirebaseMessagingUtils.getInstance().send(remoteMessage);
    }
}
