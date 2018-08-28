$(function(){
  $("#addBtnUser").click(function(){
    addUserBox();
  })
  $("form").on("click","#addUser",function(){
    addUser();
  });
  // 显示添加弹窗
  function addUserBox(){
    $("#hideM").css("display","block")
    $("#userMain").css("display","block");
    document.body.style.overflow='hidden';//ie9ie10chrome
    document.documentElement.style.overflow='hidden';//ie6,ie7,ie8
    function pupclose(){
    document.body.style.overflow='';//ie9ie10chrome
    document.documentElement.style.overflow='';//ie6,ie7,ie8
    }
  }
  // 提交添加信息
  function addUser(){
    var username = $("#addusername").val();
    var passwoed = $("#addpasswoed").val();
    var email = $("#addemail").val();
    var coin = $("#addcoin").val();
    var aPath = $("#basePath").val()+"/admin/user/add"; 
    var path=$("#basePath").val()+"/admin/user";
    var d={
      username:username,
      password:passwoed,
      email:email,
      coin:coin
    }
    $.ajax({
    
    headers: { 
          'Accept': 'application/json',
          'Content-Type': 'application/json' 
      },
      async:false,
     contentType: 'application/json',
      type:"post",
      url:aPath,
      contentType:"application/json;charset=utf-8",
      data:JSON.stringify(d),
      success:function (data) {
       if(data.code==2001){
        alert("添加用户信息成功！")
        window.location.href=path;
       }else {
        alert(data.msg);
       }
      }
    })
  }
  // 修改用户信息
    $("form").on("click","#updateBtnUser",function(e){
    updateUserBox(e);
  });
  $("form").on("click","#updataUser",function(e){
    updateUser(e);
  });
  // 显示修改弹窗
  function updateUserBox(e){
    var id=$(e.target).attr("uid");
    $("#hideMU").css("display","block")
    $("#userMainU").css("display","block");
    $("#updataUser").attr("uid",id);
    document.body.style.overflow='hidden';//ie9ie10chrome
    document.documentElement.style.overflow='hidden';//ie6,ie7,ie8
    function pupclose(){
    document.body.style.overflow='';//ie9ie10chrome
    document.documentElement.style.overflow='';//ie6,ie7,ie8
    }
  }
  // 提交修改信息
  function updateUser(e){
    var id=$(e.target).attr("uid");
    var username = $("#updatausername").val();
    var passwoed = $("#updatapasswoed").val();
    var coin = $("#updatacoin").val();
    var aPath = $("#basePath").val()+"/admin/user/modify"; 
    var path=$("#basePath").val()+"/admin/user";
    var d={
      id:id,
      username:username,
      password:passwoed,
      coin:coin
    }
    $.ajax({
    
    headers: { 
          'Accept': 'application/json',
          'Content-Type': 'application/json' 
      },
      async:false,
     contentType: 'application/json',
      type:"post",
      url:aPath,
      contentType:"application/json;charset=utf-8",
      data:JSON.stringify(d),
      success:function (data) {
       if(data.code==1001){
        alert("昵称已存在")
       }else if(data.code==1800){
        alert("修改用户信息成功！");
        window.location.href=path;       
       }else{
        alert(data.msg);
       }
       
      }
    })
  }
})