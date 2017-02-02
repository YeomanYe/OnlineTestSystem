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
<link href="<%=basePath%>resources/css/Teacher/subject/subjectAlter.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>resources/css/commons/jquery-ui.css" type="text/css" rel="stylesheet"/>
<script src="<%=basePath%>resources/js/commons/jquery-3.0.0.js"></script>
<script src="<%=basePath%>resources/js/commons/jquery-ui.js"></script>
<script charset="gbk" src="<%=basePath%>resources/js/commons/common_func.js"></script>
<script charset="gbk" src="<%=basePath%>resources/js/teacher/subjectAlter.js"></script>
<title>Content</title>
</head>

<body>
<div id="wrap">
  <div id="capwrap">
  <div id="cap">管理试题</div>
  </div>
  <div id="content">
  <form id="mainForm" action="<%=basePath%>querySubjectAction" method="get">
  	<input type="hidden" id="subjectId" name="subjectId"/>
  	<input type="hidden" id="basePath" value="<%=basePath %>"/>
    <input type="hidden" id="currentPage" name="currentPage" value="1"/>
    <div id="top">
 	<label for="subjectType">类型:</label>
    <input value="${subjectType}" id="subjectType" type="text" name="subjectType" />
    <label for="subjectTitle">描述:</label>
    <input value="${subjectTitle}" id="subjectTitle" type="text" name="subjectTitle" />
    <input type="submit" value="查询"/>
    <div class="right">
    <input type="button" value="删除"  onclick="subjectDialog(${page.currentPage},1);" id="delBatch"/>
    </div>
    </div>
    <table cellpadding="0" cellspacing="0">
	  <tr class="head">
      <td class="firTD"><input onclick="check(this);" type="checkbox" name="id"  /></td>
      <td class="order">序号</td>
      <td class="subType">类型</td>
      <td class="subDisc">描述</td>
      <td>分值</td>
      <td colspan="2">操作</td>
      </tr>
      <c:forEach items="${subjects}" var="subject" varStatus="status">
      <tr <c:if test="${status.index%2!=0}">style='color:white;background-color:#069;'</c:if>>
      <td class="firTD"><input type="checkbox" name="subjectIds" value="${subject.subjectId}"/></td>
      <td class="order">${status.index+1}</td>
      <td class="subType">${subject.subjectType}</td>
      <td class="subDisc">${subject.subjectTitle}</td>
      <td>${subject.subjectScore}</td>
      <td class="subUp"><a href="<%=basePath%>update_saveSubjectAction?subjectId=${subject.subjectId}">修改</a></td>
      <td class="subDel"><a href="#" onclick="subjectDialog(${subject.subjectId},0,${page.currentPage});" >删除</a></td>
      </tr>
      </c:forEach>
    </table>
    <div class="abs">
    	共<b>${page.totalNumber}</b>条
        <button class="button" <c:if test="${page.currentPage==1}">style='display:none;'</c:if> onclick="pageClick(1);">首页</button>
        <button class="button" <c:if test="${page.currentPage==1}">style='display:none;'</c:if> onclick="pageClick('${page.currentPage-1}');">上一页</button>
        当前第<span>${page.currentPage}/${page.totalPage}</span>页
        <button class="button"<c:if test="${page.currentPage==page.totalPage}">style='display:none;'</c:if> onclick="pageClick('${page.currentPage+1}');">下一页</button>
        <button class="button" <c:if test="${page.currentPage==page.totalPage}">style='display:none;'</c:if> onclick="pageClick('${page.totalPage}');">尾页</button>
        跳至<input name="pageNumber" type="text" id="pageNumber" />页 <span onclick="goClick();" id="go">GO</span>
    </div>
    </form>
  </div>
  </div>
</body>
</html>
