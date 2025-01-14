package com.nt.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PhoneNumber implements Serializable {
	private int regNo;
	@NonNull
	private long phone;
	@NonNull
	private String type;
	@NonNull
	private  String provider;
	
	public PhoneNumber() {
		System.out.println("PhoneNumber:: 0-param constrcutor"+this.getClass());
	}

}
