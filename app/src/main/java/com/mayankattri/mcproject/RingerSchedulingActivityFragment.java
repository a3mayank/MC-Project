package com.mayankattri.mcproject;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

/**
 * A placeholder fragment containing a simple view.
 */
public class RingerSchedulingActivityFragment extends Fragment {

    RingerReceiver alarm2 = new RingerReceiver();
    TimePicker time2;
    public static String year2, month2, day2, hour2, minute2;

    public RingerSchedulingActivityFragment() {
    }

    public static String getHour() {
        return hour2;
    }
    public static String getMinute() {
        return minute2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ringer_scheduling, container, false);

        time2 = (TimePicker) rootView.findViewById(R.id.timePicker2);
        Button done2 = (Button) rootView.findViewById(R.id.B_done2);

        time2.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minuteOfHour) {
                hour2 = String.valueOf(hourOfDay);
                minute2 = String.valueOf(minuteOfHour);
            }
        });

        done2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarm2.setAlarm(getContext());
            }
        });

        return rootView;
    }
}
