/**
 * [changePreInfo 修改个人资料]
 * @return {[type]} [description]
 */

var uid=$("#uid").val();
function changePreInfo (){
  // 获取数据
  var iName=$("#iName").val();
  var iCity=$("#iCity").val();
  var iContact=$("#iContact").val();
  var preProfileI=$("#preProfileI").val();
  emptyTips(iName,"昵称");
  emptyTips(iCity,"所在地");
  var sex;
  var val=$('input:radio[name="sex"]:checked').val();
  if(val=="女"){
    sex=true;
  }
  else if (val=="男"){
    sex=false;
  }
  else{
    alert("请选择性别");
  }
  // 发送请求
  var path = $("#basePath").val()+"/user/update";
  var j = {username:iName };
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
      if(data.code=="1001"){
        alert("用户名已存在");
      }
      else if (data.code=="1800"){
        // 用户名修改成功，发送下一个请求，修改其他信息
        var path = $("#basePath").val()+"/user/updateInfo";
       var j={city:iCity,
              contact:iContact,
               content:preProfileI,
               sex:sex}
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
              if(data.code=="1800"){
                alert("修改成功");
              }
              else if (data.code=="1801"){
                alert("修改失败，请重试");
              }
              else {
                alert("修改失败，请重试");
              }
            }
        })
      }
    }
  })  
}

/**
 * [changePreInfo 修改密码没有？？？]
 * @return {[type]} [description]
 */

$(function(){
  showPreInfo();
  $("#perInfo").click(function(){
    showPreInfo();
  })
})


//  个人资料获取
  $(function(){

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
          $("#nInHeadImage").attr("src",headimgurl);         
          }
      });
  })
function xmTanUploadImg3(obj) {
        var fl=obj.files.length;
        for(var i=0;i<fl;i++){
            var file=obj.files[i];
            var reader = new FileReader();
            //读取文件过程方法
            reader.onloadstart = function (e) {
                console.log("开始读取....");
            }
            reader.onprogress = function (e) {
                console.log("正在读取中....");
            }
            reader.onabort = function (e) {
                console.log("中断读取....");
            }
            reader.onerror = function (e) {
                console.log("读取异常....");
            }
            reader.onload = function (e) {
                console.log("成功读取....");

                var imgstr='<img style="width:100px;height:100px;" src="'+e.target.result+'"/>';
                var oimgbox=document.getElementById("meimgboxid");
                var ndiv=document.createElement("div");

                ndiv.innerHTML=imgstr;
                ndiv.className="img-div";
                oimgbox.appendChild(ndiv);   
            }
            reader.readAsDataURL(file);
        }
    }
// 更改头像
function changeHeadimg(){
  var userInfoPath = $("#basePath").val()+"/user/account";
  var formData =new FormData();
      var imgFiles = $("#xdaTanFileImg")[0].files;
        formData.append("headimgfile", imgFiles[0]);
      var path = $("#basePath").val()+"/user/loadHeadImg";
      $.ajax({
        processData: false,       
          contentType: false,
          type:"post",
          url:path,
          data:formData,
          success:function(data){
            if(data.code=="2001"){
              alert("成功修改头像");
              window.location.href=userInfoPath;
            }else if(data.code=="2002"){
              alert("上传失败，请重试");
            }
          }
      });
}