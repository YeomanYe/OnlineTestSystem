<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>resources/css/Teacher/paper/paperCheck.css" type="text/css" rel="stylesheet"/>
<title>Content</title>
</head>

<body>
<div id="wrap">
  <div id="capwrap">
  <div id="cap">试卷查看</div>
  </div>
  <div id="content">
  <c:forEach items="${paper.subjects}" var="subject" varStatus="status">
  	<table>
    <tr>
    <td>${status.index+1}(${subject.subjectScore}分)${subject.subjectTitle}</td>
    </tr>
    <tr>
    <td>A ${subject.subjectOptionA}</td>
    </tr>
    <tr>
    <td>B ${subject.subjectOptionB}</td>
    </tr>
    <tr>
    <td>C ${subject.subjectOptionC}</td>
    </tr>
    <tr>
    <td>D ${subject.subjectOptionD}</td>
    </tr>
    <tr>
    <td>答案:${subject.subjectAnswer}</td>
    </tr>
    <tr>
    <td>解析:${subject.subjectParse}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>del_savePaperAction_SubjectFromPaper?subjectId=${subject.subjectId}">删除</a></td>
    </tr>
    </table>
    </c:forEach>
   </div>
  </div>
</body>
</html>
