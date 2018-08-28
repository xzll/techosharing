var tid=$("#tid").val();
  var area=$("#area").val();
$(function(){ 
  var searchPath = $("#basePath").val()+"/techo/search/"+tid;
  $.ajax({
    headers: { 
          'Accept': 'application/json',
          'Content-Type': 'application/json' 
      },
      async:false,
     contentType: 'application/json',
      type:"get",
      url:searchPath,
      contentType:"application/json;charset=utf-8",
      data:"",
      success:function (data) {
          var title=data.title;
          var author=data.username;
          var time=data.time;
          var content=data.content;
          var imgsurl=data.imgsurl;
          var commentNum=data.commentNum;
          var thumbupNum=data.thumbupNum;
          var collectionNum=data.collectionNum;
          createJo(tid,title,author,time,content,imgsurl,commentNum,thumbupNum,collectionNum); 
      }
  })
//评论头像获取
  var uid=$("#uid").val();
  var headimg = Qheadimg(uid);
  $(".coHeadimg").attr("src",headimg);


})
function createJo(tid,title,author,time,content,imgsurl,commentNum,thumbupNum,collectionNum){
  $("#joTitle").html(title);
  $("#joAuthor").html("作者"+author);//最好有个链接去用户界面
  $("#joTime").html(time);
  $("#joContent").html(content);
  var joImages=document.getElementById("joImages");
  for(var i=0;i<imgsurl.length;i++){
    var joImgI = createEle("img");
    joImgI.src=""+imgsurl[i];
    joImgI.width="300";
    addChilds(joImages, joImgI);
  }
  // 评论
  var joHaComment= $("#joHaComment");
  joHaComment.html("评论&nbsp;"+commentNum+"&nbsp;&nbsp;");
  joHaComment.click(function(e){   
	  clearAll("joCommentBox"); 
    getCommentList(tid,1);      
  })
  // 收藏
  var joHaThumbup= $("#joHaThumbup");
  joHaThumbup.html("赞&nbsp;"+thumbupNum+"&nbsp;&nbsp;");
  joHaThumbup.click(function(e){ 
     
    var con=$(e.target).html();
    if(con[0]=="赞"){
    aThumbupQ(tid);
    }else{
      dThumbupQ(tid);
    }     
  })
  // 收藏
  var joHaCollect= $("#joHaCollect");
  joHaCollect.html("收藏&nbsp;"+collectionNum+"&nbsp;&nbsp;");
  joHaCollect.click(function(e){ 
     
    var con=$(e.target).html();
    if(con[0]=="收"){
      aCollectQ(tid);
    }else{
      aCollectQ(tid);
    }     
  })
  // 素材获取
  $("#joHaMaterial").html("素材获取&nbsp;&nbsp;");
    var joHaMaterial= $("#joHaMaterial");
    joHaMaterial.click(function(e){  
    	clearAll("joCommentBox");  
      getMaterialList(tid,1);    
    })  
  // 提交评论
  $("#addC").click(function(){
    subComment(tid);
  })
  if(area==1){
    // 获取评论列表
  getCommentList(tid,1);
  }
  else if(area==2){
    getMaterialList(tid,1);
  }
  
}




// 手账下：获取评论列表
function getCommentList(tid,currentPage1){
  var searchPath = $("#basePath").val()+"/comment/list/techo";
  var userInfoPath = $("#basePath").val()+"/user/show";
  var d={
      page:{currentPage:currentPage1},
      tid:tid
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
          var id=obj.id;
          var uid=obj.uid;
          var a={id:uid}
          var headimgurl="";
          $.ajax({
              contentType: 'application/json',
                type:"post",
                url:userInfoPath,
                async:false,
                contentType:"application/json;charset=utf-8",
                data:JSON.stringify(a),
                success:function(data){
                  headimgurl=data.headimgurl;
                }
            });
            var username=obj.username;
            var createtime=obj.createtime;
            var coContent=obj.content;
            createJoCommentOne(id,uid,headimgurl,username,createtime,coContent);
            // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
            if(idx==obj.page.pageNumber-1){
              var currentPage=obj.page.currentPage;
              var totalPage=obj.page.totalPage;
              createPage4(tid,currentPage,totalPage,getCommentList);
            }
        })
      }
  })
}
// 手账下：创建一条评论
function createJoCommentOne(id,uid,headimgurl,username,createtime,coContent) {
  var joCommentBox = document.getElementById("joCommentBox");
    var joComment = createEle("div", "jo"+id);
    joComment.id="co-"+id;
    $(joComment).attr("tid",""+id);
      var joInfo = createEle("div", "joInfo");
      joInfo.id="u-"+id ;
      joInfo.uid=""+uid;
        var head = createEle("div","joIn_head");
          var img = createEle("img","joIn_head_image");
          img.src=""+headimgurl;
          img.width="40";
          img.height="40";
        addChilds(head, img);
        var text = createEle("div","joIin_text","rlt");
          var name=createEle("div","joIin_name");
          name.innerHTML=""+username;
          var data=createEle("div","joIin_data");
          data.innerHTML=""+createtime;
        addChilds(text, name,data);
      addChilds(joInfo, head,text);
      var commentCo = createEle("div", "joCommentCo");
      commentCo.innerHTML=""+coContent;
            
    addChilds(joComment,joInfo,commentCo);
  addChilds(joCommentBox, joComment);
}

