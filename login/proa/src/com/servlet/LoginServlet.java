package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.entity.Admin;

public class LoginServlet extends HttpServlet {

	/**
	 * 登陆
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 将get设置为post，界面是用post进行的表单提交，以便获取对应的值
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码方式（中文），避免乱码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//实例化out，以便传值给界面
		PrintWriter out = resp.getWriter();
		//获得session   存值，以便前端取用
		HttpSession session=req.getSession();
		//根据表单里面设置的字段名接受值
		String azh = req.getParameter("azh");//管理员账号
		String apwd = req.getParameter("apwd");//管理员密码
		//实例化dao方法
		AdminDao ad = new AdminDao();
		//调用dao方法，查询到对应的学生信息
		int f = ad.check(azh, apwd);
		if (f!=0) {
			session.setAttribute("aid", f);
			out.print("<script>alert('登陆成功！');location.href='zhuye.jsp'</script>");
		} else {
			out.print("<script>alert('登陆失败！');location.href='login.jsp'</script>");
		}
	}
}
