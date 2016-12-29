package kr.co.hs.firebase.fcm;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;

import kr.co.hs.firebase.app.HsFirebaseApplication;
import kr.co.hs.firebase.fcm.item.HsFirebaseMessagingInfo;
import kr.co.hs.net.HsRestClient;

/**
 * Created by Bae on 2016-12-25.
 */

public class HsFirebaseMessagingUtils {
    private static HsFirebaseMessagingUtils instance = null;
    public static HsFirebaseMessagingUtils getInstance(){
        if(instance == null)
            instance = new HsFirebaseMessagingUtils();
        return instance;
    }

    public HsFirebaseMessagingInfo getFirebaseMessagingInfo(
            HsFirebaseApplication application,
            String serverKey
    ){
        HsRestClient client = new HsRestClient();
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "key="+serverKey);
        String response = client.get(String.format(HsFirebaseMessagingInfo.HOST_IID, application.getFirebaseToken()), header, 10000);
        try {
            return new HsFirebaseMessagingInfo(response);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void subscribe(String topic){
        FirebaseMessaging.getInstance().subscribeToTopic(topic);
    }
    public void unsubscribe(String topic){
        FirebaseMessaging.getInstance().unsubscribeFromTopic(topic);
    }
    public void send(RemoteMessage remoteMessage){
        FirebaseMessaging.getInstance().send(remoteMessage);
    }
}
