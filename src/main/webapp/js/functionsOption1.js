/**
 * [emptyTips 非空校验]
 * @param  {[type]} val  [description]
 * @param  {[type]} name [description]
 * @return {[type]}      [description]
 */
function emptyTips(val,name){
  if(val=="undefine"){
    alert(name+"不能为空");
  }
}
/**
 * [createPage 创建分页1]
 * @param  {[type]} currentPage [当前所在分页]
 * @param  {[type]} totalPage   [总分页数]
 * @return {[type]}             [description]
 */
function createPage1( uid,currentPage,totalPage,fun){
  var Mcontent = document.getElementById("mainContent");
  var pageBox = createEle("div", "pageBox");
  for(var i=1;i<=totalPage;i++){
    var page = createEle("div", "page");
    page.id = "page"+i;
    page.innerHTML=i;
    $(page).attr("currentPage",i);
    $(page).click(function(){
      fun(uid,i);
    })
    addChilds(pageBox,page);
  }
  addChilds(Mcontent,pageBox);
  $("#page"+currentPage).addClass("page_select");
  }
  /**
 * [createPage 创建分页2]
 * @param  {[type]} currentPage [当前所在分页]
 * @param  {[type]} totalPage   [总分页数]
 * @return {[type]}             [description]
 */
function createPage2( who,uid,currentPage,totalPage,fun){
  var Mcontent = document.getElementById("mainContent");
  var pageBox = createEle("div", "pageBox");
  for(var i=1;i<=totalPage;i++){
    var page = createEle("div", "page");
    page.id = "page"+i;
    page.innerHTML=i;
    $(page).attr("currentPage",i);
    $(page).click(function(){
      fun(who,i);
    })
    addChilds(pageBox,page);
  }
  addChilds(Mcontent,pageBox);
  $("#page"+currentPage).addClass("page_select");
  }
  /**
 * [createPage 创建分页2]
 * @param  {[type]} currentPage [当前所在分页]
 * @param  {[type]} totalPage   [总分页数]
 * @return {[type]}             [description]
 */
function createPage3( who,uid,currentPage,totalPage,fun){
  var Mcontent = document.getElementById("mainContent");
  var pageBox = createEle("div", "pageBox");
  for(var i=1;i<=totalPage;i++){
    var page = createEle("div", "page");
    page.id = "page"+i;
    page.innerHTML=i;
    $(page).attr("currentPage",i);
    $(page).click(function(){
      fun(who,uid,i);
    })
    addChilds(pageBox,page);
  }
  addChilds(Mcontent,pageBox);
  $("#page"+currentPage).addClass("page_select");
  }
/**
 * [createMy 创建标题“我的手账”]
 * @return {[type]} [description]
 */
function createMy() {
  var main = document.getElementById("mMain");
    var title = createEle("div", "main_tit", "rlt");
    title.id="mainTit";
    title.innerHTML="我的手账";
    var content = createEle("div", "main_content", "rlt"); 
    content.id="mainContent"
  addChilds(main, title,content);
}
/**
 * [createMyOne 创建一条我的手账]
 */
function createMyOne(id,uid,headimgurl,username,createtime,tTitle,content,imgsurl,commentNum,thumbupNum,collectionNum) {
  var Mcontent = document.getElementById("mainContent");
    var section = createEle("section", "jo"+id);
    section.id="jo-"+id;
    $(section).attr("data-id",""+id);
      var info = createEle("div", "info");
      info.id="u-"+id ;
      info.uid=""+id;
        var head = createEle("div","in_head");
          var img = createEle("img","in_head_image");
          img.src=""+headimgurl;
          img.width="50";
          img.height="50";
        addChilds(head, img);
        var text = createEle("div","in_text","rlt");
          var name=createEle("div","in_name");
          name.innerHTML=""+username;
          var data=createEle("div","in_data");
          data.innerHTML=""+createtime;
        addChilds(text, name,data);
      addChilds(info, head,text);
      var article = createEle("div", "co_article");
        var artText = createEle("div", "co_art_text");
          var artTitle = createEle("div", "co_art_title");
          artTitle.innerHTML=""+tTitle
          var artContent = createEle("div", "co_art_content");
          artContent.innerHTML=""+content;
          var artImg = createEle("div", "co_art_img");
            var artImgI = createEle("img");
            if(imgsurl){
              artImgI.src=""+imgsurl[0];
            }
            artImgI.width="100";
            artImgI.height="100";
          addChilds(artImg, artImgI);
        addChilds(artText, artTitle,artContent,artImg);
      addChilds(article, artText);
      var handle = createEle("div", "co_handle");
        var hr = createEle("hr");
        var comment = createEle("div", "comment");
        comment.id="comment";
        comment.innerHTML="评论"+commentNum+"&nbsp;&nbsp;";
        var collect = createEle("div", "collect");
        collect.id="collect";
        collect.innerHTML="收藏"+collectionNum+"&nbsp;&nbsp;";
        var thumbup = createEle("div", "thumbup");
        thumbup.id="thumbup";
        thumbup.innerHTML="赞"+thumbupNum+"&nbsp;&nbsp;";
        var joDelete = createEle("div", "joDelete");
        joDelete.id="joDelete";
        joDelete.innerHTML="删除";
      addChilds(handle, hr,comment,collect,thumbup,joDelete);
    addChilds(section,info,article,handle);
  addChilds(Mcontent, section);
}
/**
 * [createFri 创建标题“好友动态”]
 * @return {[type]} [description]
 */
