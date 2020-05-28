package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.entity.Admin;

public class AddServlet extends HttpServlet {

	/**
	 * 注册
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		String azh = req.getParameter("azh");
		String apwd = req.getParameter("apwd");
		String aname = req.getParameter("aname");
		String asex = req.getParameter("asex");
		String atel = req.getParameter("atel");
		AdminDao dao = new AdminDao();
		Admin admin = new Admin();
		admin.setAzh(azh);
		admin.setApwd(apwd);
		admin.setAname(aname);
		admin.setAsex(asex);
		admin.setAtel(atel);
		int n = dao.add(admin);
		if (n > 0) {
			out.print("<script>alert('注册成功！');location.href='login.jsp'</script>");// 跳到登录界面
		} else {
			out.print("<script>alert('注册失败！');location.href='zhuce.jsp'</script>");
		}

	}

}
