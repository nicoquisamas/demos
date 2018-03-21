package pmi.com.demos;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by nquisama on 3/21/2018.
 */

public class FcmMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {


            String title = remoteMessage.getData().get("title");
            String body = remoteMessage.getData().get("body");

            Log.d("TEST", title + " - " + body);


    }
}
