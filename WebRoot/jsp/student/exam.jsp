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
<script charset="gbk" type="text/javascript" src="<%=basePath%>resources/js/student/exam.js"></script>
<title>开始考试</title>
</head>

<body>
<div id="wrap">
<div id="header">
<h1>${paperName}</h1>
<div id="testInfo">
<span>考试时间:20分钟</span>&nbsp;&nbsp;<span>考生:${student.studentName}</span>&nbsp;&nbsp;<span>总分:${paperScore}</span>
<span>剩余时间:<strong id="leftTime">20</strong></span></div>
</div>
<div id="content">
<form id="mainform" action="<%=basePath%>examAction" method="post">
<c:forEach items="${subjectList}" var="subject" varStatus="status">
<input type="hidden" value="${subject.subjectId}" name="subject_${status.index}_id"/>
<table>
<tr>
<th class="testTitle">${status.index+1}(${subject.subjectScore}分).${subject.subjectTitle}</th>
</tr>
<tr>
<td><input value="A" id="subject_${status.index}_a" checked="checked" type="radio" name="subject_${status.index}"/>
<label for="subject_${status.index}_a"><b>A.</b>${subject.subjectOptionA}</label></td>
</tr>
<tr>
<td><input value="B" id="subject_${status.index}_b" type="radio" name="subject_${status.index}"/>
<label for="subject_${status.index}_b"><b>B.</b>${subject.subjectOptionB}</label></td>
</tr>
<tr>
<td><input value="C" id="subject_${status.index}_c" type="radio" name="subject_${status.index}"/>
<label for="subject_${status.index}_c"><b>C.</b>${subject.subjectOptionC}</label></td>
</tr>
<tr>
<td><input value="D" id="subject_${status.index}_d" type="radio" name="subject_${status.index}"/>
<label for="subject_${status.index}_d"><b>D.</b>${subject.subjectOptionD}</label></td>
</tr>
</table>
</c:forEach>
<div id="wrapSub">
<input type="submit" value="提交" />
</div>
</form>
</div>
<div id="footer">
</div>
</div>
</body>
</html>
