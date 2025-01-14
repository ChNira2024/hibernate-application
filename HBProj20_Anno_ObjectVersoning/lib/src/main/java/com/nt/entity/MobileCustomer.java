package com.nt.entity;

import java.io.Serializable;

import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class MobileCustomer  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer cno;
	@Column(length=20)
	//@Type(type="string")
	private String cname;
	//@Type(type="long")
	private long mobileNo;
	@Column(length=40)
	//@Type(type="string")
	private  String callerTune;
	//@Type(type="int")
	@Version
	private  Integer versionCount;
	
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCallerTune() {
		return callerTune;
	}
	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}
	public Integer getVersionCount() {
		return versionCount;
	}
	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}
	@Override
	public String toString() {
		return "MobileCustomer [cno=" + cno + ", cname=" + cname + ", mobileNo=" + mobileNo + ", callerTune=" + callerTune
				+ ", versionCount=" + versionCount + "]";
	}
	
	

}