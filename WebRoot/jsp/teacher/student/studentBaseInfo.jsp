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
<link href="<%=basePath%>resources/css/Teacher/student/studentBaseInfo.css" type="text/css" rel="stylesheet"/>
<title>Content</title>
</head>

<body>
<div id="wrap">
  <div id="capwrap">
  <div id="cap">基本信息</div>
  </div>
  <div id="content">
  	<div id="wrapform">
  	<form action="<%=basePath%>queryStudentAction_Base" method="get">
  		<label for="sclass">输入班级编号</label>
    	<input for="sclass" type="text"  name="sclass"/>
        <input type="submit" value="确定" />
    </form>
    </div>
    <c:forEach items="${students}" var="student" >
  	<table>
    <tr>
    <td>班级<span>*</span>${student.sclass}</td>
    </tr>
    <tr>
    <td>姓名<span>*</span>${student.studentName}</td>
    </tr>
    <tr>
    <td>性别<span>*</span><c:choose><c:when test="${student.studentSex}">男</c:when><c:otherwise>女</c:otherwise></c:choose></td>
    </tr>
    <tr>
    <td>年龄<span>*</span>${student.studentAge}</td>
    </tr>
    <tr>
    <td>成绩<span>*</span>${student.result}</td>
    </tr>
    </table>
    </c:forEach>
   </div>
  </div>
</body>
</html>
