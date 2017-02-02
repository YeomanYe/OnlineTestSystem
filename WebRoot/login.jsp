<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>resources/css/login.css" type="text/css" rel="stylesheet" />
<link href="<%=basePath%>resources/css/commons/jquery-ui.css" type="text/css" rel="stylesheet"/>
<script src="<%=basePath%>resources/js/commons/jquery-3.0.0.js"></script>
<script src="<%=basePath%>resources/js/commons/jquery-ui.js"></script>
<script charset="gbk" src="<%=basePath%>resources/js/commons/common_func.js"></script>
<script charset="gbk" src="<%=basePath%>resources/js/login.js"></script>
<title>无标题文档</title>
</head>

<body>
<input type="hidden" id="basePath" value="<%=basePath%>"/>
<div id="wrap">
<div id="content">
<form id="mainForm" method="post" action="<%=basePath%>loginAction">
<table>
<tr>
<td><label for="username">用户名:</label></td>
<td><input type="text" id="username" name="username"/></td>
</tr>
<tr>
<td><label for="password">密&nbsp;码:</label></td>
<td><input type="password" id="password" name="password"/></td>
</tr>
<tr>
<td colspan="2"><input value="teacher" type="radio" checked="checked" id="teacherRadio" name="role"/><label for="teacherRadio">教师</label><input value="student" type="radio" name="role" id="studentRadio" /><label for="studentRadio">学生</label></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="登录"/><input class="button" onclick="registerDialog('<%=basePath%>')"  type="button" value="注册"/></td>
</tr>
</table>
</form>
</div>
</div>
</body>
</html>
