<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="queryScore">
        	<table  cellpadding="0" cellspacing="0">
                <tr class="odd">
                    <th>试卷名</th>
                  	<th>得分</th>
                    <th>考试时间</th>
                </tr>
                <c:forEach items="${results}" var="result" varStatus="status">
                <tr class="even">
                	<td>${result.paperName}</td>
                  	<td>${result.score}</td>
                    <td><fmt:formatDate value="${result.time}" pattern="yyyy-MM-dd"/></td>
                </tr>
                </c:forEach>
            </table>
 </div>