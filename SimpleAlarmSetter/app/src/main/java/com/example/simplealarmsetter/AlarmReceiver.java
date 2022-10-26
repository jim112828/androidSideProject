package com.example.simplealarmsetter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class AlarmReceiver extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.Q)

    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(4000);
        Toast.makeText(context,"Alarm! Wake up! Wake up!", Toast.LENGTH_LONG).show();
        Uri alarmUrl = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUrl == null) {
            alarmUrl = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        Ringtone ringtone = RingtoneManager.getRingtone(context,alarmUrl);

        ringtone.play();

    }
}
