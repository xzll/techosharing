// 进入个人中心
function goToMyhome(){
  $("#myFriends").addClass("m_left_select");
  $("#myHomepage").removeClass("m_left_select");  
  $("#atMe").removeClass("m_left_select");
  // 关闭小列表
  $("#atMeM").css("display","none");
  // 发送请求,获取好友动态即关注者发的 
  var uid=$("#uid").val();
  getFri(uid,1);
}
// 退出登录
/*function logout(){
  var path = $("#basePath").val()+"/user/logout";
  window.location.href=path;
  $.ajax({
    headers: { 
          'Accept': 'application/json',
          'Content-Type': 'application/json' 
      },
     contentType: 'application/json',
      type:"post",
      url:path,
      contentType:"application/json;charset=utf-8",
      data:'',
      success:function (data) {
      }
  })
}*/

//签到天数获取
function getSignN(){
  var path = $("#basePath").val()+"/user/show";
  var uid = $("#uid").val();
  var a ={id:uid}
  $.ajax({
    headers: { 
          'Accept': 'application/json',
          'Content-Type': 'application/json' 
      },
     /*contentType: 'application/json',*/
      type:"post",
      url:path,
      contentType:"application/json;charset=utf-8",
      data:JSON.stringify(a),
      success:function (data) {
        var signN = data.signin;
        var coinN = data.coin;
        var isSign = data.isSign;
        if(isSign){
          $("#signBtn").html("已签到");
        }
        $("#signN").html("已签到"+signN+"天");
        $("#coinN").html("豆豆"+coinN+"颗");
      }
  })
}
// 执行签到动作
function doSign(){
  var spath = $("#basePath").val()+"/user/show";
  var uid = $("#uid").val();
  var a ={id:uid}
  $.ajax({
    headers: { 
          'Accept': 'application/json',
          'Content-Type': 'application/json' 
      },
     /*contentType: 'application/json',*/
      type:"post",
      url:spath,
      contentType:"application/json;charset=utf-8",
      data:JSON.stringify(a),
      success:function (data) {
        var isSign = data.isSign;
        if(isSign){
          alert("今日已签到过了")
        }else{
          var path = $("#basePath").val()+"/user/signIn";
          var uid = $("#uid").val();
          var a ={id:uid}
          $.ajax({
            headers: { 
                  'Accept': 'application/json',
                  'Content-Type': 'application/json' 
              },
             /*contentType: 'application/json',*/
              type:"post",
              url:path,
              contentType:"application/json;charset=utf-8",
              data:JSON.stringify(a),
              success:function (data) {
                var signN = data.signin;
                var coinN = data.coin;
                $("#signN").html("已签到"+signN+"天");
                $("#coinN").html("豆豆"+coinN+"颗");
              }
          })
        }
      }
  })
        
}
// 进入个人中心
$("#user").click(function(){
  goToMyhome();
  var path = $("#basePath").val()+"/index";
  //跳转到admin.html
  window.location.href=path;
});
$("#myhome").click(function(){
  goToMyhome();
  var path = $("#basePath").val()+"/index";
  //跳转到admin.html
  window.location.href=path;
});

// 上传手账
$("#uploadJo").click(function(){
	var path = $("#basePath").val()+"/techo/uploadJo";
  //跳转到uploadJo.html
  window.location.href=path;
});

// 账号设置
$("#account").click(function(){
	var path = $("#basePath").val()+"/user/account";
  //跳转到account.html
  window.location.href=path;
});

//退出登录
$("#logout").click(function(){
//  logout();
//  var path = $("#basePath").val()+"/index.jsp";
//  window.location.href=path;
	  var path = $("#basePath").val()+"/user/logout";
	  window.location.href=path;
});


//签到
$("#user").mouseover(function(){
 $("#us_popup").css("display","block");
 // 同时发送请求，获取签到相关数据
 getSignN();
});
$("#signBtn").click(function(){
  doSign();
  $("#signBtn").html("已签到");
});
//进入交易界面
$("#coinN").click(function(){
  gototran()
});




