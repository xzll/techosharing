<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
<head>
  <meta charset="UTF-8">
  <title>手账分享社区</title> 
  <!-- <link rel="stylesheet" type="text/css" href="../css/main.css"/> -->
  <link rel="stylesheet" type="text/css" href="../css/commen.css"/>
  <link rel="stylesheet" type="text/css" href="../css/admin.css"/>
  <link rel="stylesheet" type="text/css" href="../css/transact.css"/>

</head>
<body>
  
  <!-- 导航栏 -->
  <div class="ma">
  <header>
    <!-- 导航栏左边 -->
    <div class="he_left">
      <div class="logo"></div>
      <div class="search_box">
        <input type="text" class="search" id="search"/ placeholder="搜索">
        <div class="search_btn">
          <img class="search_btn_image" src="../images/searchBtn.png" width="25" height="30" />
        </div>
      </div>
    </div>
    <!-- 导航栏右边 -->
     <div class="he_right">
      <div class="homepage">主页</div>
      <div class="user" id="user">
        <img class="us_head" src="../images/us_head.jpg" width="40" height="40" />
        <div class="us_name">珞缡</div>
      </div>
      <div class="message" id="message">
        <img class="me_head" src="../images/message.png" width="30" height="25" />
        <div class="me_name">消息</div>
      </div>   
  </header>
<!-- 用户弹窗 -->
      <div class="us_popup rlt" id="us_popup" style="display:none">
        <div class="sign_box" >
          <span>已签到1天</span>
          &nbsp;
          <span class="sign_btn" id="signBtn">签到</span>
          &nbsp;
          <span>豆豆2颗</span>
        </div>
        <div >
        <div class="us_popup_btn">
          <img src="../images/mypage.png" width="50" height="50" alt="">
          <div class="us_popup_font">我的主页</div>
        </div>
        <div class="us_popup_btn">
          <img src="../images/put.png" width="50" height="50" alt="">
          <div class="us_popup_font">上传手账</div>
        </div>
        <div class="us_popup_btn">
          <img src="../images/account.png" width="50" height="50" alt="">
          <div class="us_popup_font">账号设置</div>
        </div>
        <div class="us_popup_btn">
          <img src="../images/logoff.png" width="50" height="50" alt="">
          <div class="us_popup_font">退出登录</div>
        </div>
        </div>
      </div>
      <!-- 消息弹窗 -->
      <ul class="me_popup rlt" id="me_popup" style="display:none">
        <li>评论</li>
        <li>赞</li>
        <li>收藏</li>
        <li>粉丝</li>
        <li>系统消息</li>
      </ul>
  <!-- 正文 -->
  <main>
  
  <!-- 个人信息 -->
  <div class="mInfo" uid="34" >
      <div class="mIn_head">
        <img class="nIn_head_image" src="../images/us_head.jpg" width="100" height="100" />
      </div>
      <div class="mIn_name">手账小达人</div>
    </div>

    <!-- 左边侧边栏 -->
    <div class="m_left" id="m_left">
      <div class="my_homepage m_left_select" id="buyList">购买列表</div>
      <div class="my_friends " id="sellList">卖出列表</div>
    </div>
    <!-- 正文主要内容 -->
    <!-- 好友动态 -->
    <div class="m_main " id="mMain"  >
    </div>
  </main>
</div>
</div> 
  <script src="../js/jquery.min.js"></script>
  <script src="../js/functionsBase.js"></script>
  <script src="../js/functionsOption.js"></script>
  <script src="../js/commen.js"></script> 
  <script src="../js/transact.js"></script>
</body>
</html>
