
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
    $(page).click(function(e){
    	clearAll("mMain");
      fun(uid,$(e.target).html());
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
function createPage2(currentPage,totalPage,fun){
  var Mcontent = document.getElementById("mainContent");
  var pageBox = createEle("div", "pageBox");
  for(var i=1;i<=totalPage;i++){
    var page = createEle("div", "page");
    page.id = "page"+i;
    page.innerHTML=i;
    $(page).attr("currentPage",i);
    $(page).click(function(e){
    	clearAll("mMain");
      fun($(e.target).html());
    })
    addChilds(pageBox,page);
  }
  addChilds(Mcontent,pageBox);
  $("#page"+currentPage).addClass("page_select");
  }
   /**
 * [createPage 创建分页3]
 */
function createPage3(tid,currentPage,totalPage,fun){
  var Mcontent = document.getElementById("mainContent");
  var pageBox = createEle("div", "pageBox");
  for(var i=1;i<=totalPage;i++){
    var page = createEle("div", "page");
    page.id = "page"+i;
    page.innerHTML=i;
    $(page).attr("currentPage",i);
    $(page).click(function(e){
    	clearAll("mMain");
      fun(tid,$(e.target).html());
    })
    addChilds(pageBox,page);
  }
  addChilds(Mcontent,pageBox);
  $("#page"+currentPage).addClass("page_select");
  }
//分页4
function createPage4(tid,currentPage,totalPage,fun){
	  var Mcontent = document.getElementById("joCommentBox");
	  var pageBox = createEle("div", "pageBox");
	  for(var i=1;i<=totalPage;i++){
	    var page = createEle("div", "page");
	    page.id = "page"+i;
	    page.innerHTML=i;
	    $(page).attr("currentPage",i);
	    $(page).click(function(e){
	    	clearAll("joCommentBox");
	      fun(tid,$(e.target).html());
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
    $(section).attr("tid",""+id);
      var info = createEle("div", "info");
      info.onclick="gotoUserQ(uid)";
      info.id="u-"+id ;
      $(info).attr("uid",uid);
        var head = createEle("div","in_head");
        $(head).attr("uid",uid);
          var img = createEle("img","in_head_image");
          $(img).attr("uid",uid);
          img.src=""+headimgurl;
          img.width="50";
          img.height="50";
        addChilds(head, img);
        var text = createEle("div","in_text","rlt");
          var name=createEle("div","in_name");
          name.innerHTML=""+username;
          $(name).attr("uid",""+uid);
          var data=createEle("div","in_data");
          data.innerHTML=""+createtime;
        addChilds(text, name,data);
      addChilds(info, head,text);
      var article = createEle("div", "co_article");
      article.id="article";
        var artText = createEle("div", "co_art_text");
          var artTitle = createEle("div", "co_art_title");
          artTitle.innerHTML=""+tTitle;
          artTitle.id=id;
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
      handle.id = id;
        var hr = createEle("hr");
        var comment = createEle("div", "comment");
        comment.id="joComment";
        comment.innerHTML="评论"+commentNum+"&nbsp;&nbsp;";
        var collect = createEle("div", "collect");
        collect.id="joCollect";
        collect.innerHTML="收藏"+collectionNum+"&nbsp;&nbsp;";
        var thumbup = createEle("div", "thumbup");
        thumbup.id="joThumbup";
        thumbup.innerHTML="赞"+thumbupNum+"&nbsp;&nbsp;";
        var joDelete = createEle("div", "joDelete");
        joDelete.id="joDelete";
        joDelete.innerHTML="删除";
      addChilds(handle, hr,comment,collect,thumbup,joDelete);
    addChilds(section,info,article,handle);
  addChilds(Mcontent, section);
 
}
/**
 * [createFri 创建标题“动态”]
 * @return {[type]} [description]
 */
function createFri() {
  var main = document.getElementById("mMain");
    var title = createEle("div", "main_tit", "rlt");
    title.id="mainTit";
    title.innerHTML="动态";
    var content = createEle("div", "main_content", "rlt"); 
    content.id="mainContent"
  addChilds(main, title,content);
}
/**
 * [createFriOne 创建一条动态]
 */
function createFriOne(id,uid,headimgurl,username,createtime,tTitle,content,imgsurl,commentNum,thumbupNum,collectionNum) {
  var Mcontent = document.getElementById("mainContent");
    var section = createEle("section", "jo"+id);
    section.id="jo-"+id;
    $(section).attr("tid",""+id);
      var info = createEle("div", "info");
      info.id="u-"+id ;
      $(info).attr("uid",uid);
        var head = createEle("div","in_head");
        $(head).attr("uid",uid);
          var img = createEle("img","in_head_image");
          $(img).attr("uid",uid);
          img.src=""+headimgurl;
          img.width="50";
          img.height="50";
        addChilds(head, img);
        var text = createEle("div","in_text","rlt");
          var name=createEle("div","in_name");
          name.innerHTML=""+username;
          $(name).attr("uid",""+uid);
          var data=createEle("div","in_data");
          data.innerHTML=""+createtime;
        addChilds(text, name,data);
      addChilds(info, head,text);
      var article = createEle("div", "co_article");
      article.id="friArticle";
        var artText = createEle("div", "co_art_text");
          var artTitle = createEle("div", "co_art_title");
          artTitle.innerHTML=""+tTitle;
          artTitle.id=id;
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
      handle.id = id;
        var hr = createEle("hr");
        var comment = createEle("div", "comment");
        comment.id="joComment";
        comment.innerHTML="评论"+commentNum+"&nbsp;&nbsp;";
        var collect = createEle("div", "collect");
        collect.id="joCollect";
        collect.innerHTML="收藏"+collectionNum+"&nbsp;&nbsp;";
        var thumbup = createEle("div", "thumbup");
        thumbup.id="joThumbup";
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
function createCommentOne(id,uid,tid,headimgurl,username,createtime,coContent,tUsername,tTitle,content,imgsurl) {
  var Mcontent = document.getElementById("mainContent");
    var section = createEle("section", "jo"+id);
    section.id="jo-"+id;
    $(section).attr("tid",""+id);
      var info = createEle("div", "info");
      info.id="u-"+id ;
      $(info).attr("uid",uid);
        var head = createEle("div","in_head");
        $(head).attr("uid",uid);
          var img = createEle("img","in_head_image");
          $(img).attr("uid",uid);
          img.src=""+headimgurl;
          img.width="50";
          img.height="50";
        addChilds(head, img);
        var text = createEle("div","in_text","rlt");
          var name=createEle("div","in_name");
          name.innerHTML=""+username;
          $(name).attr("uid",""+uid);
          $(name).attr("uid",""+uid);
          var data=createEle("div","in_data");
          data.innerHTML=""+createtime;
        addChilds(text, name,data);
      addChilds(info, head,text);
      var commentCo = createEle("div", "commentCo");
      commentCo.innerHTML=""+coContent;
      var article = createEle("div", "co_article");
      article.id="article";
        var artText = createEle("div", "co_art_text");
          var artTitle = createEle("div", "co_art_title");
          artTitle.innerHTML="@"+tUsername+"；"+tTitle;
          artTitle.id=tid;
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
      var cDetele= createEle("div", "delbtn");
      $(cDetele).attr("tid",""+id);
      cDetele.innerHTML="删除";  
      cDetele.id="cDetele";     
    addChilds(section,info,commentCo,article,cDetele);
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
 * [createThumbupOne1 我：赞]
 *
 */
function createThumbupOne1(id,uid,headimgurl,username,createtime,tTitle,content,imgsurl) {
  var Mcontent = document.getElementById("mainContent");
    var section = createEle("section", "jo"+id);
    section.id="jo-"+id;
    $(section).attr("tid",""+id);
      var info = createEle("div", "info");
      info.id="u-"+id ;
      $(info).attr("uid",uid);
        var head = createEle("div","in_head");
        $(head).attr("uid",uid);
          var img = createEle("img","in_head_image");
          $(img).attr("uid",uid);
          img.src=""+headimgurl;
          img.width="50";
          img.height="50";
        addChilds(head, img);
        var text = createEle("div","in_text","rlt");
          var name=createEle("div","in_name");
          name.innerHTML=""+username;
          $(name).attr("uid",""+uid);
          var data=createEle("div","in_data");
          data.innerHTML=""+createtime;
        addChilds(text, name,data);
      addChilds(info, head,text);
      var article = createEle("div", "co_article");
      article.id="article";
        var artText = createEle("div", "co_art_text");
          var artTitle = createEle("div", "co_art_title");
          artTitle.innerHTML=""+tTitle;
          artTitle.id=id;
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
      var tThumbup= createEle("div", "delbtn");
      $(tThumbup).attr("tid",""+id);
      tThumbup.innerHTML="取消赞";  
      tThumbup.id="tThumbup";
    addChilds(section,info,article,tThumbup);
  addChilds(Mcontent, section);
}

/**
 * [createThumbupOne2 我被：赞]
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
function createThumbupOne2(id,uid,headimgurl,username,createtime,tUsername,tTitle,content,imgsurl) {
  var Mcontent = document.getElementById("mainContent");
    var section = createEle("section", "jo"+id);
    section.id="jo-"+id;
    $(section).attr("tid",""+id);
      var info = createEle("div", "info");
      info.id="u-"+id ;
      $(info).attr("uid",uid);
        var head = createEle("div","in_head");
        $(head).attr("uid",uid);
          var img = createEle("img","in_head_image");
          $(img).attr("uid",uid);
          img.src=""+headimgurl;
          img.width="50";
          img.height="50";
        addChilds(head, img);
        var text = createEle("div","in_text","rlt");
          var name=createEle("div","in_name");
          name.innerHTML=""+username;
          $(name).attr("uid",""+uid);
          var data=createEle("div","in_data");
          data.innerHTML=""+createtime;
        addChilds(text, name,data);
      addChilds(info, head,text);
      var article = createEle("div", "co_article");
      article.id="article";
        var artText = createEle("div", "co_art_text");
          var artTitle = createEle("div", "co_art_title");
          artTitle.innerHTML="@"+tUsername+"；"+tTitle;
          artTitle.id=id;
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
 * [createCollectOne1 我：收藏 ]
 */
function createCollectOne1(id,uid,headimgurl,username,createtime,tTitle,content,imgsurl) {
  var Mcontent = document.getElementById("mainContent");
    var section = createEle("section", "jo"+id);
    section.id="jo-"+id;
    $(section).attr("tid",""+id);
      var info = createEle("div", "info");
      info.id="u-"+id ;
      $(info).attr("uid",uid);
        var head = createEle("div","in_head");
        $(head).attr("uid",uid);
          var img = createEle("img","in_head_image");
          $(img).attr("uid",uid);
          img.src=""+headimgurl;
          img.width="50";
          img.height="50";
        addChilds(head, img);
        var text = createEle("div","in_text","rlt");
          var name=createEle("div","in_name");
          name.innerHTML=""+username;
          $(name).attr("uid",""+uid);
          var data=createEle("div","in_data");
          data.innerHTML=""+createtime;
        addChilds(text, name,data);
      addChilds(info, head,text);
      var article = createEle("div", "co_article");
      article.id="article";
        var artText = createEle("div", "co_art_text");
          var artTitle = createEle("div", "co_art_title");
          artTitle.innerHTML=""+tTitle;
          artTitle.id=id;
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
      var cCollect= createEle("div", "delbtn");
      $(cCollect).attr("tid",""+id);
      cCollect.innerHTML="取消收藏";  
      cCollect.id="cCollect";
    addChilds(section,info,article,cCollect);
  addChilds(Mcontent, section);
}
/**
 * [createCollectOne2 我被：收藏]
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
function createCollectOne2(id,uid,headimgurl,username,createtime,tUsername,tTitle,content,imgsurl) {
  var Mcontent = document.getElementById("mainContent");
    var section = createEle("section", "jo"+id);
    section.id="jo-"+id;
    $(section).attr("tid",""+id);
      var info = createEle("div", "info");
      info.id="u-"+id ;
      $(info).attr("uid",uid);
        var head = createEle("div","in_head");
        $(head).attr("uid",uid);
          var img = createEle("img","in_head_image");
          $(img).attr("uid",uid);
          img.src=""+headimgurl;
          img.width="50";
          img.height="50";
        addChilds(head, img);
        var text = createEle("div","in_text","rlt");
          var name=createEle("div","in_name");
          name.innerHTML=""+username;
          $(name).attr("uid",""+uid);
          var data=createEle("div","in_data");
          data.innerHTML=""+createtime;
        addChilds(text, name,data);
      addChilds(info, head,text);
      var article = createEle("div", "co_article");
      article.id="article";
        var artText = createEle("div", "co_art_text");
          var artTitle = createEle("div", "co_art_title");
          artTitle.innerHTML="@"+tUsername+"；"+tTitle;
          artTitle.id=id;          
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
      fActive.innerHTML="关注";
      var fPassive = createEle("div", "passive");
      fPassive.id="fPassive";
      fPassive.innerHTML="粉丝";
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
      var info = createEle("div", "info");
      info.id="u-"+id ;
      $(info).attr("uid",uid);
        var head = createEle("div","in_head");
        $(head).attr("uid",uid);
          var img = createEle("img","in_head_image");
          $(img).attr("uid",uid);
          img.src=""+headimgurl;
          img.width="50";
          img.height="50";
        addChilds(head, img);
        var text = createEle("div","in_text","rlt");
          var name=createEle("div","in_name");
          name.innerHTML=""+username;
          $(name).attr("uid",""+uid);
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
          var content=obj.content.substring(0,98)+"...";
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
//	  noticeTechoUid:uid,
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
          var content=obj.content.substring(0,98)+"...";
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
 * [getCommentA  我：获取评论列表]
 */
function getCommentA(currentPage1){
  var searchPath = $("#basePath").val()+"/comment/list/user";
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
          var tid=obj.tid;
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
            createCommentOne(id,uid,tid,headimgurl,username,createtime,coContent,tUsername,tTitle,content,imgsurl);
            // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
            if(idx==obj.page.pageNumber-1){
              var currentPage=obj.page.currentPage;
              var totalPage=obj.page.totalPage;
              createPage2(currentPage,totalPage,getCommentA);
            }
        })
      }
  })
}

/**
 * [getCommentP  我被：获取评论列表]
 */
function getCommentP(currentPage1){
  var searchPath = $("#basePath").val()+"/comment/list/receive";
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
          var tid=obj.tid;
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
            createCommentOne(id,uid,tid,headimgurl,username,createtime,coContent,tUsername,tTitle,content,imgsurl);
            // 并添加分页按钮
            if(idx==obj.page.pageNumber-1){
              var currentPage=obj.page.currentPage;
              var totalPage=obj.page.totalPage;
              createPage2(currentPage,totalPage,getCommentP);
            }
        })
      }
  })
}

