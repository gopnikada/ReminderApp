package com.example.lab63;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    public static final String CHANNEL_ID = "SMART-DECKS-NOTIFICATION-CHANNEL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNotify = (Button)findViewById(R.id.btnShow);


        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder mBuilder =  new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.ic_stat_ac_unit)
                        .setContentTitle("Tutlane Send New Message")
                        .setContentText("Hi, Welcome to tutlane tutorial site")
                        .setChannelId(CHANNEL_ID);
                // Set the intent to fire when the user taps on notification.
                Intent resultIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, resultIntent, 0);
                mBuilder.setContentIntent(pendingIntent);
                // Sets an ID for the notification
                int mNotificationId = 1;
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // It will display the notification in notification bar
                notificationManager.notify(mNotificationId, mBuilder.build());
            }
        });
    }
}