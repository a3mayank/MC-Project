package com.mayankattri.mcproject;

import android.app.IntentService;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;

import java.io.IOException;

/**
 * Created by mayank on 22/10/16.
 */
public class RingerService extends IntentService {

    public RingerService() {
        super("RingerService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        System.out.println("in RingerService");
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        RingerReceiver.completeWakefulIntent(intent);
    }
}
