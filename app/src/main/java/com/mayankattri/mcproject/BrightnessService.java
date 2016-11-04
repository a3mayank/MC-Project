package com.mayankattri.mcproject;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Intent;
import android.media.AudioManager;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by mayank on 22/10/16.
 */
public class BrightnessService extends IntentService {

    public BrightnessService() {
        super("BrightnessService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        System.out.println("in BrightessService");

        //Get the content resolver
        ContentResolver cResolver = getContentResolver();

        //Get the current window
        Window window = BrightnessSchedulingActivityFragment.window;

        try {
            //sets manual mode and brightnes 255
            Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);  //this will set the manual mode (set the automatic mode off)
            Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, 1);  //this will set the brightness to maximum (255)

            //refreshes the screen
            int br = Settings.System.getInt(cResolver, Settings.System.SCREEN_BRIGHTNESS);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.screenBrightness = (float) br / 1;
            window.setAttributes(lp);

        } catch (Exception e) {}
    }
}
