<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>resources/css/Teacher/student/studentAllInfo.css" type="text/css" rel="stylesheet"/>
<title>Content</title>
</head>

<body>
<div id="wrap">
  <div id="capwrap">
  <div id="cap">详细信息</div>
  </div>
  <div id="content">
  	<div id="wrapform">
  	<form action="<%=basePath%>queryStudentAction_All" method="get">
  		<label for="studentId">输入学生ID</label>
    	<input id="studentId" type="text"  name="studentId"/>
        <input type="submit" value="确定" />
    </form>
    <c:if test="${student!=null}">
  	<table>
  	<tr><td>ID<span>*</span>${student.studentID}</td></tr>
    <tr>
    <td>班级<span>*</span>${student.sclass}</td>
    </tr>
    <tr>
    <td>姓名<span>*</span>${student.studentName}</td>
    </tr>
    <tr>
    <td>性别<span>*</span><c:if test="${student!=null}"><c:choose><c:when test="${student.studentSex}">男</c:when><c:otherwise>女</c:otherwise></c:choose></c:if></td>
    </tr>
    <tr>
    <td>年龄<span>*</span>${student.studentAge}</td>
    </tr>
    <tr>
    <td>成绩<span>*</span>${student.result}</td>
    </tr>
    <tr>
    <td>邮箱<span>*</span>${student.studentEmail}</td>
    </tr>
    <tr>
    <td>注册时间<span>*</span><fmt:formatDate value="${student.studentRegisterDate}" pattern="yyyy-MM-dd"/></td>
    </tr>
    </table>
    </c:if>
    </div>
   </div>
  </div>
</body>
</html>
