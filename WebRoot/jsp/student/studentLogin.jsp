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
<title>学生登录主界面</title>
<link href="<%=basePath%>resources/css/student/studentLogin.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>resources/css/commons/jquery-ui.css" type="text/css" rel="stylesheet"/>
<script src="<%=basePath%>resources/js/commons/jquery-3.0.0.js"></script>
<script src="<%=basePath%>resources/js/commons/jquery-ui.js"></script>
<script charset="gbk" src="<%=basePath%>resources/js/commons/common_func.js"></script>
<script charset="utf-8" src="<%=basePath%>resources/js/student/studentLogin.js" type="text/javascript"></script>
</head>

<body>
<input type="hidden" value="<%=basePath%>" id="basePath"/>
<div id="header">
	<div id="headStuInfo">
    	<span>${student.studentID}</span><br />
        <span>${student.studentName}</span><span><c:choose><c:when test="${student.studentSex}==0">女</c:when><c:otherwise>男</c:otherwise></c:choose></span><span>${student.studentAge}</span>
    	<span><c:choose><c:when test="${student.sclass=='0509301'}">一班</c:when><c:when test="${student.sclass=='0509302'}">二班</c:when></c:choose></span>
    </div>
</div>
<div id="content">
	<div id="leftBar">
    	<ul>
        	<li><a id="onlineTestLi" class="current" href="#">在线考试</a></li>
            <li><a id="queryScoreLi" href="#">成绩查询</a></li>
        	<li><a id="baseInfoLi" href="#">信息修改</a></li>
        </ul>
    </div>
    <div id="rightBar">
    	<div id="init"><p>欢迎,${student.studentName}同学使用!</p></div>
    </div>
</div>

</body>
</html>
