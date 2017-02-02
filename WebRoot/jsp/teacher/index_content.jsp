<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>resources/css/Teacher/index_content.css" type="text/css" rel="stylesheet"/>
<title>Content</title>
</head>

<body>
<div id="wrap">
  <div id="capwrap">
  <div id="cap">欢迎界面</div>
  </div>
  <div id="content">
  		<h1>欢迎使用在线考试管理系统!</h1>
        <p>欢迎老师使用在线考试管理系统!</p>
   </div>
  </div>
</body>
</html>
