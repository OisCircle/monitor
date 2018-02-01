package com.qcq.po;

public class Seeker {
	int id;
	int type;
	public Seeker(){
		
	}
	public Seeker(int id, int type) {
		super();
		this.id = id;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Seeker [id=" + id + ", type=" + type + "]";
	}
}
