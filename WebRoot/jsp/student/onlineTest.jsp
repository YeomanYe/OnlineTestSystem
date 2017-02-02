<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="onlineTest">
        	<table  cellpadding="0" cellspacing="0">
                <tr class="odd">
                	<th>序号</th>
                    <th>试卷名</th>
                    <th>试卷描述</th>
                    <th>试卷分值</th>
                    <th>试卷题量</th>
                    <th>出卷时间</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${papers}" var="paper" varStatus="status">
                <tr <c:if test="${status.index%2==1}">class="odd"</c:if>>
                	<td>${status.index+1}</td>
                	<td>${paper.paperName}</td>
                    <td>${paper.paperDescription}</td>
                    <td>${paper.paperScore}</td>
                    <td>${paper.paperSubjectNumber}</td>
                    <td><fmt:formatDate value="${paper.paperUpdateDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <td><a href="<%=basePath%>execute_studentOperateAction_Test?paperId=${paper.paperId}">&gt;&gt;进入考试</a></td>
                </tr>
                </c:forEach>
            </table>
        </div>