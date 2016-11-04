package com.mayankattri.mcproject;

import android.content.ContentResolver;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

/**
 * A placeholder fragment containing a simple view.
 */
public class BrightnessSchedulingActivityFragment extends Fragment {

    BrightnessReceiver alarm3 = new BrightnessReceiver();
    public static Window window;

    public BrightnessSchedulingActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_brightness_scheduling, container, false);

        ToggleButton tb = (ToggleButton) rootView.findViewById(R.id.toggleButton);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setOn();
                } else {
                    setOff();
                }
            }
        });

        return rootView;
    }

    public void setOn() {
        //Get the content resolver
        ContentResolver cResolver = getActivity().getContentResolver();

        //Get the current window
        window = getActivity().getWindow();

        alarm3.setAlarm(getContext());

//        try {
//            //sets manual mode and brightnes 255
//            Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);  //this will set the manual mode (set the automatic mode off)
//            Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, 1);  //this will set the brightness to maximum (255)
//
//            //refreshes the screen
//            int br = Settings.System.getInt(cResolver, Settings.System.SCREEN_BRIGHTNESS);
//            WindowManager.LayoutParams lp = window.getAttributes();
//            lp.screenBrightness = (float) br / 1;
//            window.setAttributes(lp);
//
//        } catch (Exception e) {}
    }

    public void setOff() {
        //Get the content resolver
        ContentResolver cResolver = getActivity().getContentResolver();

        //Get the current window
//        window = getActivity().getWindow();
//
//        try {
//            //sets manual mode and brightnes 255
//            Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);  //this will set the manual mode (set the automatic mode off)
//            Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, 255);  //this will set the brightness to maximum (255)
//
//            //refreshes the screen
//            int br = Settings.System.getInt(cResolver, Settings.System.SCREEN_BRIGHTNESS);
//            WindowManager.LayoutParams lp = window.getAttributes();
//            lp.screenBrightness = (float) br / 255;
//            window.setAttributes(lp);
//
//        } catch (Exception e) {}
    }
}
