<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>resources/css/Teacher/paper/paperAlter.css" type="text/css" rel="stylesheet" />
<link href="<%=basePath%>resources/css/commons/jquery-ui.css" type="text/css" rel="stylesheet" />
<script src="<%=basePath%>resources/js/commons/jquery-3.0.0.js"></script>
<script src="<%=basePath%>resources/js/commons/jquery-ui.js"></script>
<script charset="gbk" src="<%=basePath%>resources/js/commons/common_func.js"></script>
<script charset="gbk" src="<%=basePath%>resources/js/teacher/paperAlter.js"></script>
<title>Content</title>
</head>

<body>
	<div id="wrap">
		<div id="capwrap">
			<div id="cap">管理试卷</div>
		</div>
		<div id="content">
			<form id="mainForm"
				action="<%=basePath%>${actions}_savePaperAction_Paper" method="get">
				<div id="leftBar">
					<label for="paperName">试卷名称<span>*</span></label><br /> <input
						type="text" name="paperName" id="paperName"
						value="${paper.paperName}" /><br /> <label for="paperDescription">试卷描述<span>*</span></label><br />
					<textarea id="paperDescription" name="paperDescription">${paper.paperDescription}</textarea>
					<br /> <label for="paperAuthor">编辑人<span>*</span></label> <input
						id="paperAuthor" name="paperAuthor" type="text"
						value="${paper.paperAuthor}" />&nbsp;&nbsp;当前分值<span class="star">*</span><i>${paper.paperScore}</i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题量<span
						class="star">*</span><b>${paper.paperSubjectNumber}</b><br />
					<div id="buttonWrap">
						<input class="button" type="button" value="重置"
							onclick="resetPaperDialog();" /> <input class="button"
							type="button" value="查看" onclick="checkPaper();" /> <input
							class="button" type="button" onclick="submitPaper();" value="提交" />
					</div>
				</div>
				<div id="rightBar">
					<input type="hidden" id="basePath" value="<%=basePath%>" /> <input
						id="currentPage" type="hidden" name="currentPage" value="1" />
					<div id="top">
						<label for="subjectType">类型:</label> <input value="${subjectType}"
							id="subjectType" type="text" name="subjectType" x-webkit-speech=""/> <label
							for="subjectTitle">描述:</label> <input value="${subjectTitle}"
							id="subjectTitle" type="text" name="subjectTitle" x-webkit-speech="" /> <input
							type="button" class="button" onclick="querySubject()" value="查询" />
						<div class="right">
							<button onclick="addBatchSubjects();" id="delBatch">添加</button>
						</div>
					</div>
					<table cellpadding="0" cellspacing="0">
						<tr class="head">
							<td class="firTD"><input onclick="check(this);"
								type="checkbox" name="id" /></td>
							<td class="subType">类型</td>
							<td class="subDisc">描述</td>
							<td class="score">分值</td>
							<td colspan="2">操作</td>
						</tr>
						<c:forEach items="${subjects}" var="subject" varStatus="status">
							<tr
								<c:if test="${status.index%2!=0}">style='color:white;background-color:#C33;'</c:if>>
								<td class="firTD"><input type="checkbox" name="subjectIds"
									value="${subject.subjectId}" /></td>
								<td class="subType">${subject.subjectType}</td>
								<td class="subDisc">${subject.subjectTitle}</td>
								<td class="score">${subject.subjectScore}</td>
								<td class="subUp"><a
									onclick="addSubject(${subject.subjectId});" href="#">添加</a></td>
								<td class="subDel"><a
									onclick="viewSubjectDialog('${subject.subjectScore}','${subject.subjectTitle}','${subject.subjectOptionA}','${subject.subjectOptionB}','${subject.subjectOptionC}','${subject.subjectOptionD}','${subject.subjectAnswer}','${subject.subjectParse}')"
									href="#">查看</a></td>
							</tr>
						</c:forEach>
					</table>
					<div class="abs">
						共<b>${page.totalNumber}</b>条
						<button class="button"
							<c:if test="${page.currentPage==1}">style='display:none;'</c:if>
							onclick="pageClick(1);">首页</button>
						<button class="button"
							<c:if test="${page.currentPage==1}">style='display:none;'</c:if>
							onclick="pageClick('${page.currentPage-1}');">上一页</button>
						当前第<span>${page.currentPage}/${page.totalPage}</span>页
						<button class="button"
							<c:if test="${page.currentPage==page.totalPage}">style='display:none;'</c:if>
							onclick="pageClick('${page.currentPage+1}');">下一页</button>
						<button class="button"
							<c:if test="${page.currentPage==page.totalPage}">style='display:none;'</c:if>
							onclick="pageClick('${page.totalPage}');">尾页</button>
						跳至<input name="pageNumber" type="text" id="pageNumber" />页 <span
							onclick="goClick();" id="go">GO</span>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
