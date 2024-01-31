package com.pomodoro.application.broadcastReceiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.pomodoro.application.R;

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    String AlarmMsg = " is 1 day before deadline!";

    public static final String EXTRA_MESSAGE = "message";
    private static final int idOne = 100;
    private static final String CHANNEL_ID = "channel_notif_alarm";
    private static final CharSequence CHANNEL_NAME = "Alarm Channel";
    String title, desc, date, time;
    @Override
    public void onReceive(Context context, Intent intent) {


        title = intent.getStringExtra("TITLE");
        desc = intent.getStringExtra("DESC");
        date = intent.getStringExtra("DATE");
        time = intent.getStringExtra("TIME");

        String message = intent.getStringExtra(EXTRA_MESSAGE);
        showNotification(context, title+AlarmMsg, message, idOne);
    }

    private void showNotification(Context context, String title, String message, int notifId){
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.sslogo)
                .setContentTitle(title)
                .setContentText(message)
                .setColor(ContextCompat.getColor(context, android.R.color.transparent))
                .setSound(alarmSound);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[] {1000,1000,1000,1000,1000});
            mBuilder.setChannelId(CHANNEL_ID);
        }

        Notification notification = mBuilder.build();

        if(notificationManager != null){
            notificationManager.notify(notifId, notification);
        }

    }
}
