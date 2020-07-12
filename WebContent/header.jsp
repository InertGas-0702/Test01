<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.model.*"%>

			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid"> 
			    <div class="navbar-header">
			        <a class="navbar-brand" href="student?action=query">学生信息管理系统</a>
			    </div>
			    <div>
			        <form class="navbar-form navbar-left" role="search" action="student">
			        	<input type="hidden" name="action" value="search">
			            <input type="text" class="form-control" name="sid" placeholder="请输入学号查询">
			            <button type="submit" class="btn btn-default">搜索</button>
			        </form>
			        <!--向右对齐-->
			        <ul class="nav navbar-nav navbar-right">
			            <li class="dropdown">
			                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
			                    	<font color="blue"><%=session.getAttribute("userId") %></font> <b class="caret"></b>
			                </a>
			                <ul class="dropdown-menu">
			                    <li><a href="editPassword.jsp">密码修改</a></li>
			                    <li class="divider"></li>
			                    <li><a href="user?action=exit">安全退出</a></li>
			                    <li class="divider"></li>
			                </ul>
			            </li>
			        </ul>
			        
			    </div>
				</div>
			</nav>