<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>resources/css/Teacher/subject/subjectAdd.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>resources/css/commons/jquery-ui.css" type="text/css" rel="stylesheet"/>
<script src="<%=basePath%>resources/js/commons/jquery-3.0.0.js"></script>
<script src="<%=basePath%>resources/js/commons/jquery-ui.js"></script>
<script charset="gbk" src="<%=basePath%>resources/js/commons/common_func.js"></script>
<script charset="gbk" src="<%=basePath%>resources/js/teacher/subjectAdd.js"></script>
<title>试题添加</title>
</head>

<body>
<div id="wrap">
  <div id="capwrap">
  <div id="cap"><c:choose><c:when test="${action=='add'}">试题添加</c:when><c:otherwise>试题更新</c:otherwise></c:choose></div>
  </div>
  <div id="content">
  	<form id="mainForm" action="<%=basePath%>${action}_saveSubjectAction" method="get">
  	<input type="hidden" value="${subject.subjectId}" name="id"/>
    <label for="subjectTitle">题&nbsp;目<span>*</span></label><br />
    <textarea id="subjectTitle" name="subjectTitle">${subject.subjectTitle}</textarea><br />
    <label for="subjectOptionA">选项A<span>*</span></label>
    <input id="subjectOptionA" name="subjectOptionA" type="text" value="${subject.subjectOptionA}"/><br />
    <label for="subjectOptionB">选项B<span>*</span></label>
    <input id="subjectOptionB" name="subjectOptionB" type="text" value="${subject.subjectOptionB}"/><br />
    <label for="subjectOptionC">选项C<span>*</span></label>
    <input id="subjectOptionC" name="subjectOptionC" type="text" value="${subject.subjectOptionC}"/><br />
    <label for="subjectOptionD">选项D<span>*</span></label>
    <input id="subjectOptionD" name="subjectOptionD" type="text" value="${subject.subjectOptionD}"/><br />
    <label for="subjectType">类&nbsp;型<span>*</span>&nbsp;</label>
    <select name="subjectType" id="subjectType">
    <option <c:if test="${subject.subjectType=='计算机'}">selected="selected"</c:if> >计算机</option>
    <option <c:if test="${subject.subjectType=='软件'}">selected="selected"</c:if> class="color">软件</option>
    <option <c:if test="${subject.subjectType=='系统'}">selected="selected"</c:if>>系统</option>
    <option <c:if test="${subject.subjectType=='通信'}">selected="selected"</c:if> class="color">通信</option>
    <option <c:if test="${subject.subjectType=='常识'}">selected="selected"</c:if>>常识</option>
    </select>
    &nbsp;&nbsp;&nbsp;&nbsp;<label for="subjectAnswer">答案<span>*</span></label>&nbsp;&nbsp;
    <input value="${subject.subjectAnswer}" checked="checked" value="A" name="subjectAnswer" id="subjectAnswer" type="radio"/>A<input value="B" name="subjectAnswer"type="radio"/>B<input value="C" name="subjectAnswer"type="radio"/>C<input value="D" name="subjectAnswer"type="radio"/>D 
    &nbsp;&nbsp;<label for="score">分值<span>*</span></label><input id="score" type="text" name="score" value="${subject.subjectScore}"/><br/>
    <label for="subjectParse">解&nbsp;析<span>*</span></label><br />
    <textarea id="subjectParse" name="subjectParse">${subject.subjectParse}</textarea>
    <div id="wrap2">
    <input type="button" onclick="resetSubjectDialog('<%=basePath%>');" value="重置" class="button"/>
    <input class="button" type="button" onclick="saveSubjectByAjax();" value="确定"/>
    </div>
    </form>
   </div>
  </div>
</body>
</html>
