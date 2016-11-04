package com.mayankattri.mcproject;

import android.annotation.TargetApi;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

/**
 * A placeholder fragment containing a simple view.
 */
public class SmsSchedulingAcivityFragment extends Fragment {

    AlarmReceiver alarm = new AlarmReceiver();
    DatePicker date;
    TimePicker time;
    EditText text, contact;
    public static String year, month, day, hour, minute;
    public static String contactNo, smsText;

    public SmsSchedulingAcivityFragment() {
    }

    public static String getContact() {
        return contactNo;
    }
    public static String getText() {
        return smsText;
    }
    public static String getHour() {
        return hour;
    }
    public static String getMinute() {
        return minute;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sms_scheduling_acivity, container, false);

        contact = (EditText) rootView.findViewById(R.id.ET_contact);
        text = (EditText) rootView.findViewById(R.id.ET_smsText);
//        date = (DatePicker) rootView.findViewById(R.id.datePicker);
        time = (TimePicker) rootView.findViewById(R.id.timePicker);
        Button done = (Button) rootView.findViewById(R.id.B_done);

        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minuteOfHour) {
                hour = String.valueOf(hourOfDay);
                minute = String.valueOf(minuteOfHour);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set();
            }
        });

        return rootView;
    }

    public void set() {
//                year = Integer.toString(date.getYear());
//                month = Integer.toString(date.getMonth());
//                day = Integer.toString(date.getDayOfMonth());
//        this.hour = Integer.toString(time.getHour());
//        this.minute = Integer.toString(time.getMinute());

        this.smsText = text.getText().toString();
        this.contactNo = contact.getText().toString();
        Log.d("time : ", hour+":"+minute);
        Log.d("contact : ", contactNo);
        Log.d("text : ", smsText);
        alarm.setAlarm(getContext());
    }
}
