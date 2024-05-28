package com.nt.entity;

public class Product {

	private int pid;
	private String pcode;
	private float pcost;
	private float pqty;
	private String pname;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public float getPcost() {
		return pcost;
	}
	public void setPcost(float pcost) {
		this.pcost = pcost;
	}
	public float getPqty() {
		return pqty;
	}
	public void setPqty(float pqty) {
		this.pqty = pqty;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pcode=" + pcode + ", pcost=" + pcost + ", pqty=" + pqty + ", pname=" + pname
				+ "]";
	}
	
	
}
