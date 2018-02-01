package com.qcq.po;

import java.util.Date;

public class Signal {
	int id;
	String mac;
	int rssi;
	Date time;
	public Signal(){
		
	}
	public Signal(int id, String mac, int rssi, Date time) {
		super();
		this.id = id;
		this.mac = mac;
		this.rssi = rssi;
		this.time = time;
	}
	@Override
	public String toString() {
		return "Signal [id=" + id + ", mac=" + mac + ", rssi=" + rssi + ", time=" + time + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public int getRssi() {
		return rssi;
	}
	public void setRssi(int rssi) {
		this.rssi = rssi;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