/**
 * [getThumbupA 我：点赞]
 * @return {[type]}              [description]
 */
function getThumbupA(currentPage1){
  var searchPath = $("#basePath").val()+"/thumbup/myThumbupList";
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
          var id=obj.techoDto.id;
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
            var tUsername=obj.techoDto.username;
            var tTitle=obj.techoDto.title;
            var content=obj.techoDto.content.substring(0,98)+"...";
            var imgsurl=obj.techoDto.imgsurl;
            createThumbup();
            createThumbupOne1(id,uid,headimgurl,username,createtime,tTitle,content,imgsurl);
            // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
            if(idx==obj.page.pageNumber-1){
              var currentPage=obj.page.currentPage;
              var totalPage=obj.page.totalPage;
              createPage2(uid,currentPage,totalPage,getThumbupA);
            }
        })
      }
  })
}
/**
 * [getThumbupP 我被：点赞]
 */
function getThumbupP(currentPage1){
  var searchPath = $("#basePath").val()+"/thumbup/notice";
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
          var id=obj.techoDto.id;
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
            createThumbup();
            createThumbupOne2(id,uid,headimgurl,username,createtime,tUsername,tTitle,content,imgsurl);
            // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
            if(idx==obj.page.pageNumber-1){
              var currentPage=obj.page.currentPage;
              var totalPage=obj.page.totalPage;
              createPage2( uid,currentPage,totalPage,fun);
            }
        })
      }
  })
}

