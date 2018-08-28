<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/all.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/pop.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/adminUserMain.css"/>
		<script type="text/javascript" src="${basePath}/js/jquery.min.js"></script>
		<script type="text/javascript" src="${basePath}/js/admin/common/common.js"></script>
		<script type="text/javascript" src="${basePath}/js/admin/content/commentList.js"></script>
	</head>
	<body style="background: #e1e9eb;">
		<form action="${basePath}/admin/comment/search" id="mainForm" method="post">
			<input type="hidden" id="id" name="id"/>
			<input type="hidden" id="message" value="${pageCode.msg}"/>
			<input type="hidden" id="basePath" value="${basePath}"/>
			<input type="hidden" name="page.currentPage" id="currentPage" value="1"/>
			<div class="right">
				
				<div class="rightCont">
					<p class="g_title fix" onclick="toTecho()">手帐列表</p>
					<p class="g_title fix" onclick="toUser()">>用户列表</p>
					<p class="g_title fix" onclick="toComment()">>评论列表√</p>
					<p class="g_title fix" onclick="toNotice()">>公告列表</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td align="right" width="80">内容：</td>
								<td>
									<input name="content" id="content" value="" class="allInput" type="text"/>
								</td>
	                            <td style="text-align: right;" width="150">
	                            	<input class="tabSub" value="查询" onclick="search('1');" type="button"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                            </td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th>序号</th>
								    <th>作者</th>
								    <th>评论内容</th>
								    <th>所属手帐</th>
								    <th>手帐作者</th>
								    <th>评论时间</th>
								    <th>操作</th>
								</tr>
				 				<c:forEach items="${list}" var="item" varStatus="s"> 
									<tr>
										<td>${s.index + 1}</td>
										<td>${item.username}</td>
										<td>${item.content}</td>
										<td>${item.techo.title}</td>
										<td>${item.techo.username}</td>
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
	</body>
</html>