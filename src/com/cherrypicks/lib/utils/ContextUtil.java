package com.cherrypicks.lib.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;

/**
 * ContextUtil, do some work which must under context environment.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class ContextUtil {

	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager
				.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}

	public DeviceInfo getPhoneParams(Context context) {

		DeviceInfo info = new DeviceInfo();

		TelephonyManager telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		info.setIMEI(telephonyManager.getDeviceId());
		info.setIMSI(telephonyManager.getSubscriberId());

		info.setEmulator(info.getIMEI().equals("000000000000000"));
		info.setPhoneNum(telephonyManager.getLine1Number());
		info.setSdkVersion(Build.VERSION.SDK_INT);
		info.setDeviceModel(Build.MODEL);

		telephonyManager = null;
		System.gc();

		return info;
	}

}
