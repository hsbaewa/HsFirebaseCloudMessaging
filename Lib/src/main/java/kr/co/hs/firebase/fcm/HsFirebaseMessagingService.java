package kr.co.hs.firebase.fcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.google.firebase.messaging.FirebaseMessagingService;

import kr.co.hs.content.HsPreferences;
import kr.co.hs.firebase.IHsFirebaseApplication;
import kr.co.hs.firebase.IHsFirebaseService;
import kr.co.hs.firebase.app.HsFirebaseApplication;


/**
 * Created by Bae on 2016-12-25.
 */

public class HsFirebaseMessagingService extends FirebaseMessagingService implements IHsFirebaseService {

    @Override
    public HsFirebaseApplication getHsFirebaseApplication() {
        Context context = getApplicationContext();
        if(context != null){
            HsFirebaseApplication application = (HsFirebaseApplication) context;
            return application;
        }
        return null;
    }

    @Override
    public String getFirebaseToken() {
        HsFirebaseApplication application = getHsFirebaseApplication();
        if(application != null)
            return application.getFirebaseToken();
        return null;
    }

    @Override
    public HsPreferences getDefaultPreference() {
        HsFirebaseApplication application = getHsFirebaseApplication();
        if(application != null)
            return application.getDefaultPreference();
        return null;
    }

    @Override
    public String getDeviceId() {
        IHsFirebaseApplication application = getHsFirebaseApplication();
        if(application != null)
            return application.getDeviceId();
        return null;
    }

    public void sendPendingBroadcast(int requestCode, Intent intent, int flag){
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), requestCode, intent, flag);
        try {
            pendingIntent.send();
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }
}
