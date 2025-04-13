package com.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account 
{

	@Id
	private int accno;
	private String accname;
	private double accbal;
	
	public Account() {
		super();
		
	}

	public Account(int accno, String accname, double accbal) {
		super();
		this.accno = accno;
		this.accname = accname;
		this.accbal = accbal;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	public double getAccbal() {
		return accbal;
	}

	public void setAccbal(double accbal) {
		this.accbal = accbal;
	}

}
