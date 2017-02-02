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
<link href="<%=basePath%>resources/css/student/exam.css" type="text/css" rel="stylesheet" />
<title>开始考试</title>
</head>

<body>
<div id="wrap">
<div id="header">
<h1>${paperName}</h1>
<div id="testInfo">
<span>考试时间:20分钟</span>&nbsp;&nbsp;<span>考生:${student.studentName}</span>&nbsp;&nbsp;<span>总分:${paperScore}</span>&nbsp;&nbsp;<span>得分:${totalScore}</span>
</div></div>
<div id="content">
<c:forEach items="${subjectList}" var="subject" varStatus="status">
<table>
<tr>
<th class="testTitle">${status.index+1}(${subject.subjectScore}分).${subject.subjectTitle}</th>
</tr>
<tr>
<td ><b>A.</b>${subject.subjectOptionA}</td>
</tr>
<tr>
<td><b>B.</b>${subject.subjectOptionB}</td>
</tr>
<tr>
<td><b>C.</b>${subject.subjectOptionC}</td>
</tr>
<tr>
<td><b>D.</b>${subject.subjectOptionD}</td>
</tr>
<tr>
<td>我的答案:<i>${studentAnswer[status.index]}</i></td>
</tr>
<tr>
<td>答案:<b>${subject.subjectAnswer}</b></td>
</tr>
</table>
</c:forEach>
</div>
<div id="footer">
</div>
</div>
</body>
</html>
