package com.systop.entity;

import java.net.InetAddress;

public class Admin {
	private int id;
	private String admin;
	private String a_password;
	private int status;
	private InetAddress ip;
	public InetAddress getIp() {
		return ip;
	}
	public void setIp(InetAddress ip4) {
		this.ip = ip4;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id; 
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getA_password() {
		return a_password;
	}
	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	
}
