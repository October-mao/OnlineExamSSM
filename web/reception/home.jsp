<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Insert title here</title>
	<%
    	String path = request.getContextPath();
	    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    %>
	<c:set var="path" value="<%=basePath %>"></c:set>
 	<link href="${path }/css/bootstrap/bootstrap.min.css" rel="stylesheet" />
</head>
<body style="background-color: #EEEEEE;">
	<div class="jumbotron" style="height: 300px;padding-top: 50px; padding-bottom: 0px; margin-bottom: 0px;">
		<div style="padding: 20px;">
	<div id="page-wrapper">
		<div class="box" >
			<br><br><br>
			<div class="function" align="center"><p>[通知]考试系统已开放</p></div>
			<div class="form">
				<table class="news" align="center">
					<tr><td><b>关于本学期校级考试相关事宜安排的通知</b></td></tr>
					<tr><td>各学院及相关单位:</td></tr>
					<tr><td>根据学校教学安排，下星期全校考试定于1月8日-1月22日 考试周，考试工作将从1月8日开始。现将有关事项通知如下：</td></tr>
					<tr><td>一、考试时间：6月8日----6月12日</td></tr>
					<tr><td>二、学生登录考试管理系统后进入学生考试进行考试。学生考试前请认真阅读考试公告，再进行“网上考试”。</td></tr>
					<tr><td>三、教师可登陆考试管理系统后进入试卷试题的增删查改， 6月12日14:00之后各位教师及学生登录教务处网站查询自己试卷及其考试成绩。</td> </tr>
					<tr><td>四、考试均须在选课时间内完成，考试结束后不再进行补退选，请学生注意考试时间。</td></tr>
					<tr><td>五、请各学院通知并组织学生进行考试，同时请各学院及相关单位通知任课教师按时出卷。教务处将组织相关人员对上课情况进行不定期的检查。</td></tr>
					<tr><td align="right">2021-1-5</td></tr>
				</table>
			</div>
		</div>
	</div>
			<p style="margin-top:20px;" align="center">
				<a class="btn btn-primary btn-large" href="https://www.icourse163.org/" target="_blank" >学习更多</a>
			</p>
		</div>
	</div>

	<!-- js引入 -->
    <script src="${path }/js/jquery.js"></script>
    <script src="${path }/js/bootstrap/bootstrap.min.js"></script>
</body>
</html>