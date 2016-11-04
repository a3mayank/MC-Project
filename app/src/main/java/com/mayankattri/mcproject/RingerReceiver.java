package com.mayankattri.mcproject;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

import java.util.Calendar;

/**
 * Created by mayank on 22/10/16.
 */
public class RingerReceiver extends WakefulBroadcastReceiver {
    // The app's AlarmManager, which provides access to the system alarm services.
    private AlarmManager alarmMgr1;
    // The pending intent that is triggered when the alarm fires.
    private PendingIntent alarmIntent1;

    @Override
    public void onReceive(Context context, Intent intent) {
        // BEGIN_INCLUDE(alarm_onreceive)
        /*
         * If your receiver intent includes extras that need to be passed along to the
         * service, use setComponent() to indicate that the service should handle the
         * receiver's intent. For example:
         *
         * ComponentName comp = new ComponentName(context.getPackageName(),
         *      MyService.class.getName());
         *
         * // This intent passed in this call will include the wake lock extra as well as
         * // the receiver intent contents.
         * startWakefulService(context, (intent.setComponent(comp)));
         *
         * In this example, we simply create a new intent to deliver to the service.
         * This intent holds an extra identifying the wake lock.
         */
        Intent service = new Intent(context, RingerService.class);

        // Start the service, keeping the device awake while it is launching.
        startWakefulService(context, service);
        // END_INCLUDE(alarm_onreceive)
    }

    public void setAlarm(Context context) {
        alarmMgr1 = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, RingerReceiver.class);
        alarmIntent1 = PendingIntent.getBroadcast(context, 0, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        int hour = Integer.parseInt(RingerSchedulingActivityFragment.getHour());
        int minute = Integer.parseInt(RingerSchedulingActivityFragment.getMinute());

        // Set the alarm's trigger time to 8:30 a.m.
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);

        alarmMgr1.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent1);
    }
}
