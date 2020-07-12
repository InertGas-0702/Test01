<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ page import="com.model.Student" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<!-- 包含头部信息用于适应不同设备 -->
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-2.2.3.min.js" ></script>
		<script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js" ></script>
	</head>
	<body οnlοad="auto()">
	<div class="container">
		<%@ include file="header.jsp" %>
			<div class="row" >
				
				<div class="col-md-12" style="min-height: 500px;">
					<a href="student?action=addStudent" class="btn btn-info" style="margin-bottom: 10px;">新增学生信息</a>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>学号</th>
								<th>姓名</th>
								<th>年龄</th>
								<th>性别</th>
								<th>联系方式</th>
								<th>学校</th>
								<th>年级</th>
								<th>专业</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<%
								List stus = (List)request.getAttribute("stus");
								if(stus.size()>0){
									for(int i=0;i<stus.size();i++){
										Student stu = (Student)stus.get(i);
								
							%>
							<tr>
								<td><%=stu.getSid() %></td>
								<td><%=stu.getSname() %></td>
								<td><%=stu.getAge() %></td>
								<td><%=stu.getSex() %></td>
								<td><%=stu.getPhone() %></td>
								<td><%=stu.getSchool() %></td>
								<td><%=stu.getGrade() %></td>
								<td><%=stu.getMajor() %></td>
								<td>
									<a href="student?action=update&sid=<%=stu.getSid() %>" class="btn btn-info">修改</a>
									<a href="student?action=delete&sid=<%=stu.getSid() %>" class="btn btn-info">删除</a>
								</td>
							</tr>
							<%
									}
								}
							%>
							
							
						</tbody>
					</table>
				</div>
				
			</div>
			
			<ul class="pagination pages">
					<li><a href="#">&laquo;</a></li>
					<li class="active"><a href="#">1</a></li>
					<li class="disabled"><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&raquo;</a></li>
			</ul>
			
			<%@ include file="tailer.jsp" %>
			</div>
	</body> 
</html>