function createFri() {
  var main = document.getElementById("mMain");
    var title = createEle("div", "main_tit", "rlt");
    title.id="mainTit";
    title.innerHTML="好友动态";
    var content = createEle("div", "main_content", "rlt"); 
    content.id="mainContent"
  addChilds(main, title,content);
}
/**
 * [createFriOne 创建一条好友动态]
 */
function createFriOne(id,uid,headimgurl,username,createtime,tTitle,content,imgsurl,commentNum,thumbupNum,collectionNum) {
  var Mcontent = document.getElementById("mainContent");
    var section = createEle("section", "jo"+id);
    section.id="jo-"+id;
    $(section).attr("data-id",""+id);
      var info = createEle("div", "info");
      info.id="u-"+id ;
      info.uid=""+id;
        var head = createEle("div","in_head");
          var img = createEle("img","in_head_image");
          img.src=""+headimgurl;
          img.width="50";
          img.height="50";
        addChilds(head, img);
        var text = createEle("div","in_text","rlt");
          var name=createEle("div","in_name");
          name.innerHTML=""+username;
          var data=createEle("div","in_data");
          data.innerHTML=""+createtime;
        addChilds(text, name,data);
      addChilds(info, head,text);
      var article = createEle("div", "co_article");
        var artText = createEle("div", "co_art_text");
          var artTitle = createEle("div", "co_art_title");
          artTitle.innerHTML=""+tTitle
          var artContent = createEle("div", "co_art_content");
          artContent.innerHTML=""+content;
          var artImg = createEle("div", "co_art_img");
            var artImgI = createEle("img");
            if(imgsurl){
              artImgI.src=""+imgsurl[0];
            }
            artImgI.width="100";
            artImgI.height="100";
          addChilds(artImg, artImgI);
        addChilds(artText, artTitle,artContent,artImg);
      addChilds(article, artText);
      var handle = createEle("div", "co_handle");
        var hr = createEle("hr");
        var comment = createEle("div", "comment");
        comment.id="comment";
        comment.innerHTML="评论"+commentNum+"&nbsp;&nbsp;";
        var collect = createEle("div", "collect");
        collect.id="collect";
        collect.innerHTML="收藏"+collectionNum+"&nbsp;&nbsp;";
        var thumbup = createEle("div", "thumbup");
        thumbup.id="thumbup";
        thumbup.innerHTML="赞"+thumbupNum+"&nbsp;&nbsp;";
        var material = createEle("div", "material");
        material.id="material";
        material.innerHTML="素材获取";
      addChilds(handle, hr,comment,collect,thumbup,material);
    addChilds(section,info,article,handle);
  addChilds(Mcontent, section);
}
/**
 * [createComment 创建标题：评论]
 * @return {[type]} [description]
 */
function createComment() {
  var main = document.getElementById("mMain");
    var title = createEle("div", "main_tit", "rlt");
    title.id="mainTit";
      var cActive = createEle("div", "active");
      cActive.id="cActive";
      cActive.innerHTML="发出的评论";
      var cPassive = createEle("div", "passive");
      cPassive.id="cPassive";
      cPassive.innerHTML="收到的评论";
      addChilds(title, cActive,cPassive);
    var content = createEle("div", "main_content", "comment_box","rlt"); 
    content.id="mainContent"
  addChilds(main, title,content);
}

