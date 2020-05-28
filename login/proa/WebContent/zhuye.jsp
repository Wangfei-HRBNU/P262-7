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
<body style="background: url(img/back.jpg) ; background-size:100% 100% ; background-attachment: fixed;text-align:center;margin-top:200px">
 
<div style="width:100%;height:100%;">
<!-- 修改界面  -->
	<h3>修改界面</h3>
	<!-- action里面是写的对应的方法路径，在web.xml里面进行查找，然后进入相应的方法中 -->
	<form action="update.do" method="post">
		<div>
			 <input type="text" placeholder="密码" name="apwd"/>
		</div>
		<br/>
	    <div>
	    	<input type="submit" value="修改密码"/>
	    </div>
    </form>
    
</div>
</body>
</html>