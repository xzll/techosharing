<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
 "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
		<title></title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/all.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/pop.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/adminUserMain.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/manageAd.css"/>
		<script type="text/javascript" src="${basePath}/js/jquery.min.js"></script>
		<script type="text/javascript" src="${basePath}/js/admin/common/common.js"></script>
		<script type="text/javascript" src="${basePath}/js/admin/content/noticeList.js"></script>
	</head>
	<body style="background: #e1e9eb;">
	<div class="ma">
		<form action="${basePath}/admin/notice/search" id="mainForm" method="post">
			<input type="hidden" id="id" name="id"/>
			<input type="hidden" id="message" value="${pageCode.msg}"/>
			<input type="hidden" id="basePath" value="${basePath}"/>
			<input type="hidden" name="page.currentPage" id="currentPage" value="1"/>
			<div class="right">
				<div class="rightCont">
					<p class="g_title fix" onclick="toTecho()">手帐列表</p>
					<p class="g_title fix" onclick="toUser()">>用户列表</p>
					<p class="g_title fix" onclick="toComment()">>评论列表</p>
					<p class="g_title fix" onclick="toNotice()">>公告列表√</p>
					<table class="tab2" width="100%">
					当前公告：
							<tbody>
								<tr>
								    <th>标题</th>
								    <th>内容</th>
								    <th>时间</th>
								</tr>
								
								<tr>
										<td>${notice.title}</td>
										<td>${notice.content}</td>
										<td>${notice.createtime}</td>
								</tr>
							</tbody>
					</table>
					发布记录：
					<table class="tab1">
						<tbody>
						
							<tr>
								<td align="right" width="80">内容：</td>
								<td>
									<input name="content" id="content" value="" class="allInput" type="text"/>
								</td>
	                            <td style="text-align: right;" width="150">
	                            	<input class="tabSub" value="查询" onclick="search('1');" type="button"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                            	<input class="tabSub" value="发布公告" id="btnAd" type="button"/>
	                            </td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								
								<tr>
								    <th>序号</th>
								    <th>标题</th>
								    <th>内容</th>
								    <th>时间</th>
								    <th>操作</th>
								</tr>
								
								<c:forEach items="${list}" var="item" varStatus="s">
									<tr>
										<td>${s.index + 1}</td>
										<td>${item.title}</td>
										<td>${item.content}</td>
										<td>${item.createtime}</td>
										<td>
												<a href="javascript:void(0);" onclick="remove('${item.id}')">删除</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<!-- 分页 -->
						<t:page jsMethodName="search" page="${searchParam.page}"></t:page>
					</div>
				</div>
			</div>
		</form>
</div>
<!-- 增加公告弹窗 -->
<div class="hideM" id="hideM" style="display: none"></div>
<div class="adMain" id="adMain" style="display: none">
  <div class="adTitle" id="adTitle" contenteditable="true" ></div>
  <div class="adContent" id="adContent" contenteditable="true"></div>
  
    <div class="adSub" id="adSub"   style="margin-top:15px;width:100%;text-align:center;">
       <button type="button" class="tabSub"  id="uploadAd">发布</button>
    </div>
</div>
	</body>
</html>