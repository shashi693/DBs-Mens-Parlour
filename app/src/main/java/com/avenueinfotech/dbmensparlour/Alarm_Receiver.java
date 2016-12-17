package com.avenueinfotech.dbmensparlour;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by suken on 22-11-2016.
 */

public class Alarm_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("We are in the receiver.", "Yay!");

        //fetch extra strings from the intent
        String get_your_string = intent.getExtras().getString("extra");

        Log.e("what is the key? ", get_your_string);

        //create an intent to the ringtone serbvice
        Intent service_intent = new Intent(context, RingtonePlayingService.class);

        //pass th eextra string from Main Activity to the rib=ngtone paling service
        service_intent.putExtra("extra", get_your_string);

        //start the service
        context.startService(service_intent);

    }
}
