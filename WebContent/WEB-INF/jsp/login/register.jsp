<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>用户注册</title>
<link rel="stylesheet" href="${ctx}/resource/css/supersized.css">
<link rel="stylesheet" href="${ctx}/resource/css/login.css">
<link href="${ctx}/resource/css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="js/html5.js"></script>
<![endif]-->
<script src="${ctx}/resource/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/tooltips.js"></script>
<%-- <script type="text/javascript" src="${ctx}/resource/js/login.js"></script> --%>
</head>
<body>

<div class="page-container">
	<div class="main_box" style="height:504px;">
		<div class="login_box">
			<div class="login_logo" style="margin-top: -8px;margin-bottom: -15px;">
<%-- 				<img src="${ctx}/resource/images/logo.png" > --%>
              <span id="denglu" style="font-size: 30px; ">  用户注册</span>  
			</div>
		
			<div class="login_form">
				<form action="user_register.do"  method="post">
					<div class="form-group">
						<label for="j_username" class="t">账      号：</label> 
						<input id="userName" value="" name="userName" type="text" class="form-control x319 in" 
						autocomplete="off">
					</div>
					<div class="form-group">
						<label for="j_password" class="t">密　码：</label> 
						<input id="passWord" value="" name="passWord" type="password" 
						class="password form-control x319 in">
					</div>
					<div class="form-group">
						<label for="j_password" class="t">手机号码：</label> 
						<input id="phone" value="" name="phone" type="text" 
						class="password form-control x319 in">
					</div>
					<div class="form-group">
					<label for="j_password" class="t">邮 箱：</label> 
						<input id="email" value="" name="email" type="text" 
						class="password form-control x319 in">
					</div>
					<div class="form-group">
					<label for="j_password" class="t">证件类型：</label> 
					 <select name="cardType" >
				           <option value="0">二代身份证</option>
				               <option value="1">护照</option>
				              <option value="2">港澳通行证</option>
				              <option value="3">台湾通行证</option>
				         </select>
					</div>
					<div class="form-group">
					<label for="j_password" class="t">证件号：</label> 
						<input id="idCard" value="" name="idCard" type="text" 
						class="password form-control x319 in">
					</div>
					
					<label for="j_password" class="t" style="margin-left: 68px;"> 
					性别 ：<span ></span> &nbsp;&nbsp;男:<input type="radio" name="sex" value="1" />
				        &nbsp;&nbsp; &nbsp;&nbsp;  女:<input type="radio" name="sex" value="2"  /></label> 
						<!-- <input id="idCard" value="" name="idCard" type="text" 
						class="password form-control x319 in"> -->
					</div>
					<div class="form-group space" style="margin-top: 83px;">
						<label class="t"></label>　　　
						 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit"  value="&nbsp;注&nbsp;册&nbsp;" onclick="register()" class="btn btn-default btn-lg" style="margin-left: 39px;margin-top: -98px;">
					</div>
				</form>
			</div>
		</div>
		<div class="bottom">Copyright &copy; 2019 <a href="#">系统登陆</a></div>
	</div>
</div>

<!-- Javascript -->

<script src="${ctx}/resource/js/supersized.3.2.7.min.js"></script>
<script src="${ctx}/resource/js/supersized-init.js"></script>
<script src="${ctx}/resource/js/scripts.js"></script>
<script type="text/javascript">
function register(){
	window.location.href="${ctx}/login_register.do";
}
</script>
<div style="text-align:center;">
</body>
</html>