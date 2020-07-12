package com.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.*;

public class BaseServlet extends HttpServlet {

	   @Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try {
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				String action = request.getParameter("action");
				
				//防盗链
				String user = (String)request.getSession().getAttribute("userId");
				if(user==null && !action.equals("login")){
					response.sendRedirect("login.jsp");
					return ;
				}
				
				
				Class clazz = this.getClass();
				Method method = clazz.getDeclaredMethod(action, HttpServletRequest.class,HttpServletResponse.class);
				method.invoke(this, request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	


}