/**
 * [createCommentOne 获取一条评论]
 *
 * uid headimgurl username createtime coContent指发出评论的人
 * tUsername 指代被评论的人
 * @param  {[type]} id            [description]
 * @param  {[type]} uid           [description]
 * @param  {[type]} headimgurl    [description]
 * @param  {[type]} username      [description]
 * @param  {[type]} createtime    [description]
 * @param  {[type]} content       [description]
 * @param  {[type]} tUsername     [description]
 */
function createCommentOne(id,uid,headimgurl,username,createtime,coContent,tUsername,tTitle,content,imgsurl) {
  var Mcontent = document.getElementById("mainContent");
    var section = createEle("section", "jo"+id);
    section.id="jo-"+id;
    $(section).attr("data-id",""+id);
      var info = createEle("div", "info");
      info.id="u-"+id ;
      info.uid=""+id;
        var head = createEle("div","in_head");
          var img = createEle("img","in_head_image");
          img.src=""+headimgurl;
          img.width="50";
          img.height="50";
        addChilds(head, img);
        var text = createEle("div","in_text","rlt");
          var name=createEle("div","in_name");
          name.innerHTML=""+username;
          var data=createEle("div","in_data");
          data.innerHTML=""+createtime;
        addChilds(text, name,data);
      addChilds(info, head,text);
      var commentCo = createEle("div", "commentCo");
      commentCo.innerHTML=""+coContent;
      var article = createEle("div", "co_article");
        var artText = createEle("div", "co_art_text");
          var artTitle = createEle("div", "co_art_title");
          artTitle.innerHTML="@"+tUsername+"；"+tTitle
          var artContent = createEle("div", "co_art_content");
          artContent.innerHTML=""+content;
          var artImg = createEle("div", "co_art_img");
            var artImgI = createEle("img");
            if(imgsurl){
              artImgI.src=""+imgsurl[0];
            }
            artImgI.width="100";
            artImgI.height="100";
          addChilds(artImg, artImgI);
        addChilds(artText, artTitle,artContent,artImg);
      addChilds(article, artText);      
    addChilds(section,info,commentCo,article);
  addChilds(Mcontent, section);
}
/**
 * [createThumbup 创建标题：赞]
 * @return {[type]} [description]
 */
function createThumbup() {
  var main = document.getElementById("mMain");
    var title = createEle("div", "main_tit", "rlt");
    title.id="mainTit";
      var tActive = createEle("div", "active");
      tActive.id="tActive";
      tActive.innerHTML="我赞了谁";
      var tPassive = createEle("div", "passive");
      tPassive.id="tPassive";
      tPassive.innerHTML="谁赞了我";
      addChilds(title, tActive,tPassive);
    var content = createEle("div", "main_content", "thumbup_box","rlt"); 
    content.id="mainContent"
  addChilds(main, title,content);
}
/**
 * [createThumbupOne 获取一条赞]
 *
 * uid headimgurl username createtime coContent指发出赞的人
 * tUsername 指代被赞的人
 * @param  {[type]} id            [description]
 * @param  {[type]} uid           [description]
 * @param  {[type]} headimgurl    [description]
 * @param  {[type]} username      [description]
 * @param  {[type]} createtime    [description]
 * @param  {[type]} content       [description]
 * @param  {[type]} tUsername     [description]
 */
function createThumbupOne(id,uid,headimgurl,username,createtime,tUsername,tTitle,content,imgsurl) {
  var Mcontent = document.getElementById("mainContent");
    var section = createEle("section", "jo"+id);
    section.id="jo-"+id;
    $(section).attr("data-id",""+id);
      var info = createEle("div", "info");
      info.id="u-"+id ;
      info.uid=""+id;
        var head = createEle("div","in_head");
          var img = createEle("img","in_head_image");
          img.src=""+headimgurl;
          img.width="50";
          img.height="50";
        addChilds(head, img);
        var text = createEle("div","in_text","rlt");
          var name=createEle("div","in_name");
          name.innerHTML=""+username;
          var data=createEle("div","in_data");
          data.innerHTML=""+createtime;
        addChilds(text, name,data);
      addChilds(info, head,text);
      var article = createEle("div", "co_article");
        var artText = createEle("div", "co_art_text");
          var artTitle = createEle("div", "co_art_title");
          artTitle.innerHTML="@"+tUsername+"；"+tTitle
          var artContent = createEle("div", "co_art_content");
          artContent.innerHTML=""+content;
          var artImg = createEle("div", "co_art_img");
            var artImgI = createEle("img");
            if(imgsurl){
              artImgI.src=""+imgsurl[0];
            }
            artImgI.width="100";
            artImgI.height="100";
          addChilds(artImg, artImgI);
        addChilds(artText, artTitle,artContent,artImg);
      addChilds(article, artText);      
    addChilds(section,info,article);
  addChilds(Mcontent, section);
}

