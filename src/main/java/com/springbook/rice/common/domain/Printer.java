package com.springbook.rice.common.domain;

public class Printer {
	private int appid;// 开发者应用id
	private String deviceid;// 设备号
	private String devicesecret;// 设备密匙
	private String appsecret;// 开发密匙
	private int timestamp;
	private String Data;// 数据
	/** The encoding used to represent characters as bytes. */
	
	public int getAppid() {
		return appid;
	}

	public void setAppid(int appid) {
		this.appid = appid;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getDevicesecret() {
		return devicesecret;
	}

	public void setDevicesecret(String devicesecret) {
		this.devicesecret = devicesecret;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

}
