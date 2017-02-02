<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>resources/css/student/result.css" type="text/css" rel="stylesheet" />
<title>无标题文档</title>
</head>

<body>
<div id="wrap">
<table cellpadding="0" cellspacing="0">
<tr>
<th align="center" colspan="2">考试情况表</th>
</tr>
<tr>
<td align="center" colspan="2">${paperName}</td>
</tr>
<tr>
<td>考生:${student.studentName}</td>
<td>成绩:${totalScore}</td>
</tr>
<tr>
<td align="center" colspan="2"><a href="<%=basePath%>jsp/student/resultInfo.jsp">查看试卷</a></td>
</tr>
</table>
</div>
</body>
</html>
