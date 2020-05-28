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
	 * ��½
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��get����Ϊpost����������post���еı��ύ���Ա��ȡ��Ӧ��ֵ
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ñ��뷽ʽ�����ģ�����������
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//ʵ����out���Ա㴫ֵ������
		PrintWriter out = resp.getWriter();
		//���session   ��ֵ���Ա�ǰ��ȡ��
		HttpSession session=req.getSession();
		//���ݱ��������õ��ֶ�������ֵ
		String azh = req.getParameter("azh");//����Ա�˺�
		String apwd = req.getParameter("apwd");//����Ա����
		//ʵ����dao����
		AdminDao ad = new AdminDao();
		//����dao��������ѯ����Ӧ��ѧ����Ϣ
		int f = ad.check(azh, apwd);
		if (f!=0) {
			session.setAttribute("aid", f);
			out.print("<script>alert('��½�ɹ���');location.href='zhuye.jsp'</script>");
		} else {
			out.print("<script>alert('��½ʧ�ܣ�');location.href='login.jsp'</script>");
		}
	}
}
