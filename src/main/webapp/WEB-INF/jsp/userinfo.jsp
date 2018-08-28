<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
  <meta charset="UTF-8">
  <title>手账分享社区</title>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/commen.css"/>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/account.css"/>

</head>
<body>
<input type="hidden" id="basePath" value="${basePath}"/>
  <input type="hidden" id="uid" value="${sessionScope.user.id}"/>
  <input type="hidden" id="hid" value="${user.id}"/>
<!-- 导航栏 -->
  <div class="ma">
  <header>
  <input type="button" class="back" name="Submit" onclick="fnHashTrigger()" value="返回">
    <!-- 导航栏右边 -->
     <div class="he_right">
      <div class="user" id="user">
        <img class="us_head" id="usHead" src="${basePath}/images/us_head.jpg" width="40" height="40" />
        <div class="us_name" id="usName" ></div>
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
  
  <!-- 个人信息 -->
  <div class="mInfo" uid="34" >
      <div class="mIn_head">
        <img class="nIn_head_image" src="${user.headimgurl}" width="100" height="100" />
      </div>
      <div class="mIn_name">${user.username}</div>
    </div>
    <!-- 左边侧边栏 -->
    <div class="m_left" id="m_left">
      <div class="per_info m_left_select" id="perInfo">个人资料</div>
      <div class="my_homepage " id="hisHomepage">他的手账</div>
      <div class="my_friends " id="hisFans">他的粉丝</div>
    </div>
    </div>
    <!-- 正文主要内容 -->
    <div class="m_main " id="mMain" >
        <!-- 个人资料 -->
        <section  class="preInfoBox" id="preInfoBox" >
          <form action="" method="post">
          <div class="name" >昵称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input readonly="readonly" class="i_name" id="iName" type="text" value="${user.username}"/>
          </div>
          <div class="sex">
            性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <% String usersex="男"; if(((User)request.getAttribute("user")).getSex()){usersex="女";} %>
            <%=usersex %>
            <!-- <input class="man" id="man" type="radio" name="sex" value="男"/>
            男
            <input class="woman" id="woman" type="radio" name="sex" value="女"/>
            女 -->
          </div>
          <div class="city">所在地：&nbsp;&nbsp;
            <input readonly="readonly" class="i_city" id="iCity" type="text" value="${user.city}"/>
          </div>
          <div class="pre_profile">个人简介：
            <textarea readonly="readonly" class="pre_profileI" id="preProfileI" rows="3" cols="20" >${user.content}</textarea>
          </div>
          <!-- <div class="save">
            <input class="saveI" type="submit" value="保存" onclick="changePreInfo()" />
          </div> -->
        </form>
        </section >
        
  </main>
</div>
</div> 
  <script src="${basePath}/js/jquery.min.js"></script>
  <script src="${basePath}/js/functionsBase.js"></script>
  <script src="${basePath}/js/functionsOption.js"></script>
  <script src="${basePath}/js/commen.js"></script>
  <script src="${basePath}/js/websockectJ.js"></script>
  <script src="${basePath}/js/adminOther.js"></script>
</body>
</html>