/**
 * [getCollectA 我：收藏]
 * @param  {[type]} currentPage1 [description]
 * @return {[type]}              [description]
 */
function getCollectA(currentPage1){
  var searchPath = $("#basePath").val()+"/collection/list/user";
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
                var id=obj.techoDto.id;
                var createtime=obj.createtime;
                var uid=obj.uid;
                var a={id:uid};
                var headimgurl="";
                var username="";
                $.ajax({
                    contentType: 'application/json',
                      type:"post",
                      url:userInfoPath,
                      async:false,
                      contentType:"application/json;charset=utf-8",
                      data:JSON.stringify(a),
                      success:function(data){
                        headimgurl=data.headimgurl;
                        username=data.username;
                      }
                  });
                  var tUsername=obj.techoDto.username;
                  var tTitle=obj.techoDto.title;
                  var content=obj.techoDto.content.substring(0,98)+"...";
                  var imgsurl=obj.techoDto.imgsurl;
                  createCollect();
                  createCollectOne1(id,uid,headimgurl,username,createtime,tTitle,content,imgsurl);
                  // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
                  if(idx==obj.page.pageNumber-1){
                    var currentPage=obj.page.currentPage;
                    var totalPage=obj.page.totalPage;
                    createPage2( uid,currentPage,totalPage,getCollectA);
                  }
              })
        }
    })
}
/**
 * [getCollectP 我被：收藏]
 * @param  {[type]} currentPage1 [description]
 * @return {[type]}              [description]
 */
