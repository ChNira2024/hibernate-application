package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PERSON_INFO2")
public class PersonInfoHavingLocalDateTime implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	@Column(length=20)
	//@Type(type="string")
	private String pname;
	@Column(length=20)
	//@Type(type="string")
	private String paddrs;
	
	private  LocalDateTime  dob;
	private LocalDate  dom;
	private LocalTime doj;
	
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
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	public LocalDate getDom() {
		return dom;
	}
	public void setDom(LocalDate dom) {
		this.dom = dom;
	}
	public LocalTime getDoj() {
		return doj;
	}
	public void setDoj(LocalTime doj) {
		this.doj = doj;
	}
	
	@Override
	public String toString() {
		return "PersonInfoHavingLocalDateTime [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", dob=" + dob + ", dom=" + dom
				+ ", doj=" + doj + "]";
	}
	
	
	
	

}