//导航栏信息获取
$(function(){
    var uid=$("#uid").val();
    var userInfoPath = $("#basePath").val()+"/user/show";
	var a={id:uid}
	$.ajax({
	    contentType: 'application/json',
	      type:"post",
	      url:userInfoPath,
	      async:false,
	      contentType:"application/json;charset=utf-8",
	      data:JSON.stringify(a),
	      success:function(data){
	        var headimgurl=data.headimgurl;
	        var username = data.username;
	        if (username.length>3){
		        username = username.substring(0,3)+"...";	        	
	        }
	    	$("#usHead").attr("src",headimgurl);
	    	$("#usName").html(username);	        
	      }
	  });
})

// 创建公告查看界面
function createNotice(title,time,content){
  var bod=document.getElementByTagName("body");
    var hideM = createEle("div", "hideM");
    hideM.id="hideM";
    var adMain = createEle("div", "adMain");
    adMain.id="adMain";
      var adTitle = createEle("div", "adTitle");
      adTitle.id="adTitle";
      adTitle.html=title;
      var adTime = createEle("div", "adTime");
      adTime.id="adTime";
      adTime.html=time;
      var adContent = createEle("div", "adContent");
      adContent.id="adContent";
      adContent.html=content;
    addChilds(adMain, adTitle,adTime,adContent);
    addChilds(bod, hideM,adMain);


}
// 已读请求




// 鼠标移出移入用户框
$("#user").mouseover(function(){
 $("#us_popup").css("display","block");
 // 同时发送请求
});
$("#user").mouseout(function(){
 $("#us_popup").css("display","none");
});

$("#us_popup").mouseover(function(){
 $("#us_popup").css("display","block");
});
$("#us_popup").mouseout(function(){
 $("#us_popup").css("display","none");
});
// 鼠标移出移入消息框
$("#message").mouseover(function(){
 $("#me_popup").css("display","block");
});
$("#message").mouseout(function(){
 $("#me_popup").css("display","none");
});

$("#me_popup").mouseover(function(){
 $("#me_popup").css("display","block");
});
$("#me_popup").mouseout(function(){
 $("#me_popup").css("display","none");
});

    var eleMenus = $("#m_left div").bind("click", function(event) {
      // var query = this.href.split("?")[1];
      var query = this.id;
      if (history.pushState && query && !$(this).hasClass("m_left_select")) {
          /*
              ajax载入~~
          */
          
          // history处理
          // var title = "上海3月开盘项目汇总-" + $(this).text().replace(/\d+$/, "");
          var title = this.id;
          document.title = title;
          if (event && /\d/.test(event.button)) {            
              history.pushState({ title: title }, title,  "?" + query);
          }
      }
      return false;
  });
  // var fnHashTrigger = function(target) {
  function fnHashTrigger(target) {
      var query = location.href.split("?")[1];
      var eleTarget = target || null;
      if (typeof query == "undefined") {
          if (eleTarget = eleMenus.get(0)) {
              // 如果没有查询字符，则使用第一个导航元素的查询字符内容
              history.replaceState(null, document.title, location.href.split("#")[0] + "?" + eleTarget.id) + location.hash;    
              fnHashTrigger(eleTarget);
          }
      } else {
          eleMenus.each(function() {
              if (eleTarget === null && this.id === query) {
                  eleTarget = this;
              }
          });
          
          if (!eleTarget) {
              // 如果查询序列没有对应的导航菜单，去除查询然后执行回调
              history.replaceState(null, document.title, location.href.split("?")[0]);    
              fnHashTrigger();
          } else {
              $(eleTarget).trigger("click");
          }        
      }    
  };
  if (history.pushState) {
      window.addEventListener("popstate", function() {
          fnHashTrigger();                             
      });
      
      // 默认载入
      fnHashTrigger();
  }

