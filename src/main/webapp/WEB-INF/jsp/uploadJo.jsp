<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
  <meta charset="UTF-8">
  <title>手账分享社区</title>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/commen.css"/>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/admin.css"/>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/uploadJo.css"/>

</head>
<body>
  
<input type="hidden" id="basePath" value="${basePath}"/>
<input type="hidden" id="uid" value="${sessionScope.user.id}"/>
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
        <div class="us_popup_btn" id="logout">
          <img src="${basePath}/images/logoff.png" width="50" height="50" alt="">
          <div class="us_popup_font">退出登录</div>
        </div>
        </div>
      </div>
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
  <main>
    <div class="m_main " id="mMain" >
    </div>
    <div class="eMain">
      <div class="eTitle" id="eTitle" contenteditable="true" ></div>
      <div class="eContent" id="eContent" contenteditable="true"></div>
      
      <div class="eImages" >
        <form id="form"  action="" method="post" enctype="multipart/form-data">
        <div class="imgbtn" ID="select" >上传图片
        <input type="file" id="xdaTanFileImg"  multiple="multiple"  name="fileAttach" onchange="xmTanUploadImg(this)" onclick="onlyUp()" />
      </div> 

      <div class="hideM" id="hideM" style="display: none"></div>
        <div class="upImg">
        <div class="img-box" id="imgboxid">
        <div class="imgTxt">
          手账图片
        </div>    </div>
        <div id="xmTanDiv"></div><br/>
        <div class="errordiv" id="errordiv"   style="margin-top:15px;width:100%;text-align:center;">
           <button type="button" onclick="uploadJo()">提交</button>
           <button type="button" onclick="clearImg()">清空图片</button>
        </div>
      </div>
        </form>
      </div>
      <div class="eImages" id="eImages" style="display: none">
        <form id="form"  action="" method="post" enctype="multipart/form-data">
        <input type="file" id="meFileImg"  multiple="multiple"  name="fileAttach" onchange="xmTanUploadImg2(this)" />
        <div class="meimg-box" id="meimgboxid">
        <div class="meimgTxt">
          素材图片
        </div>    </div>
        <div id="xmTanDiv"></div><br/>
        <div class="meText">
          名称：<input type="text" class="name" id="name"/>
          数量：<input type="text" class="num" id="num"/>
          价格：<input type="text" class="price" id="price"/>
          <button type="button" id="upMe" onclick="uploadMe()">上传素材</button>
        </div>
        </form>
      </div>
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
  <script src="${basePath}/js/uploadJo.js"></script>
  <script src="${basePath}/js/websockectJ.js"></script>
</body>
</html>
