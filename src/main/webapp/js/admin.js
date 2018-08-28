// 页面初始停在好友动态
$(function(){
  var uid=$("#uid").val();
  getFri(uid,1);
  var tid=$("#tid").val();
  //判断是否有新公告
  isNewNotice();

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

// 左侧边栏
// 我的手账
$("#myHomepage").click(function(){
  $("#myHomepage").addClass("m_left_select");
  $("#myFriends").removeClass("m_left_select");  
  $("#atMe").removeClass("m_left_select");
  // 关闭小列表
  $("#atMeM").css("display","none");
  clearAll("mMain");
  // 发送请求获取我的手账
   var uid=$("#uid").val();
   getMy(uid,1);
});
// 好友动态
$("#myFriends").click(function(){
  $("#myFriends").addClass("m_left_select");
  $("#myHomepage").removeClass("m_left_select");  
  $("#atMe").removeClass("m_left_select");
  // 关闭小列表
  $("#atMeM").css("display","none");
//clearAll("mainContent");
  clearAll("mMain");
  // 发送请求,获取好友动态即关注者发的 
   var uid=$("#uid").val();
  getFri(uid,1);
  
  // 没服务器端测试用
    // var id="1";
    // var uid="u-1";
    // var headimgurl="../images/us_head.jpg";
    // var username="手账小达人";
    // var createtime="2018.02.03";
    // var tTitle="晒一晒自己的手账拼贴";
    // var content="17年的本子，话唠的我在用后面的点阵页做测试~练一练字体大小，省的明年面对A6小可爱无从下笔~手账小白不敢一下子就入A5的本子，那么大怕用不来~话说为啥没有A5.5呢，太好奇了，就没有人主动开发一个尺寸适中的手帐本吗空间规划科技示范户刷卡机合肥市发生的回复康师傅康师傅世界喊辅导费苏杭的飞速发货苏护发素法华寺复活".substring(0,111)+"...";
    // var imgsurl="../images/shouzhang.jpg";
    // var commentNum="12";
    // var thumbupNum="45";
    // var collectionNum="452";
    // var currentPage=1;
    // var totalPage=5;


    // createFri();
    // createFriOne(id,uid,headimgurl,username,createtime,tTitle,content,imgsurl,commentNum,thumbupNum,collectionNum);
    // createPage(uid,currentPage,totalPage);
});
// 与我相关
$("#atMe").click(function(){
  $("#atMe").addClass("m_left_select");
  $("#myHomepage").removeClass("m_left_select");  
  $("#myFriends").removeClass("m_left_select");
  // 展开小列表
 $("#atMeM").css("display","block");
//clearAll("mainContent");
 clearAll("mMain");
  getCommentA(1);
});

// 评论
$("#comment").click(function(){
  $("#comment").html("√&nbsp;&nbsp;评论");
  $("#thumbup").html("赞");
  $("#collect").html("收藏");
  $("#fans").html("粉丝");
//clearAll("mainContent");
  clearAll("mMain");
  // 请求评论列表
  getCommentA(1);
})
$("#mMain").on("click","#cActive",function(){
  clearAll("mainContent");
  // 请求评论列表
  getCommentA(1);
})
$("#mMain").on("click","#cPassive",function(){
  clearAll("mainContent");
  // 请求评论列表
  getCommentP(1);
})
// 赞
$("#thumbup").click(function(){
  $("#comment").html("评论");
  $("#thumbup").html("√&nbsp;&nbsp;赞");
  $("#collect").html("收藏");
  $("#fans").html("粉丝");
//clearAll("mainContent");
  clearAll("mMain");
  // 请求赞列表
  getThumbupA(1);
})
$("#mMain").on("click","#tActive",function(){
	clearAll("mainContent");
	// 请求赞列表
	getThumbupA(1);
  });

$("#mMain").on("click","#tPassive",function(){
  clearAll("mainContent");
  // 请求赞列表
  getThumbupP(1);
})
// 收藏
$("#collect").click(function(){
  $("#comment").html("评论");
  $("#thumbup").html("赞");
  $("#collect").html("√&nbsp;&nbsp;收藏");
  $("#fans").html("粉丝");
//  clearAll("mainContent");
  clearAll("mMain");
  // 请求收藏列表
  getCollectA(1);
})
$("#mMain").on("click","#crActive",function(){
  clearAll("mainContent");
  // 请求评论列表
  getCollectA(1);
})
$("#mMain").on("click","#crPassive",function(){
  clearAll("mainContent");
  // 请求评论列表
  getCollectP(1);
})
// 粉丝
$("#fans").click(function(){
  $("#comment").html("评论");
  $("#thumbup").html("赞");
  $("#collect").html("收藏");
  $("#fans").html("√&nbsp;&nbsp;粉丝");
//  clearAll("mainContent");
  clearAll("mMain");
  // 请求粉丝列表 
   var uid=$("#uid").val();
  getFansA(uid,1);
})
$("#mMain").on("click","#fActive",function(){
  clearAll("mainContent");
  // 请求粉丝列表 
   var uid=$("#uid").val();
  getFansA(uid,1);
})
$("#mMain").on("click","#fPassive",function(){
  clearAll("mainContent");
  // 请求关注列表 
   var uid=$("#uid").val();
  getFansP(uid,1);
})

// handle层交互
// 评论
$("#mMain").on("click","#joComment",function(e){   
    var tid=$(e.target).parent().attr("id");
    commentQ(tid);      
  })
//var comment= $("div [id=joComment]");
//for(var i=0;i<comment.length;i++){
//  $(comment[i]).click(function(e){   
//    var tid=$(e.target).parent().attr("id");
//    commentQ(tid);      
//  })
//}



// 赞
$("#mMain").on("click","#joThumbup",function(e){   
    var tid=$(e.target).parent().attr("id");
    aThumbupQ(tid);    
  })

// 收藏
$("#mMain").on("click","#joCollect",function(e){    
    var tid=$(e.target).parent().attr("id");
    aCollectQ(tid);    
  })

// 素材获取
$("#mMain").on("click","#materialQ",function(e){   
    var tid=$(e.target).parent().attr("id");
    materialQ(tid);      
  })

// 删除
$("#mMain").on("click","#joDelete",function(e){   
    var tid=$(e.target).parent().attr("id");
    joDeleteQ(uid,tid);   
  })
// 删除
$("#mMain").on("click","#cDetele",function(e){   
    var id=$(e.target).parent().attr("tid");
    coDeleteQ(id);   
  })
// 取消赞
$("#mMain").on("click","#tThumbup",function(e){   
    var id=$(e.target).parent().attr("tid");
    tThumbupQ(id);   
  })
// 取消收藏
$("#mMain").on("click","#cCollect",function(e){   
    var id=$(e.target).parent().attr("tid");
    cCollectQ(id);   
  })





// 界面跳转

// 我的手账
$("#mMain").on("click",".co_art_title",function(e){    
    var tid=$(e.target).attr("id");
    gotoJoQ(tid);      
  })

// 好友动态
// 用户
$("#mMain").on("click",".info",function(e){     
    var id=$(e.target).attr("uid");
    gotoUserQ(id);      
  })
// 手账
$("#mMain").on("click",".co_art_title",function(e){
	var tid=$(e.target).attr("id");
    gotoJoQ(tid);      
  })
$("#mMain").on("click","#material",function(e){   
    var tid=$(e.target).parent().attr("id");
    materialQ(tid);      
  })

$("#mMain").on("click",".co_art_title",function(e){ 
    var tid=$(e.target).attr("id");
    gotoJoQ(tid);      
  })
})

  //   var eleMenus = $("#m_left div").bind("click", function(event) {
  //     // var query = this.href.split("?")[1];
  //     var query = this.id;
  //     if (history.pushState && query && !$(this).hasClass("m_left_select")) {
  //         /*
  //             ajax载入~~
  //         */
          
  //         // history处理
  //         // var title = "上海3月开盘项目汇总-" + $(this).text().replace(/\d+$/, "");
  //         var title = this.id;
  //         document.title = title;
  //         if (event && /\d/.test(event.button)) {            
  //             history.pushState({ title: title }, title,  "?" + query);
  //         }
  //     }
  //     return false;
  // });
  // // var fnHashTrigger = function(target) {
  // function fnHashTrigger(target) {
  //     var query = location.href.split("?")[1];
  //     var eleTarget = target || null;
  //     if (typeof query == "undefined") {
  //         if (eleTarget = eleMenus.get(0)) {
  //             // 如果没有查询字符，则使用第一个导航元素的查询字符内容
  //             history.replaceState(null, document.title, location.href.split("#")[0] + "?" + eleTarget.id) + location.hash;    
  //             fnHashTrigger(eleTarget);
  //         }
  //     } else {
  //         eleMenus.each(function() {
  //             if (eleTarget === null && this.id === query) {
  //                 eleTarget = this;
  //             }
  //         });
          
  //         if (!eleTarget) {
  //             // 如果查询序列没有对应的导航菜单，去除查询然后执行回调
  //             history.replaceState(null, document.title, location.href.split("?")[0]);    
  //             fnHashTrigger();
  //         } else {
  //             $(eleTarget).trigger("click");
  //         }        
  //     }    
  // };
  // if (history.pushState) {
  //     window.addEventListener("popstate", function() {
  //         fnHashTrigger();                             
  //     });
      
  //     // 默认载入
  //     fnHashTrigger();
  // }


