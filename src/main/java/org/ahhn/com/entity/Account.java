package org.ahhn.com.entity;

/**
 * Created by XJX on 2016/3/13.
 */
public class Account {
	private Integer id;
	private String usename;
	private int balance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsename() {
		return usename;
	}

	public void setUsename(String usename) {
		this.usename = usename;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