/**
 * [createCollect 创建标题：收藏]
 * @return {[type]} [description]
 */
function createCollect() {
  var main = document.getElementById("mMain");
    var title = createEle("div", "main_tit", "rlt");
    title.id="mainTit";
      var crActive = createEle("div", "active");
      crActive.id="crActive";
      crActive.innerHTML="我的收藏";
      var crPassive = createEle("div", "passive");
      crPassive.id="crPassive";
      crPassive.innerHTML="我被收藏";
      addChilds(title, crActive,crPassive);
    var content = createEle("div", "main_content", "collect_box","rlt"); 
    content.id="mainContent"
  addChilds(main, title,content);
}
/**
 * [createCollectOne 获取一条收藏]
 *
 * uid headimgurl username createtime coContent指发出赞的人
 * tUsername 指代被赞的人
 * @param  {[type]} id            [description]
 * @param  {[type]} uid           [description]
 * @param  {[type]} headimgurl    [description]
 * @param  {[type]} username      [description]
 * @param  {[type]} createtime    [description]
 * @param  {[type]} content       [description]
 * @param  {[type]} tUsername     [description]
 */
function createCollectOne(id,uid,headimgurl,username,createtime,tUsername,tTitle,content,imgsurl) {
  var Mcontent = document.getElementById("mainContent");
    var section = createEle("section", "jo"+id);
    section.id="jo-"+id;
    $(section).attr("data-id",""+id);
      var info = createEle("div", "info");
      info.id="u-"+id ;
      info.uid=""+id;
        var head = createEle("div","in_head");
          var img = createEle("img","in_head_image");
          img.src=""+headimgurl;
          img.width="50";
          img.height="50";
        addChilds(head, img);
        var text = createEle("div","in_text","rlt");
          var name=createEle("div","in_name");
          name.innerHTML=""+username;
          var data=createEle("div","in_data");
          data.innerHTML=""+createtime;
        addChilds(text, name,data);
      addChilds(info, head,text);
      var article = createEle("div", "co_article");
        var artText = createEle("div", "co_art_text");
          var artTitle = createEle("div", "co_art_title");
          artTitle.innerHTML="@"+tUsername+"；"+tTitle
          var artContent = createEle("div", "co_art_content");
          artContent.innerHTML=""+content;
          var artImg = createEle("div", "co_art_img");
            var artImgI = createEle("img");
            if(imgsurl){
              artImgI.src=""+imgsurl[0];
            }
            artImgI.width="100";
            artImgI.height="100";
          addChilds(artImg, artImgI);
        addChilds(artText, artTitle,artContent,artImg);
      addChilds(article, artText);      
    addChilds(section,info,article);
  addChilds(Mcontent, section);
}



/**
 * [createFans 创建标题：粉丝]
 * @return {[type]} [description]
 */
function createFans() {
  var main = document.getElementById("mMain");
    var title = createEle("div", "main_tit", "rlt");
    title.id="mainTit";
      var fActive = createEle("div", "active");
      fActive.id="fActive";
      fActive.innerHTML="我的关注";
      var fPassive = createEle("div", "passive");
      fPassive.id="fPassive";
      fPassive.innerHTML="我的粉丝";
      addChilds(title, fActive,fPassive);
    var content = createEle("div", "main_content", "fans_box","rlt"); 
    content.id="mainContent"
  addChilds(main, title,content);
}
/**
 * [createFansOne 获取一条粉丝信息]
 */
