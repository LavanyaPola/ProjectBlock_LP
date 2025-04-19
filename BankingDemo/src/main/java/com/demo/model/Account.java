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
	private String accadd;
	private long accph;
	
	public Account() {
		super();
		
	}

	public Account(int accno, String accname, double accbal, String accadd, long accph) {
		super();
		this.accno = accno;
		this.accname = accname;
		this.accbal = accbal;
		this.accadd = accadd;
		this.accph = accph;
	}

	public String getAccadd() {
		return accadd;
	}

	public void setAccadd(String accadd) {
		this.accadd = accadd;
	}

	public long getAccph() {
		return accph;
	}

	public void setAccph(long accph) {
		this.accph = accph;
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
