package kr.co.hs.firebase.fcm.app;


import com.google.firebase.messaging.RemoteMessage;

import kr.co.hs.firebase.app.HsFirebaseActivity;
import kr.co.hs.firebase.fcm.IHsFirebaseMessaging;

/**
 * Created by Bae on 2016-12-27.
 */

public class HsFirebaseMessagingActivity extends HsFirebaseActivity implements IHsFirebaseMessaging {
    @Override
    public void subscribe(String topic) {
        HsFirebaseMessagingApplication application = getHsFirebaseMessagingApplication();
        if(application != null)
            application.subscribe(topic);
    }

    @Override
    public void unsubscribe(String topic) {
        HsFirebaseMessagingApplication application = getHsFirebaseMessagingApplication();
        if(application != null)
            application.unsubscribe(topic);
    }

    @Override
    public void send(RemoteMessage remoteMessage) {
        HsFirebaseMessagingApplication application = getHsFirebaseMessagingApplication();
        if(application != null)
            application.send(remoteMessage);
    }

    public HsFirebaseMessagingApplication getHsFirebaseMessagingApplication(){
        return (HsFirebaseMessagingApplication) getHsFirebaseApplication();
    }
}
