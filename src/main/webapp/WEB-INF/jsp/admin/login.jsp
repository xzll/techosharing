<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
<head>
  <meta charset="UTF-8">
  <title>手账分享社区</title>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/commen.css"/>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/main.css"/>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/index.css"/>

</head>
<body>

 <input type="hidden" id="basePath" value="${basePath}"/>
  <!-- 登录注册 -->
  <div class="lo"  id="lo" >
  <!-- 登录 -->
  <div class="formContainer rlt" id="loginBox" >
      <span class="login rlt" id="login">登录</span>
      <span class="tips rlt" id="tips">${pageCode.msg}</span>
      <form action="${basePath}/admin/login/validate" class="rlt" method="post">
        <div class="settled">
        <input type="text" id="userL" class="rlt" placeholder="用户名" name="username" autocomplete="off">
        <input type="password" id="passwordL" class="rlt" placeholder="密码" name="password">
        <div class="row rlt" autocomplete="off">
          <input type="checkbox" id="rememberL"  onkeydown="check_enter(event)" checked="true">
          <span class="remember rlt" >记住账号</span>
        </div>
        <input type="submit" id="loginBtn" class="rlt" value="登录" >
        </div>
      </form>
    </div>
  <script src="${basePath}/js/jquery.min.js"></script>
  <script src="${basePath}/js/jquery.cookie.js" type="text/javascript"></script>
  <script src="${basePath}/js/adminLogin.js"></script>
</body>
</html>
