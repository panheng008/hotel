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
<title>用户登录</title>
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
	<div class="main_box">
		<div class="login_box">
			<div class="login_logo" style="margin-top: 20px;">
<%-- 				<img src="${ctx}/resource/images/logo.png" > --%>
              <span id="denglu" style="font-size:30px; ">  用户登录</span>  
			</div>
		
			<div class="login_form">
				<form action="user_login.do"  method="post">
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
<!-- 						<label for="j_captcha" class="t">验证码：</label> -->
<!-- 						 <input id="j_captcha" name="j_captcha" type="text" class="form-control x164 in"> -->
<%-- 						<img id="captcha_img" alt="点击更换" title="点击更换" src="${ctx}/resource/images/captcha.jpeg" class="m"> --%>
					</div>
					<div class="form-group">
<!-- 						<label class="t"></label> -->
<!-- 						<label for="j_remember" class="m"> -->
<!-- 						<input id="j_remember" type="checkbox" value="true">&nbsp;记住登陆账号!</label> -->
					</div>
					<div class="form-group space" style="margin-top: 83px;">
						<label class="t"></label>　　　
						<button type="submit"  id="submit_btn" 
						class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="&nbsp;注&nbsp;册&nbsp;" onclick="register()" class="btn btn-default btn-lg">
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
<div style="text-align:center;">
<script type="text/javascript">
function register(){
	window.location.href="${ctx}/login_register.do";
}
</script>
</body>
</html>