function createJoMaterialTitle(){
  var joMeTitle=createEle("div","joMeTitle");
  joMeTitle.innerHTML="素材列表";
  var hr1 = document.createElement(hr);
}
// 手账下：创建一条素材
function createJoMaterialOne(mid,imgurl,name,price,number){
  var joCommentBox = document.getElementById("joCommentBox");
    var joMaterial = createEle("div", "joMaterial");
    joMaterial.id="me-"+mid;
    $(joMaterial).attr("mid",""+mid);
      var meImg = createEle("div", "meImg");
        var img = createEle("img","joMeImg");
        img.src=""+imgurl;
        img.width="40";
        img.height="40";
      addChilds(meImg, img);
      var meName = createEle("div","meName");
      meName.innerHTML=""+name;
      var meStock = createEle("div","meStock");
      meStock.innerHTML="数量："+number;
      var mePrice = createEle("div","mePrice");
      mePrice.innerHTML="￥&nbsp;"+price;
      var buyBtn = createEle("div","buyBtn");
      buyBtn.innerHTML="购买"; 
      $(buyBtn).click(function(){
        mePurchase(mid);
      })           
    addChilds(joMaterial,meImg,meName,meStock,mePrice,buyBtn);
  addChilds(joCommentBox, joMaterial);
}
// 购买请求
function mePurchase(id){
  var path=$("#basePath").val()+"/purchase/add";
  var d={
      mid:id
  };
  $.ajax({
    headers: { 
          'Accept': 'application/json',
          'Content-Type': 'application/json' 
      },
      async:false,
     contentType: 'application/json',
      type:"post",
      url:path,
      contentType:"application/json;charset=utf-8",
      data:JSON.stringify(d),
      success:function (data) {
        alert(data.msg);
    	clearAll("joCommentBox"); 
        getMaterialList(tid,currentPage1); 
      }
  })
}

// 手账下：获取素材列表
function getMaterialList(tid,currentPage1){
  var searchPath = $("#basePath").val()+"/material/list";
  var userInfoPath = $("#basePath").val()+"/user/show";
  var d={
      page:{currentPage:currentPage1},
      tid:tid
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
          var mid=obj.id;
          var imgurl=obj.imgurl;
          var name=obj.name;
          var price=obj.price;
          var number=obj.number;
          createJoMaterialOne(mid,imgurl,name,price,number)
            // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
            if(idx==obj.page.pageNumber-1){
              var currentPage=obj.page.currentPage;
              var totalPage=obj.page.totalPage;
              createPage3(tid,currentPage,totalPage,getMaterialList);
            }
        })
      }
  })
}

function subComment(tid){
  var comment = $("#subComment").val();
  var path = $("#basePath").val()+"/comment/add";
  var d={
      content:comment,
      tid:tid
  }
  $.ajax({
    headers: { 
          'Accept': 'application/json',
          'Content-Type': 'application/json' 
      },
      async:false,
     contentType: 'application/json',
      type:"post",
      url:path,
      contentType:"application/json;charset=utf-8",
      data:JSON.stringify(d),
      success:function (data) {
        if(data){
        	clearAll("joCommentBox");
          getCommentList(tid,1);
          alert("评论成功");
        }
        else{
          alert("评论失败，请重试");
        }
      }
  })

}