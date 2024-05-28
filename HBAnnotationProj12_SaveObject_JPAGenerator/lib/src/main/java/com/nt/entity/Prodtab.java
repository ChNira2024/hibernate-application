package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.TableGenerator;
@Entity
public class Prodtab implements Serializable {
	
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	
	/*	@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
	*/
	
	/*@Id
	@SequenceGenerator(name ="gen1",
	                                              sequenceName = "JPA_PID_SEQ",
	                                              initialValue = 1000,
	                                              allocationSize =10 )
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)*///Custom sequence...O/P:1000,1011,1021,1031 but why 1011 not 1010 don't know..//default allocationSize is 50
	
	
	/*@Id
	@SequenceGenerator(name ="gen1",
	                                              sequenceName = "JPA_PID_SEQ1") //Custom sequence...O/P:1,52,102,152,202 but why 52 not 51 don't know...//default allocationSize is 50
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	*/
	
	/*@Id
	@SequenceGenerator(name ="gen1",
	                                              sequenceName = "PID_SEQ",
	                                              initialValue = 500,
	                                              allocationSize = 5) 
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)*/
	
	/*@Id
	@TableGenerator(name = "gen1",
	                                    pkColumnName = "ID_COL",
	                                    valueColumnName = "ID_VAL",
	                                    pkColumnValue = "PID",
	                                    table = "ID_TAB",
	                                    initialValue = 10,
	                                    allocationSize = 5 )
	@GeneratedValue(generator ="gen1", strategy = GenerationType.TABLE)*/
	
	/*@Id
	@GeneratedValue( strategy = GenerationType.TABLE)*/
	
	/*	# for oralce
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO) */
	/*  @Id
	  @SequenceGenerator(name = "gen1",
	                                                sequenceName = "PROD_PID_SEQ",
	                                                initialValue = 5,
	                                                allocationSize = 10 )
	  @GeneratedValue(generator = "gen1",strategy = GenerationType.AUTO) */
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