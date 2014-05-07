package com.cherrypicks.lib.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.cherrypicks.lib.R;

public class NotifyUtil {

	public static void sendNotification(Context context, PendingIntent intent) {
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				context).setSmallIcon(R.drawable.ic_launcher)
				.setContentTitle("My notification")
				.setContentText("Hello World!");

		mBuilder.setContentIntent(intent);
		NotificationManager mNotificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		// mId allows you to update the notification later on.
		mNotificationManager.notify(1, mBuilder.build());
	}


	public static void toast(Context context, Bundle bundle) {

		String message = bundle.getString("message");
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();

	}
}
