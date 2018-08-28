// 客户端就会与服务器进行连接
var ws = new WebSocket('ws://localhost:8080/techosharing/websocket');
ws.onopen = function () {
  ws.send('Hello Server!');
}
ws.onmessage = function(event) {
  var data = event.data;
  if(data=="通知：收到评论"){
    $(".redB").css("display","block");
    $(".top1").css("display","block");
  }
  if(data=="通知：收到赞"){
    $(".redB").css("display","block");
    $(".top2").css("display","block");
  }
  if(data=="通知：手帐被收藏了"){
    $(".redB").css("display","block");
    $(".top3").css("display","block");
  }
  if(data=="通知：有人关注了你"){
    $(".redB").css("display","block");
    $(".top4").css("display","block");
  }
  if(data=="通知：素材被购买"){
    $(".redB").css("display","block");
    $(".top5").css("display","block");
  }
  if(data=="通知：有新公告"){
    $(".redB").css("display","block");
    $(".top6").css("display","block");
  }
  if(data=="通知：有新的手帐"){
    $(".redB").css("display","block");
    $(".top7").css("display","block");
  }
};

// 评论
function clickCo(){
  clearAll("mMain");
  $(".top1").css("display","none");
  $(".redB").css("display","none");
  // 请求评论列表
  getCommentP(1);
}

// 赞
function clickTu(){
  clearAll("mMain");
  $(".top2").css("display","none");
  $(".redB").css("display","none"); 
  // 请求赞列表
  getThumbupP(1);
}

// 收藏
function clickColl(){
  clearAll("mMain");
  $(".top3").css("display","none");
  $(".redB").css("display","none");
  // 请求收藏列表
  getCollectP(1);
}
// 粉丝
function clickFa(){
  clearAll("mMain");
  $(".top4").css("display","none");
  $(".redB").css("display","none");
  // 请求粉丝列表 
   var uid=$("#uid").val();
  getFansP(uid,1);
}
// 好友
function clickFri(){
  clearAll("mMain");
  $(".top7").css("display","none");
  $(".redB").css("display","none");
  // 发送请求,获取好友动态即关注者发的 
   var uid=$("#uid").val();
  getFri(uid,1);
};
// 购买
function clickBuy(){
  clearAll("mMain");
  $(".top5").css("display","none");
  $(".redB").css("display","none");
  // 发送请求,获取好友动态即关注者发的 
  gototran();
};
// 新公告
function clickNotice(){
  clearAll("mMain");
  $(".top6").css("display","none");
  $(".redB").css("display","none");
  // 发送请求,获取好友动态即关注者发的 
  getNotice();
};