function createFansOne(id,uid,headimgurl,username) {
  var Mcontent = document.getElementById("mainContent");
    var section = createEle("section", "jo"+id);
    section.id="jo-"+id;
    $(section).attr("data-id",""+id);
      var info = createEle("div", "info");
      info.id="u-"+id ;
      info.uid=""+id;
        var head = createEle("div","in_head");
          var img = createEle("img","in_head_image");
          img.src=""+headimgurl;
          img.width="50";
          img.height="50";
        addChilds(head, img);
        var text = createEle("div","in_text","rlt");
          var name=createEle("div","in_name");
          name.innerHTML=""+username;
        addChilds(text, name);
      addChilds(info, head,text);      
    addChilds(section,info);
  addChilds(Mcontent, section);
}


// 交互开始
/**
 * [getMy 获取我的手账]
 * @param  {[type]} uid         [用户id]
 * @param  {[type]} currentPage [当前分页]
 * @return {[type]}             [description]
 */
function getMy(uid,currentPage1){
  var searchPath = $("#basePath").val()+"/techo/search";
  var userInfoPath = $("#basePath").val()+"/user/show";
  var d={
      uid:uid,
      page:{currentPage:currentPage1}
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
          var tTitle=obj.title;
          var content=obj.content.substring(0,111)+"...";
          var imgsurl=obj.imgsurl;
          var commentNum=obj.commentNum;
          var thumbupNum=obj.thumbupNum;
          var collectionNum=obj.collectionNum;
          createMy();
          createMyOne(id,uid,headimgurl,username,createtime,tTitle,content,imgsurl,commentNum,thumbupNum,collectionNum);
          // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
          if(idx==4){
            var currentPage=obj.page.currentPage;
            var totalPage=obj.page.totalPage;
            createPage1(uid,currentPage,totalPage,getMy);
          }
      })
    }
  })
}
/**
 * [getFri 获取好友动态列表]
 * @param  {[type]} uid          [description]
 * @param  {[type]} currentPage1 [description]
 * @return {[type]}              [description]
 */
function getFri(uid,currentPage1){
  var searchPath = $("#basePath").val()+"/techo/search";
  var userInfoPath = $("#basePath").val()+"/user/show";
  var d={
	  noticeTechoUid:uid,
      page:{currentPage:currentPage1}
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
          var tTitle=obj.title;
          var content=obj.content.substring(0,111)+"...";
          var imgsurl=obj.imgsurl;
          var commentNum=obj.commentNum;
          var thumbupNum=obj.thumbupNum;
          var collectionNum=obj.collectionNum;
          createFri();
          createFriOne(id,uid,headimgurl,username,createtime,tTitle,content,imgsurl,commentNum,thumbupNum,collectionNum);
          // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
          if(idx==4){
            var currentPage=obj.page.currentPage;
            var totalPage=obj.page.totalPage;
            createPage1(uid,currentPage,totalPage,getFri);
          }
      })
    }
  })
}
/**
 * [getComment 获取评论列表]
 * @param  {[type]} who          [判断是发出还是收到]
 * @param  {[type]} currentPage1 [description]
 * @return {[type]}              [description]
 */
function getComment(who,currentPage1){
  if(who=="a"){//判断是发出还是收到
    var searchPath = $("#basePath").val()+"/comment/list/user";
  }else if(who=="p"){
    var searchPath = $("#basePath").val()+"/comment/list/receive";
  }
  var userInfoPath = $("#basePath").val()+"/user/show";
  var d={
      page:{currentPage:currentPage1}
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
            var tUsername=obj.techoDto.username;
            var tTitle=obj.techoDto.title;
            var content=obj.techoDto.content.substring(0,98)+"...";
            var imgsurl=obj.techoDto.imgsurl;
            createComment();
            createCommentOne(id,uid,headimgurl,username,createtime,coContent,tUsername,tTitle,content,imgsurl);
            // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
            if(idx==obj.page.pageNumber-1){
              var currentPage=obj.page.currentPage;
              var totalPage=obj.page.totalPage;
              createPage2(who,currentPage,totalPage,getComment);
            }
        })
      }
  })
}

/**
 * [getThumbup 点赞]
 * @param  {[type]} who          [判断]
 * @param  {[type]} currentPage1 [description]
 * @return {[type]}              [description]
 */
