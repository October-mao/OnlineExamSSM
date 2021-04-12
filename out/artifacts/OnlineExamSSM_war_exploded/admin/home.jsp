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
 	<style type="text/css">
		.table{
			width: 500px;
			height: 100px;
			margin-top: 50px;
			margin-left: 80px;
		}
		.table2{
			width: 500px;
			height: 100px;
			margin-top: 50px;
			margin-left: 60px;
		}
 		.totalDiv {
 			height: 50px;
			width: 200px;
 			border: 1px solid #DDDDDD;
 			line-height: 100px;
 			margin-left: 80px;
 			margin-top: 30px;
 			border-radius: 3px;
 		}
 		.totalTitle {
 			float: left;
 			width: 40%;
 			height: 100%;
 			line-height: 50px;
 			text-align: center;
 			margin-left: -15px;
 		}
 		.totalValue {
 			float: right;
 			width: 50%;
 			height: 60%;
 			line-height: 50px;
 			text-align: center;
 		}
 		.val {
 			font-size: 18px;
 			font-weight: 300;
 		}
 		h1 {
 			color: #FFF;
 		}
 	</style>
</head>
<body style="text-align: center;">
	<div class="alert alert-block alert-success">
		<button class="close" data-dismiss="alert" type="button" style="text-align: center;">
			<img src="${path }/images/admin/x.png" />
		</button>
		<i class="icon-ok green"></i>
		欢迎使用
		<strong>
			线上单元考试系统
			<small>(v1.0)</small>
		</strong>
		, 欢迎使用
	</div>
	<div class="state-overview clearfix">
		<div class="col-lg-3 col-sm-5 totalDiv">
			<div class="totalTitle" id="examPaperTotal">
				<a></a>
			</div>
			<div class="totalValue">
				<span class="val"></span>
			</div>
		</div>
		<div class="col-lg-3 col-sm-5 totalDiv">
			<div class="totalTitle" id="subjectTotal">
				<a></a>
			</div>
			<div class="totalValue">
				<span class="val"></span>
			</div>
		</div>
		<div class="col-lg-3 col-sm-5 totalDiv">
			<div class="totalTitle" id="teacherTotal">
				<a></a>
			</div>
			<div class="totalValue">
				<span class="val"></span>
			</div>
		</div>
		<div class="col-lg-3 col-sm-5 totalDiv">
			<div class="totalTitle" id="studentTotal">
				<a></a>
			</div>
			<div class="totalValue">
				<span class="val"></span>
			</div>
		</div>
	</div>
	<div class="table" style="float: left">
	<table border="0" >
		<tr>
			<th>课表</th>
		</tr>
		<tr>
			<td>1-15周(1-4节) - 星期一 - 形势与政策4 - 集美校区 明理4-503</td>
			<td>x老师</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td>1-15周(5-8节) - 星期三 - 会计学原理4 - 集美校区 明理3-404</td>
			<td>z老师</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td>4-15周(2-4节)-星期四-高等数学-集美校区 - 博学苑1-213-专业机房</td>
			<td>y老师</td>
		</tr>
	</table>
	</div>
	<div class="table2" style="float: left" >
		<table border="0"  >
			<tr>
				<th>信息</th>
			</tr>
			<tr>
				<td>【通知】关于启动学生学籍异动(休学、复学、留降级)网上办理流程的通知</td>
				<td>发布人：林建国</td>
				<td>2020-12-17 10:40:39</td>
			</tr>
			<tr>
				<td>【通知】关于2020-2021学年第一学期期初体育教学相关工作的通知</td>
				<td>发布人：林建国</td>
				<td>2020-09-03 09:38:15</td>
			</tr>
			<tr>
				<td>【通知】关于做好疫情期间课程考核有关工作的指导意见</td>
				<td>发布人：卓志强</td>
				<td>2020-05-11 10:41:31</td>
			</tr>
			<tr>
				<td>【通知】关于2019-2020-2学期期初公选课补换选课的通知</td>
				<td>发布人：黄启东</td>
				<td>2020-02-24 17:10:51</td>
			</tr>

		</table>
	</div>
	<!-- js引入 -->
    <script src="${path }/js/jquery.js"></script>
    <script src="${path }/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript">
    	$(function() {
    		$.getJSON("../homeInfo", function(data) {
    			$.each(data, function(key, item) {
    				if("examPaperTotal" == key.trim()) {
    					$("#examPaperTotal").css("background-color", "#6CCAC9");
    					$("#examPaperTotal").children("a").text("试卷数量");
    					$("#examPaperTotal").siblings(".totalValue").children("span").text(item+"套");
    				} else if("subjectTotal" == key.trim()) {
    					$("#subjectTotal").css("background-color", "#FF6C60");
    					$("#subjectTotal").children("a").text("题目数量");
    					$("#subjectTotal").siblings(".totalValue").children("span").text(item+"道");
    				} else if("teacherTotal" == key.trim()) {
    					$("#teacherTotal").css("background-color", "#F8D347");
    					$("#teacherTotal").children("a").text("教师人数");
    					$("#teacherTotal").siblings(".totalValue").children("span").text(item+"人");
    				} else if("studentTotal" == key.trim()) {
    					$("#studentTotal").css("background-color", "#57C8F2");
    					$("#studentTotal").children("a").text("学生人数");
    					$("#studentTotal").siblings(".totalValue").children("span").text(item+"人");
    				}
    			});
    		});
    	});
    </script>
</body>
</html>