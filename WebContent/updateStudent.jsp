<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="com.model.Student" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="css/main.css" />
	</head>
	<body>
			<%
				Student stu = (Student)request.getAttribute("stus");
			%>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<form role="form" action="student" method="post">
						<div class="form-group">
							 <label for="sid">学号</label><input type="text" class="form-control" readonly="readonly" id="sid" name="sid" value="<%=stu.getSid() %>"/>
						</div>
						<div class="form-group">
							 <label for="sname">姓名</label><input type="text" class="form-control" id="sname" name="sname"value="<%=stu.getSname()%>" />
						</div>
						<div class="form-group">
							 <label for="age">年龄</label><input type="text" class="form-control" id="age" name="age" value="<%=stu.getAge() %>"/>
						</div>
						<div class="form-group">
							 <label for="sex">性别</label>
							 
							 <select class="form-control" id="sex" name="sex" >
								<option <% if(stu.getSex().equals("男")){%> selected <% } %>>男</option>
								<option <% if(stu.getSex().equals("女")){%> selected <% } %>>女</option>
							 </select>
						</div>
						<div class="form-group">
							 <label for="phone">联系方式</label><input type="tel" class="form-control" id="phone" name="phone" value="<%=stu.getPhone() %>"/>
						</div>
						<div class="form-group">
							 <label for="school">学校</label><input type="text" class="form-control" id="school" name="school" value="<%=stu.getSchool() %>" />
						</div>
						<div class="form-group">
							 <label for="grade">年级</label><input type="text" class="form-control" id="grade" name="grade" value="<%=stu.getGrade() %>"/>
						</div>
						<div class="form-group">
							 <label for="major">专业</label><input type="text" class="form-control" id="major" name="major" value="<%=stu.getMajor()%>"/>
						</div>
						<input type="hidden" name="action" value="toUpdate">
						<button type="submit" class="btn btn-default">提交</button>
					</form>
				</div>
			</div>
			
		</div>
		
	</body>
	
</html>
