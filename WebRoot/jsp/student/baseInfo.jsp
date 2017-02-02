<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="baseInfo">
    	<form id="stuInfoForm" action="<%=basePath%>update_studentOperateAction_StudentInfo" method="post">
 			<label for="studentID">学生ID<span>*</span></label>
            ${student.studentID}<br />
            <label for="studentName">学生姓名<span>*</span></label>
            <input type="text" name="studentName" id="studentName" value="${student.studentName}"/><br />
            <label for="studentAge">学生年龄<span>*</span></label>
            <input id="studentAge" name="studentAge" type="text" value="${student.studentAge}"/><br />
            <label for="studentSex">学生性别<span>*</span></label>
            <input id="studentSex" type="radio" <c:if test="${student.studentSex=true}"> checked="checked" </c:if> name="studentSex" value="1"/>男<input <c:if test="${student.studentSex==false}"> checked="checked" </c:if> value="0" name="studentSex" type="radio"/>女<br />
            <label for="studentEmail">邮箱<span>*</span></label>
            <input type="text" id="studentEmail" name="studentEmail" value="${student.studentEmail}"/><br />
            <label for="avgScore">平均成绩<span>*</span></label>${student.result}<br />
            <input id="okBtn" onclick="updateStuInfo()" type="button" value="提交" />
            <input id="cancelBtn" type="reset" value="重置"/>          
        </form>
    </div>