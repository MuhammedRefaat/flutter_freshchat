package com.freshchat.flutter_freshchat_example;

import android.os.Bundle;

import io.flutter.app.FlutterActivity;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this);

        // registering for receiving new chat messages
        NewMessagesBCReceiver messagesBCReceiver = new NewMessagesBCReceiver();
        IntentFilter intentFilter = new IntentFilter(Freshchat.FRESHCHAT_UNREAD_MESSAGE_COUNT_CHANGED);
        getLocalBroadcastManager(getApplicationContext()).registerReceiver(messagesBCReceiver, intentFilter);
    }
}
