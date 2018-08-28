// 页面初始停在好友动态
$(function(){
  var uid=$("#uid").val();
  var tid=$("#tid").val();
  var hid=$("#hid").val();
  clearAll("mMain");
  findHis(hid);
  getHis(hid,1);
//  个人资料获取
  $(function(){
	    var userInfoPath = $("#basePath").val()+"/user/show";
		var a={id:hid}
		$.ajax({
		    contentType: 'application/json',
		      type:"post",
		      url:userInfoPath,
		      async:false,
		      contentType:"application/json;charset=utf-8",
		      data:JSON.stringify(a),
		      success:function(data){
		        var headimgurl=data.headimgurl;
		        var username = data.username.substring(0,8);
		    	$("#nInHeadImage").attr("src",headimgurl);
		    	$("#mInName").html(username);	        
		      }
		  });
	})
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

// 个人信息


// 左侧边栏
/*//个人资料
perInfo
$("#perInfo").click(function(){
	$("#perInfo").addClass("m_left_select");
	  $("#hisHomepage").removeClass("m_left_select");
	  $("#hisFans").removeClass("m_left_select");  
	
});*/
// 他的手账
$("#hisHomepage").click(function(){
  $("#hisHomepage").addClass("m_left_select");
  $("#hisFans").removeClass("m_left_select");  
  $("#perInfo").removeClass("m_left_select");
  clearAll("mMain");
  // 发送请求获取ta的手账
   var hid=$("#hid").val();
   getHis(hid,1);
});

// 粉丝
$("#hisFans").click(function(){
  $("#hisHomepage").removeClass("m_left_select");
  $("#hisFans").addClass("m_left_select");
  $("#perInfo").removeClass("m_left_select");
  clearAll("mMain");
  // 请求粉丝列表
  var hid=$("#hid").val();
  getFansA(hid,1);
})
$("#mMain").on("click","#fActive",function(){
  clearAll("mainContent");
  // 请求粉丝列表 
   var hid=$("#hid").val();
  getFansA(hid,1);
})
$("#mMain").on("click","#fPassive",function(){
  clearAll("mainContent");
  // 请求关注列表 
   var hid=$("#hid").val();
  getFansP(hid,1);
})
// handle层交互
// 评论
var comment= $("div [id=joComment]");
for(var i=0;i<comment.length;i++){
  $(comment[i]).click(function(e){   
    var tid=$(e.target).parent().attr("id");
    commentQ(tid);      
  })
}
// 赞
var thumbup= $("div [id=thumbup]");
for(var i=0;i<thumbup.length;i++){
  $(thumbup[i]).click(function(e){   
    var tid=$(e.target).parent().attr("id");
    var con=$(e.target).html();
    if(con[0]=="赞"){
    aThumbupQ(tid);
    }else{
      dThumbupQ(tid);
    }    
  })
}

// 收藏
var collect= $("div [id=collect]");
for(var i=0;i<collect.length;i++){
  $(collect[i]).click(function(e){   
    var tid=$(e.target).parent().attr("id");
    var con=$(e.target).html();
    if(con[0]=="收"){
    aCollectQ(tid);
    }else{
      dCollectQ(tid);
    }    
  })
}

// 素材获取
var materialQ= $("div [id=materialQ]");
for(var i=0;i<materialQ.length;i++){
  $(materialQ[i]).click(function(e){   
    var tid=$(e.target).parent().attr("id");
    materialQ(tid);      
  })
}
// 界面跳转

// 我的手账
// var my= $("section");
// for(var i=0;i<my.length;i++){
//   $(my[i]).click(function(e){   
//     var tid=$(e.target).attr("tid");
//     gotoJoQ(tid);      
//   })
// }
// 好友动态
// 用户
var info= $("div [id=info]");
for(var i=0;i<info.length;i++){
  $(info[i]).click(function(e){   
    var uid=$(e.target).attr("uid");
    gotoUserQ(uid);      
  })
}
// 手账
var friArticle= $("div [id=friArticle]");
for(var i=0;i<friArticle.length;i++){
  $(friArticle[i]).click(function(e){   
    var tid=$(e.target).parent().attr("tid");
    gotoJoOQ(tid);      
  })
}


var article= $("div [id=article]");
for(var i=0;i<article.length;i++){
  $(article[i]).click(function(e){   
    var tid=$(e.target).parent().attr("tid");
    gotoJoOQ(tid);      
  })
}
})
//请求关注
function faned(id){
  var searchPath = $("#basePath").val()+"/fan/add";
  var d={
	  uid:id
  }
  $.ajax({
  
  headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    async:false,
   contentType: 'application/json',
    type:"post",
    url:searchPath,
    contentType:"application/json;charset=utf-8",
    data:JSON.stringify(d),
    success:function (data) {
    	if(data.code==1700){
    		alert("关注成功");
    	}else{
    		alert("已关注，无须重复关注");
    	}
    }
  })
}