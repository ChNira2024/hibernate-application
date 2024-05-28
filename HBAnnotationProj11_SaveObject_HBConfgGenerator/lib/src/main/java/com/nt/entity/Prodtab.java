package com.nt.entity;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Prodtab implements Serializable {
	@Id
	//@GenericGenerator(name = "gen1",strategy = "increment")
	//@GenericGenerator(name = "gen1",strategy = "identity")
	//@GenericGenerator(name = "gen1",strategy = "sequence")
	@GenericGenerator(name = "gen1",strategy = "sequence",parameters =@Parameter(name="sequence_name",value = "PID_SEQ")) //custom sequence
	@GeneratedValue(generator = "gen1")
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
		return "Prodtab [pid=" + pid + ", pname=" + pname + ", pcode=" + pcode + ", pcost=" + pcost + ", pqty=" + pqty
				+ "]";
	}
	
	
}