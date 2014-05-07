package com.cherrypicks.lib.utils;

import android.util.DisplayMetrics;

/**
 * Keep current device's information.
 * 
 * @author jerryzhang
 * 
 */
public class DeviceInfo {

	private DisplayMetrics dm;

	private String IMEI;

	private String IMSI;

	private boolean isEmulator;

	private String deviceModel;

	private int sdkVersion;

	private String phoneNum;

	public DeviceInfo() {
		super();
		dm = new DisplayMetrics();
	}

	public DisplayMetrics getDm() {
		return dm;
	}

	public void setDm(DisplayMetrics dm) {
		this.dm = dm;
	}

	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}

	public String getIMSI() {
		return IMSI;
	}

	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}

	public boolean isEmulator() {
		return isEmulator;
	}

	public void setEmulator(boolean isEmulator) {
		this.isEmulator = isEmulator;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public int getSdkVersion() {
		return sdkVersion;
	}

	public void setSdkVersion(int sdkVersion) {
		this.sdkVersion = sdkVersion;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
