<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
  <meta charset="UTF-8">
  <title>手账分享社区</title> 
  <!-- <link rel="stylesheet" type="text/css" href="${basePath}/css/main.css"/> -->
  <link rel="stylesheet" type="text/css" href="${basePath}/css/commen.css"/>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/admin.css"/>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/transact.css"/>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/manageOpeart.css"/>

</head>
<body>
  <input type="hidden" id="basePath" value="${basePath}"/>
  <input type="hidden" id="uid" value="${sessionScope.user.id}"/>
<!-- 导航栏 -->
  <div class="ma">
  <header>
    <!-- 导航栏右边 -->
     <div class="he_right">
      <div class="user" id="user">
        <img class="us_head" id="usHead" src="${basePath}/images/us_head.jpg" width="40" height="40" />
        <div class="us_name" id="usName" >珞缡</div>
      </div>
      <div class="message" id="message">
        <img class="me_head" src="${basePath}/images/message.png" width="30" height="25" />
        <div class="me_name">消息</div>
      </div>   
  </header>
<!-- 用户弹窗 -->
      <div class="us_popup rlt" id="us_popup" style="display:none">
        <div class="sign_box" >
          <span id="signN">已签到145天</span>
          &nbsp;
          <span class="sign_btn" id="signBtn">签到</span>
          &nbsp;
          <span class="coinN" id="coinN">豆豆225颗</span>
        </div>
        <div >
        <div class="us_popup_btn" id="myhome">
          <img src="${basePath}/images/mypage.png" width="50" height="50" alt="">
          <div class="us_popup_font">我的主页</div>
        </div>
        <div class="us_popup_btn" id="uploadJo">
          <img src="${basePath}/images/put.png" width="50" height="50" alt="">
          <div class="us_popup_font">上传手账</div>
        </div>
        <div class="us_popup_btn" id="account">
          <img src="${basePath}/images/account.png" width="50" height="50" alt="">
          <div class="us_popup_font">账号设置</div>
        </div>
        <div class="us_popup_btn" id="logout">
          <img src="${basePath}/images/logoff.png" width="50" height="50" alt="">
          <div class="us_popup_font" >退出登录</div>
        </div>
        </div>
      </div>
      <!-- 消息弹窗 -->
     <ul class="me_popup rlt" id="me_popup" style="display:none">
        <li onclick="clickCo()">评论</li>
        <li onclick="clickTu()">赞</li>
        <li onclick="clickColl()">收藏</li>
        <li onclick="clickFa()">粉丝</li>
        <li onclick="clickBuy()">购买</li>
        <li onclick="isNewNotice()">新公告</li>
        <li onclick="clickFri()">关注动态</li>


      <div class="redS top1" style="display:none"></div>
      <div class="redS top2" style="display:none"></div>
      <div class="redS top3" style="display:none"></div>
      <div class="redS top4" style="display:none"></div>
      <div class="redS top5" style="display:none"></div>
      <div class="redS top6" style="display:none"></div>
      <div class="redS top7" style="display:none"></div>
      </ul>
      <div class="redB" style="display:none"></div>
  <!-- 正文 -->
  <main>
  

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

<div class="hideM" id="hideM" style="display: none"></div>
<div class="adMain" id="adMain" style="display:none">
  <div class="adTitle" id="adTitle" ></div>
  <div class="adTime" id="adTime" ></div>
  <div class="adContent" id="adContent" >
    
  </div>
    <div class="adSub" id="adSub"   style="margin-top:15px;width:100%;text-align:center;">
       <button type="button" class="tabSub"  id="readAd" >确认</button>
    </div>
</div>
  <script src="${basePath}/js/jquery.min.js"></script>
  <script src="${basePath}/js/functionsBase.js"></script>
  <script src="${basePath}/js/functionsOption.js"></script> 
  <script src="${basePath}/js/commen.js"></script>
  <script src="${basePath}/js/transact.js"></script>
  <script src="${basePath}/js/websockectJ.js"></script>
</body>
</html>
