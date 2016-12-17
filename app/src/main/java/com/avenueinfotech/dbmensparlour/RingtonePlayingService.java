package com.avenueinfotech.dbmensparlour;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by suken on 22-11-2016.
 */
public class RingtonePlayingService extends Service {

    MediaPlayer media_song;
    int startId;
    boolean isRunning;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        //fetch the extra struing values
        String state = intent.getExtras().getString("extra");

        Log.e("Ringtone state:extrais ", state);



        assert state !=null;
        switch (state){
            case "alarm on":
                startId = 1;
                break;
            case "alarm off":
                startId = 0;
                Log.e("Start ID is ", state);
                break;
            default:
                startId = 0;
                break;
        }


        if(!this.isRunning && startId == 1){
            Log.e("there is no music, ", "an you want on");
            //create an instance of the media player
            media_song = MediaPlayer.create(this, R.raw.hai_apna);
            media_song.start();

            this.isRunning = true;
            this.startId = 0;

            NotificationManager notify_manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            Intent intent_main_activity = new Intent(this.getApplicationContext(), BookActivity.class);

            PendingIntent pending_intent_main_activity = PendingIntent.getActivity(this, 0, intent_main_activity, 0);

            Notification notification_popup = new Notification.Builder(this)
                    .setContentTitle("DB's Mens Parlour")
                    .setContentText("Today is your appointment, Call DB..")
                    .setContentIntent(pending_intent_main_activity)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.ic_icon)
                    .build();


            notify_manager.notify(0, notification_popup);


        }

        else if (this.isRunning && startId == 0){
//            Log.e("there is no music, ", "and you want end");

            media_song.stop();
            media_song.reset();

            this.isRunning = false;
            this.startId = 0;
        }

        else if (!this.isRunning && startId == 0){
//            Log.e("there is music, ", "and you want start");
            this.isRunning = false;
            this.startId = 0;
        }

        else if (this.isRunning && startId == 1){
//            Log.e("else", "somehow you reached this");

            this.isRunning = true;
            this.startId = 1;
        }

        else  {
//            Log.e("else", "somehow you reached this");
        }



        return START_NOT_STICKY;
    }

//    @Override
//    public void onDestroy() {
//        //tellth euser we aare stopped
////        Log.e("on Destroy called", "ta da");
//
//        super.onDestroy();
//        this.isRunning = false;
//    }
}
