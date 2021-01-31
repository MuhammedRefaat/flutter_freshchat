import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NewMessagesBCReceiver extends BroadcastReceiver implements MethodCallHandler {

    @Override
    public void onReceive(Context context, Intent intent) {
        // send a message to the flutter side with the new messages count
        Freshchat.getInstance(this.application.getApplicationContext()).getUnreadCountAsync(new UnreadCountCallback() {
            @Override
            public void onResult(FreshchatCallbackStatus freshchatCallbackStatus, int i) {
                System.out.println("UnreadMessageCount - From BC : " + Integer.toString(i));
                try {
                    invokeMethodOnUiThread("FreshChat#NewMessageReceived", i);
                } catch (JSONException e) {
                    e.getStackTrace();
                }
            }
        });
    }
}