function getCollectP(currentPage1){
  var searchPath = $("#basePath").val()+"/collection/list/notice";
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
          var id=obj.techoDto.id;
          var createtime=obj.createtime;
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
            createCollect();
            createCollectOne2(id,uid,headimgurl,username,createtime,tUsername,tTitle,content,imgsurl);
            // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
            if(idx==obj.page.pageNumber-1){
              var currentPage=obj.page.currentPage;
              var totalPage=obj.page.totalPage;
              createPage2(uid,currentPage,totalPage,getCollectP);
            }
        })
      }
  })
}
/**
 * [getFansA 关注]
 */
function getFansA(uid,currentPage1){
  var userInfoPath = $("#basePath").val()+"/user/show";
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
    createFans();
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
          createFansOne(id,uid,headimgurl,username);
          // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
          if(idx==obj.page.pageNumber-1){
            var currentPage=obj.page.currentPage;
            var totalPage=obj.page.totalPage;
            createPage2(uid,currentPage,totalPage,getFansA);
          }
      })
    }
  })
}
/**
 * [getFansP 粉丝]
 */
function getFansP(uid,currentPage1){  
  var userInfoPath = $("#basePath").val()+"/user/show";
    var searchPath = $("#basePath").val()+"/fan/noticeList";
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
              createPage1( uid,currentPage,totalPage,getFansP);
            }
        })
      }
  })
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
        var contact = data.contact;
        var preProfile=data.content;
        $("#iName").val(name);
        $("#iCity").val(city);
        $("#iContact").val(contact);
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


