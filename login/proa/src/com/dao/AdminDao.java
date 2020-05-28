package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.Admin;
import com.util.DBhelper;

public class AdminDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	// Ôö¼Ó
	public int add(Admin admin) {
		int n = 0;
		try {
			con = DBhelper.getCon();
			ps = con.prepareStatement("insert into admin(azh,apwd,aname,asex,atel) values(?,?,?,?,?)");
			ps.setString(1, admin.getAzh());
			ps.setString(2, admin.getApwd());
			ps.setString(3, admin.getAname());
			ps.setString(4, admin.getAsex());
			ps.setString(5, admin.getAtel());
			n = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBhelper.myClose(con, ps, rs);
		}
		return n;
	}

	// µÇÂ½
	public int check(String name, String pwd) {
		int n=0;
		try {
			con = DBhelper.getCon();
			ps = con.prepareStatement("select * from admin where azh =? and apwd = ?");
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if (rs.next()) {
				n=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBhelper.myClose(con, ps, rs);
		}
		return n;
	}

	// ÐÞ¸Ä
	public int updatepwd(Admin admin) {
		int n = 0;
		try {
			con = DBhelper.getCon();
			ps = con.prepareStatement("update admin set apwd=? where aid=?");
			ps.setString(1, admin.getApwd());
			ps.setInt(2, admin.getAid());
			n = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBhelper.myClose(con, ps, rs);
		}
		return n;
	}

}
