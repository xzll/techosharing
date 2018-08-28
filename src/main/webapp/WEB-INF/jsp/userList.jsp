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
		<script type="text/javascript" src="${basePath}/js/jquery.min.js"></script>
		<script type="text/javascript" src="${basePath}/js/admin/common/common.js"></script>
		<script type="text/javascript" src="${basePath}/js/admin/content/userList.js"></script>
		<script type="text/javascript" src="${basePath}/js/admin/content/manageUser.js"></script>
	</head>
	<body style="background: #e1e9eb;">
	<div class="ma">
		<form action="${basePath}/admin/user/search" id="mainForm" method="post">
			<input type="hidden" id="id" name="id"/>
			<input type="hidden" id="message" value="${pageCode.msg}"/>
			<input type="hidden" id="basePath" value="${basePath}"/>
			<input type="hidden" name="page.currentPage" id="currentPage" value="1"/>
			<div class="right">
				<div class="rightCont">
					<p class="g_title fix" onclick="toTecho()">手帐列表</p>
					<p class="g_title fix" onclick="toUser()">>用户列表√</p>
					<p class="g_title fix" onclick="toComment()">>评论列表</p>
					<p class="g_title fix" onclick="toNotice()">>公告列表</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td align="right" width="80">昵称：</td>
								<td>
									<input name="username" id="username" value="" class="allInput" type="text"/>
								</td>
	                            <td style="text-align: right;" width="150">
	                            	<input class="tabSub" value="查询" onclick="search('1');" type="button"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                            	<input class="tabSub" value="添加" id="addBtnUser" type="button"/>
	                            </td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th>序号</th>
								    <th>帐号</th>
								    <th>密码</th>
								    <th>昵称</th>
								    <th>性别</th>
								    <th>介绍</th>
								    <th>城市</th>
								    <th>豆豆</th>
								    <th>签到天数</th>
								    <th>操作</th>
								</tr>
								<c:forEach items="${list}" var="item" varStatus="s">
									<tr>
										<td>${s.index + 1}</td>
										<td>${item.email}</td>
										<td>${item.password}</td>
										<td>${item.username}</td>
										<td>
										<script >
											var sex=${item.sex};
											if(sex){
												document.write("女");
											}else{
												document.write("男")
											}
										</script>
											
										    	
										</td>
										<td>${item.content}</td>
										<td>${item.city}</td>
										<td>${item.coin}</td>
										<td>${item.signin}</td>
										<td>
												<a href="javascript:void(0);" uid="${item.id}" id="updateBtnUser">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
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
<!-- 增加用户弹窗 -->
<!-- 弹窗 -->
<div class="hideM" id="hideM" style="display: none"></div>
<div class="userMain" id="userMain" style="display: none">
  <form>
    <input type="text" class="addUser" placeholder="昵称" id="addusername" name="username" />
    <input type="password" class="addUser" placeholder="密码" id="addpasswoed" name="passwoed"/>
    <input type="text" class="addUser" placeholder="邮箱" id="addemail" name="email"/>
    <input type="text" class="addUser" placeholder="豆豆数" id="addcoin" name="coin"/>
    <span>${pageCode.msg}</span>
    <button type="button" class="tabSub" style="    margin: 10px 100px;" id="addUser">添加</button>
  </form>
</div>
<!-- 修改用户信息弹窗 -->
<!-- 弹窗 -->
<div class="hideM" id="hideM"U style="display: none"></div>
<div class="userMain" id="userMainU" style="display: none">
  <form>
    <input type="text" class="updataUser" placeholder="昵称" id="updatausername" name="username" />
    <input type="password" class="updataUser" placeholder="密码" id="updatapasswoed" name="passwoed"/>
    <input type="text" class="updataUser" placeholder="豆豆数" id="updatacoin" name="coin"/>
    <span></span>
    <button type="button" class="tabSub" style="    margin: 10px 100px;" id="updataUser">修改</button>
  </form>
</div>
	</body>
</html>