//handle层
// 评论：跳转手账详情 journal.html(带参数手账id)
function commentQ(id){
  var path=$("#basePath").val()+"/journal/"+id+"?area=1"
  var title="手账详情";
  // window.open(path);
  window.location.href=path;
}
// 赞：发送请求
function aThumbupQ(id){
  var tumpath=$("#basePath").val()+"/thumbup/add";
  var d={
      tid:id
  }
   $.ajax({
    headers: { 
          'Accept': 'application/json',
          'Content-Type': 'application/json' 
      },
    async:false,
    contentType: 'application/json',
    type:"post",
    url:tumpath,
    contentType:"application/json;charset=utf-8",
    data:JSON.stringify(d),
    success:function (data) {
      if(data.code==1200){
    	  alert("点赞成功")
      }else if(data.code==1201){
    	  alert("你已经赞过了，无须重复点赞");
      }
    }
  })
}

// 收藏：发送请求
function aCollectQ(id){
  var tumpath=$("#basePath").val()+"/collection/add";
  var d={
      tid:id
  }
   $.ajax({
    headers: { 
          'Accept': 'application/json',
          'Content-Type': 'application/json' 
      },
    async:false,
    contentType: 'application/json',
    type:"post",
    url:tumpath,
    contentType:"application/json;charset=utf-8",
    data:JSON.stringify(d),
    success:function (data) {
      if(data.code==1300){
    	  alert("收藏成功")
      }else if(data.code==1301){
        alert("你已经收藏过了，无须重复收藏");
      }
    }
  })
}

// 素材获取：跳转页面详情 (带参数手账id)
function materialQ(id){
  var path=$("#basePath").val()+"/journal/"+id+"?area=2"
  window.open(path);
}
// 删除：发送请求
function joDeleteQ(uid,id){
  var path=$("#basePath").val()+"/techo/del";
  var d={
      tid:id
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
      if(data.code==1600){
        clearAll("mainContent");
        getMy(uid,1);
        alert("删除成功");
      }else if(data.code==1601){
      }
    }
  })
}

/**
 * [createMy 创建标题“他的手账”]
 * @return {[type]} [description]
 */
