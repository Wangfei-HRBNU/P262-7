package com.entity;

import java.io.Serializable;

public class Admin implements Serializable{
	
	/**
	 * 宿舍管理员
	 */
	
	private int aid;//id
	private String azh;//账号
	private String apwd;//密码
	private String aname;//名字
	
	private String asex;//性别
	private String atel;//电话号码
	
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
