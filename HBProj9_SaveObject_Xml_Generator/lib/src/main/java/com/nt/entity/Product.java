//Entity class/ Domain class/model class/Persistent class/POJO class/HLO(hibernate language object) class
package com.nt.entity;

import java.io.Serializable;

public class Product implements Serializable {
	 //bean properties
	private Integer pid;
	private String pname;
	private String pcode;
	private Float pcost;
	private Float pqty;
	//setters and getters
	 //alt+shift+s ,r
	
	public Integer getPid() {
		return pid;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Float getPcost() {
		return pcost;
	}
	public void setPcost(Float pcost) {
		this.pcost = pcost;
	}
	public Float getPqty() {
		return pqty;
	}
	public void setPqty(Float pqty) {
		this.pqty = pqty;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pcode=" + pcode + ", pcost=" + pcost + ", pqty=" + pqty
				+ "]";
	}
	
	
}