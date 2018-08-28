<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
<head>
  <meta charset="UTF-8">
  <title>手账分享社区</title>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/commen.css"/>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/admin.css"/>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/journalOther.css"/>

</head>
<body>
<input type="hidden" id="basePath" value="${basePath}"/>
  <input type="hidden" id="uid" value="${sessionScope.user.id}"/>
<input type="hidden" id="tid" value="${tid}"/>
  <input type="hidden" id="area" value="${area}"/>
<!-- 导航栏 -->
  <div class="ma">
  <header>
  <input type="button" class="back" name="Submit" onclick="history.go(-1)" value="返回">
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
    
    <!-- 正文主要内容 -->
    <div class="m_main " id="mMain" >
        <section  class="journalA" id="journalA" >
        <div class="joTitle" id="joTitle"></div>
        <div class="joAuthor" id="joAuthor"></div>
        <div class="joTime" id="joTime"></div>
        <div class="joContent" id="joContent">
        </div>
        <div class="joImages" id="joImages">
         </div>
        <div class="joHandle" tid="12">
          <hr/>
          <div class="joHaComment" id="joHaComment"> </div>
          <div class="joHaCollect" id="joHaCollect" ></div>
          <div class="joHaThumbup" id="joHaThumbup"></div>
          <div class="joHaMaterial" id="joHaMaterial"></div>
        </div>
        <div class="addComment" >
          <img class="coHeadimg" src="" width="40" height="40" />
          <textarea id="subComment"  placeholder="写下你的评论"></textarea>
          <div class="addC" id="addC">发表</div>
        </div>
        <div class="joCommentBox" id="joCommentBox">
        </div>
        </section >

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
  <script src="${basePath}/js/journalOther.js"></script>
  <script src="${basePath}/js/websockectJ.js"></script>
</body>
</html>