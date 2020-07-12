package com.servlet;

import com.model.*;
import java.io.IOException;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.util.JdbcUtil;

@WebServlet("/user")
public class UserServlet  extends BaseServlet{

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		
//		String action = request.getParameter("action");
//		
//		if(action.equals("login")) {
//			login(request,response);
//		}else if(action.equals("pass")) {
//			pass(request,response);
//		}else if(action.equals("exit")) {
//			exit(request,response);
//		}
//		
//	}
	protected void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	protected void pass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		HttpSession session = request.getSession();
		User userId = (User)session.getAttribute("userId");
		String sql = "select * from user where id=?";
		try {
			JdbcUtil jdbc = new JdbcUtil();
			List<User> user = jdbc.queryPreparedStatement(sql, User.class, userId);
			User password = user.get(0);
			System.out.println(password.getPassword() + "");
			if(password.getPassword().equals(oldPass)) {
				String sql1 = "update user set password =? where id=?";
				jdbc.updatePreparedStatement(sql1, newPass,userId);
				request.setAttribute("mess", "修改密码成功,请重新登录!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				request.setAttribute("error", "您输入的旧密码不正确!");
				request.getRequestDispatcher("editPassword.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userId");
		String password = request.getParameter("password");
		JdbcUtil jdbc = new JdbcUtil();
		String sql="select * from user where id=? and password=?";
		List<User> users = jdbc.queryPreparedStatement(sql, User.class,id,password);
		if(users.size()>0){
			//查询student表中的数据
			sql = "select * from student";
			List<Student> stus = jdbc.queryPreparedStatement(sql, Student.class);
			request.setAttribute("stus", stus);
			
			 HttpSession session = request.getSession();
			 session.setAttribute("userId", id);
			 request.getRequestDispatcher("student.jsp").forward(request, response);
		}else{
			request.setAttribute("mess", "用户名或密码不正确");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
		

//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		this.doPost(request, response);
//	}
//	
}
