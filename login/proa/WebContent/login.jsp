<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>学生管理系统</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
</head>
<body style="background: url(img/back.jpg) ; background-size:100% 100% ; background-attachment: fixed;text-align:center;margin-top:300px">
 
<div style="width:100%;height:100%;">
<!-- 登陆界面  -->
	<h2>
		 <strong>登陆</strong>
	</h2>
	<form action="login.do" method="post">
		<div>
			 <input type="text" placeholder="账号" name="azh"/>
		</div>
		<br/>
		<div>
			 <input type="password" placeholder="密码" name="apwd"/>
		</div>
		<br/>
	    <div>
	    	<input type="submit" value="立即登陆"/>
	    	<a href="zhuce.jsp"><input type="button" value="立即注册"/></a>
	    </div>
    </form>
    
</div>
</body>
</html>