<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
  <meta charset="UTF-8">
  <title>手账分享社区</title>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/commen.css"/>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/admin.css"/>

</head>
<body>
  <input type="hidden" id="basePath" value="${basePath}"/>
  <!-- 导航栏 -->
  <div class="ma">
  <header>
    <!-- 导航栏左边 -->
    <div class="he_left">
      <div class="logo"></div>
      <div class="search_box">
        <input type="text" class="search" id="search"/ placeholder="搜索">
        <div class="search_btn">
          <img class="search_btn_image" src="${basePath}/images/searchBtn.png" width="25" height="30" />
        </div>
      </div>
    </div>
    <!-- 导航栏右边 -->
     <div class="he_right">
      <div class="homepage">主页</div>
      <div class="user" id="user">
        <img class="us_head" src="${basePath}/images/us_head.jpg" width="40" height="40" />
        <div class="us_name">珞缡</div>
      </div>
      <div class="message" id="message">
        <img class="me_head" src="${basePath}/images/message.png" width="30" height="25" />
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
          <img src="${basePath}/images/mypage.png" width="50" height="50" alt="">
          <div class="us_popup_font">我的主页</div>
        </div>
        <div class="us_popup_btn">
          <img src="${basePath}/images/put.png" width="50" height="50" alt="">
          <div class="us_popup_font">上传手账</div>
        </div>
        <div class="us_popup_btn">
          <img src="${basePath}/images/account.png" width="50" height="50" alt="">
          <div class="us_popup_font">账号设置</div>
        </div>
        <div class="us_popup_btn">
          <img src="${basePath}/images/logoff.png" width="50" height="50" alt="">
          <div class="us_popup_font">退出登录</div>
        </div>
        </div>
      </div>
      <!-- 消息弹窗 -->
      <ul class="me_popup rlt" id="me_popup" style="display:none">
        <li onclick="clickCo()">评论</li>
        <li onclick="clickTu()">赞</li>
        <li onclick="clickColl()">收藏</li>
        <li onclick="clickFa()">粉丝</li>
        <li onclick="clickFri()">关注动态</li>

      <div class="redS top1" style="display:none"></div>
      <div class="redS top2" style="display:none"></div>
      <div class="redS top3" style="display:none"></div>
      <div class="redS top4" style="display:none"></div>
      <div class="redS top5" style="display:none"></div>
      </ul>
      <div class="redB" style="display:none"></div>
  <!-- 正文 -->
  <main>
    <!-- 左边侧边栏 -->
    <div class="m_left" id="m_left">
      <div class="my_homepage" id="myHomepage">我的手账</div>
      <div class="my_friends m_left_select" id="myFriends">好友动态</div>
      <div class="at_me" id="atMe">与我相关
      <div class="at_me_m" id="atMeM" style="display:none">
        <div class="comment" id="comment">√&nbsp;&nbsp;评论</div>
        <div class="thumbup" id="thumbup">赞</div>
        <div class="collect" id="collect">收藏</div>
        <div class="fans" id="fans">粉丝</div>
      </div>
      </div>
    </div>
    <!-- 正文主要内容 -->
    <!-- 好友动态 -->
    <div class="m_main " id="mMain" >
      
    </div>
  </main>
</div>
</div> 
  <script src="${basePath}/js/jquery.min.js"></script>
  <script src="${basePath}/js/functionsBase.js"></script>
  <script src="${basePath}/js/functionsOption.js"></script>
  <script src="${basePath}/js/admin.js"></script>
</body>
</html>
