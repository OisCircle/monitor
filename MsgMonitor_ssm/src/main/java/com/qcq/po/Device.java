package com.qcq.po;

public class Device {
	String mac;
	public Device(){
		
	}
	public Device(String mac) {
		super();
		this.mac = mac;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
	@Override
	public String toString() {
		return "Device [mac=" + mac + "]";
	}
	
}
