
// 创建一条购买素材
function createJoMaterialOne1(id,mid,imgurl,name,time,tid){
  var joCommentBox = document.getElementById("mMain");
    var joMaterial = createEle("div", "joMaterial");
    joMaterial.id=id;
    $(joMaterial).attr("mid",""+id);
      var meImg = createEle("div", "meImg");
        var img = createEle("img","joMeImg");
        img.src=""+imgurl;
        img.width="40";
        img.height="40";
      addChilds(meImg, img);
      var meName = createEle("div","meName");
      meName.innerHTML=""+name;
      var meTime = createEle("div","meTime");
      meTime.innerHTML="时间："+time;
      var meJo = createEle("div","meJo");      
      meJo.innerHTML="出处"; 
      $(meJo).attr("tid",tid)
      $(meJo).click(function(e){
        gotoJoQ($(e.target).attr("tid"));
      })           
    addChilds(joMaterial,meImg,meName,meTime,meJo);
    var hr = document.createElement(hr);
  addChilds(joCommentBox, joMaterial,hr);
}

// 获取购买的素材列表
function getMaterialBuyList(currentPage1){
  var searchPath = $("#basePath").val()+"/purchase/buyList";
  var d={
      page:{currentPage:currentPage1},
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
        $.each(data, function(idx, obj) {
          var uid=obj.uid;
          var mid=obj.mid;
          var imgurl=obj.materialDto.imgurl;
          var time=obj.createtime;
          var name=obj.materialDto.name;
          var tid=obj.materialDto.tid;
          createJoMaterialOne1(uid,mid,imgurl,name,time,tid);
            // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
            if(idx==obj.page.pageNumber-1){
              var currentPage=obj.page.currentPage;
              var totalPage=obj.page.totalPage;
              createPage2(currentPage,totalPage,getMaterialBuyList);
            }
        })
      }
  })
}
// 创建一条卖出素材
function createJoMaterialOne2(id,mid,imgurl,name,time,tid,username,content){
  var joCommentBox = document.getElementById("mMain");
    var joMaterial = createEle("div", "joMaterial");
    joMaterial.id=id;
    $(joMaterial).attr("mid",""+id);
      var meImg = createEle("div", "meImg");
        var img = createEle("img","joMeImg");
        img.src=""+imgurl;
        img.width="40";
        img.height="40";
      addChilds(meImg, img);
      var meName = createEle("div","meName");
      meName.innerHTML=""+name;
      var meTime = createEle("div","meTime");
      meTime.innerHTML="时间："+time;
      var meJo = createEle("div","meJo");      
      meJo.innerHTML="出处";
      $(meJo).attr("tid",tid)
      $(meJo).click(function(e){
        gotoJoQ($(e.target).attr("tid"));
      }) 
      var meBuyer = createEle("div","meBuyer");
      meBuyer.innerHTML="购买者："+username;  
      var meContent = createEle("div","meContent");
      meBuyer.innerHTML="联系方式："+content;        
    addChilds(joMaterial,meImg,meName,meTime,meJo,meBuyer,meContent);
    var hr = document.createElement(hr);
  addChilds(joCommentBox, joMaterial,hr);
}
// 获取卖出的素材列表
function getMaterialSellList(currentPage1){
  var searchPath = $("#basePath").val()+"/purchase/sellList";
  var d={
      page:{currentPage:currentPage1},
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
        $.each(data, function(idx, obj) {
          var uid=obj.uid;
          var mid=obj.mid;
          var username=obj.username;
          var imgurl=obj.materialDto.imgurl;
          var time=obj.createtime;
          var name=obj.materialDto.name;
          var tid=obj.materialDto.tid;
          var content=obj.content;
          createJoMaterialOne2(uid,mid,imgurl,name,time,tid,username,content);
            // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
            if(idx==obj.page.pageNumber-1){
              var currentPage=obj.page.currentPage;
              var totalPage=obj.page.totalPage;
              createPage2(currentPage,totalPage,getMaterialSellList);
            }
        })
      }
  })
}

$(function(){
	getMaterialBuyList(1);
  $("#buyList").click(function(){

	  $("#buyList").addClass("m_left_select");
	  $("#sellList").removeClass("m_left_select");  
    clearAll("mMain");
    getMaterialBuyList(1);
  })
  $("#sellList").click(function(){
	  $("#buyList").removeClass("m_left_select");
	  $("#sellList").addClass("m_left_select"); 
    clearAll("mMain");
    getMaterialSellList(1);
  })
})

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