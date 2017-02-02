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
<link href="<%=basePath%>resources/css/Teacher/result/resultInfo.css"type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>resources/css/commons/jquery-ui.css" type="text/css" rel="stylesheet"/>
<script src="<%=basePath%>resources/js/commons/jquery-3.0.0.js"></script>
<script src="<%=basePath%>resources/js/commons/jquery-ui.js"></script>
<script charset="gbk" src="<%=basePath%>resources/js/commons/common_func.js"></script>
<script charset="gbk" src="<%=basePath%>resources/js/teacher/resultInfo.js"></script>
<title>Content</title>
</head>

<body>
<input id="studentID" value="${studentID}" type="hidden"/>
<div id="wrap">
  <div id="capwrap">
  <div id="cap">成绩查询</div>
  </div>
  <div id="content">
  	<div id="wrapform">
  	<form id="form2" action="<%=basePath%>query_resultAction" method="get">
    	<label for="stuID">输入学生ID：</label>
    	<input id="stuID" type="text" value="${studentID}" name="studentID"/>
        <input type="submit" value="确定" />
    </form>
    <div id="wrapTab">
    <c:if test="${!empty results}">
    <table>
    <tr>
    <th>试卷名称</th>
    <th>分数</th>
    <th>日期</th>
    <th>操作</th>
    </tr>
    <c:forEach items="${results}" var="result" varStatus="status">
    <tr <c:choose ><c:when test="${status.index%2==0}">class="odd"</c:when><c:otherwise>class="even"</c:otherwise></c:choose> > 
    <td>${result.paperName}</td>
    <td>${result.score}</td>
    <td><fmt:formatDate value="${result.time}" pattern="yyyy-MM-dd"/></td>
    <td><a href="#" onclick="updateResultDialog('${result.resultID}','<%=basePath%>')">修改</a></td>
    </tr>
    </c:forEach>
    </table>
    </c:if>
    </div>
    </div>
   </div>
  </div>
</body>
</html>
