package com.entity;

import java.io.Serializable;

public class Admin implements Serializable{
	
	/**
	 * �������Ա
	 */
	
	private int aid;//id
	private String azh;//�˺�
	private String apwd;//����
	private String aname;//����
	
	private String asex;//�Ա�
	private String atel;//�绰����
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAzh() {
		return azh;
	}
	public void setAzh(String azh) {
		this.azh = azh;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAsex() {
		return asex;
	}
	public void setAsex(String asex) {
		this.asex = asex;
	}
	public String getAtel() {
		return atel;
	}
	public void setAtel(String atel) {
		this.atel = atel;
	}
	public Admin(int aid, String azh, String apwd, String aname, String asex, String atel) {
		this.aid = aid;
		this.azh = azh;
		this.apwd = apwd;
		this.aname = aname;
		this.asex = asex;
		this.atel = atel;
	}
	public Admin() {}
	

}
