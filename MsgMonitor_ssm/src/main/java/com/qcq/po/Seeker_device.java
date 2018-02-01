package com.qcq.po;

public class Seeker_device {
	int seeker_id;
	String device_mac;
	public int getSeeker_id() {
		return seeker_id;
	}
	public void setSeeker_id(int seeker_id) {
		this.seeker_id = seeker_id;
	}
	public String getDevice_mac() {
		return device_mac;
	}
	public void setDevice_mac(String device_mac) {
		this.device_mac = device_mac;
	}
	public Seeker_device(int seeker_id, String device_mac) {
		super();
		this.seeker_id = seeker_id;
		this.device_mac = device_mac;
	}
	public Seeker_device(){
		
	}
	@Override
	public String toString() {
		return "Seeker_device [seeker_id=" + seeker_id + ", device_mac=" + device_mac + "]";
	}
}
