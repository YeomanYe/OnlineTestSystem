<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath %>resources/css/Teacher/index_leftBar.css" type="text/css" rel="stylesheet"/>
<script src="<%=basePath %>resources/js/teacher/leftBar.js" type="text/javascript"></script>
<title>leftBar</title>
</head>

<body>
<div id="wrap">
	<dl class="current">
    <dt onclick="dtClick(this)">试题管理</dt>
    <dd class="head"><a target="main" href="<%=basePath%>querySubjectAction">管理试题</a></dd>
    <dd class="tail"><a target="main" href="<%=basePath%>add_saveSubjectAction">添加试题</a></dd>
    </dl>
    <dl>
    <dt onclick="dtClick(this)">试卷管理</dt>
    <dd><a target="main" href="<%=basePath%>query_savePaperAction_Subject">试卷编辑</a></dd>
    <dd class="tail head"><a target="main" href="<%=basePath%>queryPaperAction">试卷查询</a></dd>
    </dl>
    <dl>
    <dt onclick="dtClick(this)">学生管理</dt>
    <dd><a target="main" href="student/studentAllInfo.jsp">详细信息查询</a></dd>
    <dd class="tail head"><a target="main" href="student/studentBaseInfo.jsp">班级学生查询</a></dd>
    </dl>
    <dl>
    <dt onclick="dtClick(this)">成绩管理</dt>
    <dd><a target="main" href="result/resultInfo.jsp">成绩查询</a></dd>
    </dl>
</div>
</body>
</html>