function getThumbup(who,currentPage1){
  if(who=="a"){//判断是发出还是收到
    var searchPath = $("#basePath").val()+"/thumbup/myThumbupList";
  }else if(who=="p"){
    var searchPath = $("#basePath").val()+"/thumbup/notice";
  }
  var userInfoPath = $("#basePath").val()+"/user/show";
  var d={
      page:{currentPage:currentPage1}
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
            var tUsername=obj.techoDto.username;
            var tTitle=obj.techoDto.title;
            var content=obj.techoDto.content.substring(0,111)+"...";
            var imgsurl=obj.techoDto.imgsurl;
            createThumbup();
            createThumbupOne(id,uid,headimgurl,username,createtime,coContent,tUsername,tTitle,content,imgsurl);
            // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
            if(idx==obj.page.pageNumber-1){
              var currentPage=obj.page.currentPage;
              var totalPage=obj.page.totalPage;
              createPage2( who,uid,currentPage,totalPage,fun);
            }
        })
      }
  })
}


/**
 * [getCollect 收藏]
 * @param  {[type]} who          [判断]
 * @param  {[type]} currentPage1 [description]
 * @return {[type]}              [description]
 */
function getCollect(who,currentPage1){
  if(who=="a"){//判断是发出还是收到
    var searchPath = $("#basePath").val()+"/collection/list/user";
  }else if(who=="p"){
    var searchPath = $("#basePath").val()+"/collection/list/notice";
  }
  var userInfoPath = $("#basePath").val()+"/user/show";
  var d={
      page:{currentPage:currentPage1}
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
            var tUsername=obj.techoDto.username;
            var tTitle=obj.techoDto.title;
            var content=obj.techoDto.content.substring(0,111)+"...";
            var imgsurl=obj.techoDto.imgsurl;
            createCollect();
            createCollectOne(id,uid,headimgurl,username,createtime,coContent,tUsername,tTitle,content,imgsurl);
            // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
            if(idx==obj.page.pageNumber-1){
              var currentPage=obj.page.currentPage;
              var totalPage=obj.page.totalPage;
              createPage2( who,uid,currentPage,totalPage,fun);
            }
        })
      }
  })
}

/**
 * [getFans 粉丝]
 * @param  {[type]} who          [判断]
 * @param  {[type]} currentPage1 [description]
 * @return {[type]}              [description]
 */
function getFans(who,uid,currentPage1){
  var userInfoPath = $("#basePath").val()+"/user/show";
  if(who=="a"){//判断是发出还是收到
    var searchPath = $("#basePath").val()+"/fan/followerList";
      var d={
        fanid:uid,
        page:{currentPage:currentPage1}
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
          var uid=obj.fanid;
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
            createFans();
            createFansOne(id,uid,headimgurl,username);
            // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
            if(idx==obj.page.pageNumber-1){
              var currentPage=obj.page.currentPage;
              var totalPage=obj.page.totalPage;
              createPage2( who,uid,currentPage,totalPage,fun);
            }
        })
      }
  })
  }else if(who=="p"){
    var searchPath = $("#basePath").val()+"/fan/list/notice";
    var d={
        uid:fanid,
        page:{currentPage:currentPage1}
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
          var uid=obj.fanid;
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
            createFans();
            createFansOne(id,uid,headimgurl,username);
            // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
            if(idx==obj.page.pageNumber-1){
              var currentPage=obj.page.currentPage;
              var totalPage=obj.page.totalPage;
              createPage3( who,uid,currentPage,totalPage,fun);
            }
        })
      }
  })
  }


}






// 个人设置
/**
 * [showPreInfo 展示个人信息（跳转到个人资料界面调用]
 */
function showPreInfo(){
  var path = $("#basePath").val()+"/user/show";
  var uid = $("#uid").val();
  var j = {id:uid};
  $.ajax({
    
    headers: { 
          'Accept': 'application/json',
          'Content-Type': 'application/json' 
      },
     /*contentType: 'application/json',*/
      type:"post",
      url:path,
      async:false,
      contentType:"application/json;charset=utf-8",
      data:JSON.stringify(j),
      success:function (data) {
        var name = data.username;
        var sex = data.sex;
        var city = data.city;
        var preProfile=data.content;
        $("#iName").val(name);
        $("#iCity").val(city);
        $("#preProfileI").val(preProfile);
        if(sex==0){
          $("#man").attr("checked" , true);
        }
        else if (sex==1){
          $("#woman").attr("checked" ,true);
        }
      }
  })
}


// 上传手账


