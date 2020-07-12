package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Student;
import com.model.User;
import com.model.User.*;
import com.util.JdbcUtil;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student")
public class StudentServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		
//		String action = request.getParameter("action");
//		
//		//防盗链
//		String user = (String)request.getSession().getAttribute("userId");
//		if(user==null && !action.equals("login")){
//			response.sendRedirect("login.jsp");
//			return ;
//		}
//		
//		if(action.equals("add")) {
//			add(request,response);
//		}else if(action.equals("search")) {
//			search(request,response);
//		}else if(action.equals("delete")) {
//			delete(request,response);
//		}else if(action.equals("update")) {
//			update(request,response);
//		}else if(action.equals("toUpdate")) {
//			toUpdate(request,response);
//		}else if(action.equals("query")) {
//			query(request,response);
//		}else if(action.equals("addStudent")) {
//			request.getRequestDispatcher("addStudent.jsp").forward(request, response);
//		}
//		
//    }
//	protected void query(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		JdbcUtil jdbc = new JdbcUtil();
//		try {
//			// 查询数据库中学生列表
//			String sql1 = "select * from student";
//			List<Student> stus = jdbc.queryPreparedStatement(sql1, Student.class);
//			request.setAttribute("stus", stus);
//			request.getRequestDispatcher("student.jsp").forward(request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("mess", "查询学生失败，请检查录入学号是否重复！！");
//			request.getRequestDispatcher("error.jsp").forward(request, response);
//		}
//
//	}

	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String school = request.getParameter("school");
		String grade = request.getParameter("grade");
		String major = request.getParameter("major");
		String phone = request.getParameter("phone");
//		HttpSession session = request.getSession();

		JdbcUtil jdbc = new JdbcUtil();
		String sql = "insert into student(sid, sname, age, sex, phone, school, grade, major) values (?, ?, ?, ?, ?, ?, ?, ?)";

		Object[] param = new Object[] { sid, sname, Integer.parseInt(age), sex, phone, school, grade, major };

		try {
			jdbc.updatePreparedStatement(sql, param);
			// 查询数据库中学生列表
			request.getRequestDispatcher("/student?action=query").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "新增学生失败，请检查录入学号是否重复！！");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}

	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("sid");
		JdbcUtil jdbc = new JdbcUtil();
		if (sid != null && !sid.equals("")) {
			try {
				// 查询数据库中学生列表
				String sql1 = "select * from student where sid =?";
				List<Student> stus = jdbc.queryPreparedStatement(sql1, Student.class, sid);
				request.setAttribute("stus", stus);
				request.getRequestDispatcher("student.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("mess", "学生查找失败！！");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} else {
			try {
				// 查询数据库中学生列表
				request.getRequestDispatcher("/student?action=query").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("mess", "学生查找失败！！");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("sid");
		JdbcUtil jdbc = new JdbcUtil();
		try {
			// 删除
			String sql = "delete from student where sid=?";
			jdbc.updatePreparedStatement(sql, sid);
			// 查询数据库中学生列表
			request.getRequestDispatcher("/student?action=query").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("sid");
		JdbcUtil jdbc = new JdbcUtil();
		String sql = "select * from student where sid =?";
		try {
			List<Student> stus = jdbc.queryPreparedStatement(sql, Student.class, sid);
			request.setAttribute("stus", stus.get(0));
			request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void toUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String school = request.getParameter("school");
		String grade = request.getParameter("grade");
		String major = request.getParameter("major");
		String phone = request.getParameter("phone");

		JdbcUtil jdbc = new JdbcUtil();
		String sql = "update student set sname=?,sex=?,age=?,school=?,grade=?,phone=?,major=? where sid=?";
		try {
			// 更新
			jdbc.updatePreparedStatement(sql, sname, sex, age, school, grade, phone, major, sid);
			// 查询数据库中学生列表
			request.getRequestDispatcher("/student?action=query").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("addStudent.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
