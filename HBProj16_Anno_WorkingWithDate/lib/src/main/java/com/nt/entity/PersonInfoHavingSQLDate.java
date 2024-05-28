package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="PERSON_INFO1")
public class PersonInfoHavingSQLDate implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	@Column(length=20)
	//@Type(type="string")
	private String pname;
	@Column(length=20)
	//@Type(type="string")
	private String paddrs;
	
	@Temporal(TemporalType.TIMESTAMP)   //default is also TIMESTAMP
	private  Date  dob;
	@Temporal(TemporalType.DATE)
	private Date  dom;
	@Temporal(TemporalType.TIME)
	private Date doj;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPaddrs() {
		return paddrs;
	}
	public void setPaddrs(String paddrs) {
		this.paddrs = paddrs;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDom() {
		return dom;
	}
	public void setDom(Date dom) {
		this.dom = dom;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	@Override
	public String toString() {
		return "PersonInfoHavingSQLDate [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", dob=" + dob + ", dom=" + dom
				+ ", doj=" + doj + "]";
	}
	
	
	
	

}