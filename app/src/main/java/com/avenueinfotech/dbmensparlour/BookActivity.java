package com.avenueinfotech.dbmensparlour;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookActivity extends AppCompatActivity {

    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    DatePicker alarm_datepicker;
    TextView update_text;
    Context context;
    PendingIntent pending_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        this.context = this;

        //initialize our alarm manager
        alarm_manager = (AlarmManager)getSystemService(ALARM_SERVICE);

        //initialize our tim epicker
        alarm_timepicker = (TimePicker)findViewById(R.id.timePicker);
        alarm_datepicker = (DatePicker)findViewById(R.id.datePicker);

        //initialize our text update box
        update_text = (TextView) findViewById(R.id.update_text);

        //create an instance of a calender
        final Calendar calendar = Calendar.getInstance();

        //initialize buttons
        Button alarm_on = (Button) findViewById(R.id.alarm_on);
        //create on click listner for start ot alarm
//        Button set = (Button)findViewById(R.id.set);

        //crate an intent to tha alarm recevier class
        final Intent my_intent = new Intent(this.context, Alarm_Receiver.class);



//        int hour = 0;
//        int min = 0;



        alarm_on.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                //setting calender instance with the hor & min
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker.getCurrentMinute());
                calendar.set(Calendar.YEAR, alarm_datepicker.getYear());
                calendar.set(Calendar.MONTH, alarm_datepicker.getMonth());
                calendar.set(Calendar.DAY_OF_MONTH, alarm_datepicker.getDayOfMonth());

                int hour = 0;
                int minute = 0;
                int year;
                int month;
                int date;
                // get the string value of the hour and mi9nute
                hour = alarm_timepicker.getCurrentHour();
                minute = alarm_timepicker.getCurrentMinute();
                year = alarm_datepicker.getYear();
                month = alarm_datepicker.getMonth();
                date = alarm_datepicker.getDayOfMonth();




//               int currentApiVersion = android.os.Build.VERSION.SDK_INT;
//               if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
//                   hour = alarm_timepicker.getHour();
//                   minute = alarm_timepicker.getMinute();
//               } else {
//                   hour = alarm_timepicker.getCurrentHour();
//                   minute = alarm_timepicker.getCurrentMinute();
//               }

                //convet the int value tyo string
                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);
                String year_string = String.valueOf(year);
                String month_string = String.valueOf(month);
                String date_string = String.valueOf(date);

                //convert 24-hour time to 12-hour time
                if(hour > 12){
                    hour_string = String.valueOf(hour - 0);
                }

                if(minute < 10){
                    minute_string = "0" + String.valueOf(minute);
                }

                if(month > 0){
                    month_string = String.valueOf(month + 1);
                }



                //method that change the update to string
                set_alarm_text("Alarm set to: " + hour_string + ":" + minute_string + ":" + date_string + ":"  + month_string + ":"  + year_string  );

                //method that changes her update text templete
//                set_alarm_text("Alarm On");

                //pt in extyra string into my_intent
                //telss alarm service taht you pressed th ealarm om bi=utton
                my_intent.putExtra("extra", "alarm on");

                //create a pending intent taht delays the intent
                //until the specified calender time
                pending_intent = PendingIntent.getBroadcast(BookActivity.this, 0,
                        my_intent, PendingIntent.FLAG_UPDATE_CURRENT);

                //set the alarm manager
                alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_intent);
            }




        });

        Button alarm_off = (Button)findViewById(R.id.alarm_off);
        //create on click listner for stop ot alarm
        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //method to updateretext off
                set_alarm_text("Alarm Off");

                //cancel the alarm
                alarm_manager.cancel(pending_intent);

                //pu the extra service int muintent
                //the clock taht you preassed the "a;ert off" button
                my_intent.putExtra("extra", "alarm off");

                //stop the ringtone
                sendBroadcast(my_intent);
            }
        });







    }




    private void set_alarm_text(String output) {
        update_text.setText(output);
    }


//    SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
//    String display = preferences.getString("display", "");

//    TextView dispalyInfo = (TextView) findViewById(R.id.displayName);
//    dispalyInfo.setText(display);




}
