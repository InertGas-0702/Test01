<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div class="container">
			<%@ include file="header.jsp" %>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<form role="form" action="student" method="post">
						<div class="form-group">
							 <label for="sid">学号</label><input type="text" class="form-control" id="sid" name="sid" />
						</div>
						<div class="form-group">
							 <label for="sname">姓名</label><input type="text" class="form-control" id="sname" name="sname" />
						</div>
						<div class="form-group">
							 <label for="age">年龄</label><input type="text" class="form-control" id="age" name="age"/>
						</div>
						<div class="form-group">
							 <label for="sex">性别</label>
							 
							 <select class="form-control" id="sex" name="sex" >
								<option>男</option>
								<option>女</option>
							 </select>
						</div>
						<div class="form-group">
							 <label for="phone">联系方式</label><input type="tel" class="form-control" id="phone" name="phone" />
						</div>
						<div class="form-group">
							 <label for="school">学校</label><input type="text" class="form-control" id="school" name="school" />
						</div>
						<div class="form-group">
							 <label for="grade">年级</label><input type="text" class="form-control" id="grade" name="grade" />
						</div>
						<div class="form-group">
							 <label for="major">专业</label><input type="text" class="form-control" id="major" name="major" />
						</div>
						<input type="hidden" name="action" value="add">
						<button  type="submit" class="btn btn-default">提交</button>
					</form>
				</div>
			</div>
			
			<%@ include file="tailer.jsp" %>
		</div>
		
	</body>
	
</html>