function createHis() {
  var main = document.getElementById("mMain");
    var title = createEle("div", "main_tit", "rlt");
    title.id="mainTit";
    title.innerHTML="他的手账";
    var content = createEle("div", "main_content", "rlt"); 
    content.id="mainContent"
  addChilds(main, title,content);
}
/**
 * [getFri 获取他的手账列表]
 * @param  {[type]} uid          [description]
 * @param  {[type]} currentPage1 [description]
 * @return {[type]}              [description]
 */
function getHis(uid,currentPage1){
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
          var content=obj.content.substring(0,98)+"...";
          var imgsurl=obj.imgsurl;
          var commentNum=obj.commentNum;
          var thumbupNum=obj.thumbupNum;
          var collectionNum=obj.collectionNum;
          createHis();
          createFriOne(id,uid,headimgurl,username,createtime,tTitle,content,imgsurl,commentNum,thumbupNum,collectionNum);
          // 添加的，当条数达到5的时候，停止生成html，并添加分页按钮
          if(idx==4){
            var currentPage=obj.page.currentPage;
            var totalPage=obj.page.totalPage;
            createPage1(uid,currentPage,totalPage,getHis);
          }
      })
    }
  })
}
// 个人信息（他人）
function findHis(hid){
  var userInfoPath = $("#basePath").val()+"/user/show";
  var a={id:hid}
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
          username=data.username;
        }
  });
}

//请求头像
function Qheadimg(id){
	var userInfoPath = $("#basePath").val()+"/user/show";
	var headimgurl;
	var a={
		    id:id
		  }
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

    return headimgurl;
}


// 跳转到别人手账详情
function gotoJoQ(id){
  var path=$("#basePath").val()+"/journal/"+id
  window.open(path);
}

// 跳转到用户界面
//adminOther
function gotoUserQ(id){
  var path=$("#basePath").val()+"/adminOther/"+id
  window.location.href=path
}
//跳转到交易界面
function gototran(){
  var path=$("#basePath").val()+"/transact/";
  window.location.href=path
}



function Aread(){
  var nPath = $("#basePath").val()+"/notice/read"; 
  var path=$("#basePath").val()+"/index";
  $.ajax({
    contentType: 'application/json',
    type:"post",
    url:nPath,
    async:false,
    contentType:"application/json;charset=utf-8",
    data:"", 
    success:function (data) {
        alert("已经标记为已读！")
        window.location.href=path;
       }  
})   
}


// 删除评论：发送请求
function coDeleteQ(id){
  var path=$("#basePath").val()+"/comment/del";
  var d={
      id:id
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
      if(data.code==1600){
        clearAll("mainContent");
       getCommentA(1);
        alert("删除成功");
      }else if(data.code==1601){        
        alert("删除失败");
      }
    }
  })
}

// 取消赞：发送请求
function tThumbupQ(id){
  var path=$("#basePath").val()+"/thumbup/del";
  var d={
      tid:id
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
      if(data.code==1600){
        clearAll("mainContent");
       getThumbupA(1);
        alert("取消赞成功");
      }else if(data.code==1601){      
        alert("取消赞失败");
      }
    }
  })
}

// 取消收藏：发送请求
function cCollectQ(id){
  var path=$("#basePath").val()+"/collection/del";
  var d={
      tid:id
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
      if(data.code==1600){
        clearAll("mainContent");
        getCollectA(1);
        alert("取消收藏成功");
      }else if(data.code==1601){      
        alert("取消收藏失败");
      }
    }
  })
}

function isNewNotice(){  
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
      var read=data.read;
      // var read=true;
      if (read){
        $("#hideM").css("display","block")
        $("#adMain").css("display","block");
        document.body.style.overflow='hidden';//ie9ie10chrome
        document.documentElement.style.overflow='hidden';//ie6,ie7,ie8
        function pupclose(){
        document.body.style.overflow='';//ie9ie10chrome
        document.documentElement.style.overflow='';//ie6,ie7,ie8 
        }
         getNotice();
      }
    }
  })
}

function getNotice(){
    // 获取公告内容
  var nPath = $("#basePath").val()+"/notice";
  $.ajax({
    contentType: 'application/json',
    type:"post",
    url:nPath,
    async:false,
    contentType:"application/json;charset=utf-8",
    data:"",
    success:function(data){
      var title=data.title;
      var content=data.content;
      var createtime=data.createtime;
      $("#adTitle").html(title);  
      $("#adTime").html(createtime);  
      $("#adContent").html(content);  
      $("#readAd").click(function(){
        Aread();
      }) 
    }     
  }) 
}