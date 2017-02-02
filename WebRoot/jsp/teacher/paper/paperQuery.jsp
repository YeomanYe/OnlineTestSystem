<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>resources/css/Teacher/paper/paperQuery.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>resources/css/commons/jquery-ui.css" type="text/css" rel="stylesheet" />
<script src="<%=basePath%>resources/js/commons/jquery-3.0.0.js"></script>
<script src="<%=basePath%>resources/js/commons/jquery-ui.js"></script>
<script charset="gbk" src="<%=basePath%>resources/js/teacher/paperQuery.js" ></script>
<title>Content</title>
</head>

<body>
<div id="dialog" title="确认对话框" style="display:none;">
<p>确定删除吗?</p>
</div>
<div id="wrap">
  <div id="capwrap">
  <div id="cap">试卷查询</div>
  </div>
  <div id="content">
  <form id="mainForm" action="<%=basePath%>queryPaperAction" method="get">
  <input type="hidden" name="currentPage" value="${currentPage}" id="currentPage"/>
  <input type="hidden" id="basePath" value="<%=basePath%>"/>
    <div id="top">
 	<label for="paperName">试卷名称:</label>
    <input id="paperName" value="${paperName}" type="text" name="paperName" />
    <label for="paperDescription">描述:</label>
    <input id="paperDescription" value="${paperDescription}" type="text" name="paperDescription" />
    <input type="submit" value="查询" />
    <div class="right">
    <input type="button" value="删除" onclick="delPaperDialog();" id="delBatch"/>
    </div>
    </div>
    <table cellpadding="0" cellspacing="0">
	  <tr class="head">
      <td><input type="checkbox" onclick="check(this);" name="id"  /></td>
      <td>序号</td>
      <td>试卷名称</td>
      <td>描述</td>
      <td>题量</td>
      <td>编写人</td>
      <td>创建时间</td>
      <td colspan="2">操作</td>
      </tr>
      <c:forEach items="${papers}" var="paper" varStatus="status">
      <tr <c:if test="${status.index%2==1}">class="head"</c:if>>
      <td><input type="checkbox" name="paperIds" value="${paper.paperId}"/></td>
      <td>${status.index+1}</td>
      <td>${paper.paperName}</td>
      <td>${paper.paperDescription}</td>
      <td>${paper.paperSubjectNumber}</td>
      <td>${paper.paperAuthor}</td>
      <td><fmt:formatDate value="${paper.paperCreateDate}" pattern="yyyy-MM-dd"/></td>
      <td class="subUp"><a href="<%=basePath%>query_savePaperAction_PaperForUpdate?paperId=${paper.paperId}">修改</a></td>
      <td class="subDel"><a href="#" onclick="delPaperDialog('${paper.paperId}')">删除</a></td>
      </tr>
      </c:forEach>
    </table>
	<div class="abs">
    	共<b>${page.totalNumber}</b>条
        <button <c:if test="${page.currentPage==1}">style='display:none;'</c:if> onclick="pageClick(1);">首页</button>
        <button <c:if test="${page.currentPage==1}">style='display:none;'</c:if> onclick="pageClick('${page.currentPage-1}');">上一页</button>
        当前第<span>${page.currentPage}/${page.totalPage}</span>页
        <button <c:if test="${page.currentPage==page.totalPage}">style='display:none;'</c:if> onclick="pageClick('${page.currentPage+1}');">下一页</button>
        <button <c:if test="${page.currentPage==page.totalPage}">style='display:none;'</c:if> onclick="pageClick('${page.totalPage}');">尾页</button>
        跳至<input name="pageNumber" type="text" id="pageNumber" />页 <span onclick="goClick();" id="go">GO</span>
    </div>
    </form>
  </div>
  </div>
</body>
</html>
