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
<img src="E:\background\2017-11-29_22-28-24-001.jpg" width="40" height="40" />
 <input type="hidden" id="basePath" value="${basePath}"/>
  <!-- 登录注册 -->
  <div class="lo"  id="lo" >
  <!-- 登录 -->
  <div class="formContainer rlt" id="loginBox" >
      <span class="login rlt" id="login">登录</span>
      <span class="cut rlt" >/</span>
      <span class="register rlt" id="register">注册</span><br>
      <span class="tips rlt" id="tips">${pageCode.msg}</span>
      <form action="${basePath}/login/validate" class="rlt" method="post">
        <div class="settled">
        <input type="text" id="userL" class="rlt" placeholder="邮箱" name="email" autocomplete="off">
        <input type="password" id="passwordL" class="rlt" placeholder="密码" name="password">
        <div class="row rlt" autocomplete="off">
          <input type="checkbox" id="rememberL"  onkeydown="check_enter(event)" checked="true">
          <span class="remember rlt" >记住账号</span>
        </div>
        <input type="submit" id="loginBtn" class="rlt" value="登录" >
        </div>
      </form>
      <!-- 注册 -->
    </div>
      <div class="formContainer rlt" id="registerBox"  style="display:none">
      <span class="login rlt" id="login2">登录</span>
      <span class="cut rlt" >/</span>
      <span class="register rlt" id="register2">注册</span><br>
      <span class="tips rlt">${pageCode.msg}</span>
      <form action="${basePath}/register/validate" class="rlt" method="post">
        <div class="settled">
        <input type="text" id="userR" class="rlt" placeholder="邮箱" name="email" autocomplete="off">
        <div class="getCode rlt" onclick="code()">发送验证码</div>
        <input type="password" id="passwordR" class="rlt" placeholder="密码" name="password">
        <input type="code" id="codeR" class="rlt" placeholder="验证码" name="code">
        
        <input type="submit" id="registerBtn" class="rlt" value="注册">
        </div>
      </form>
    </div>
    </div>
  <!-- 导航栏 -->
  
  <!-- 正文 -->
  <main>
    
  </main>
  <script src="${basePath}/js/jquery.min.js"></script>
  <script src="${basePath}/js/jquery.cookie.js" type="text/javascript"></script>
  <script src="${basePath}/js/login.js"></script>
  <script src="${basePath}/js/index.js"></script>
</body>
</html>
