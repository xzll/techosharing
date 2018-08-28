


// 发送验证码
function code(){
    var path=$("#basePath").val()+"/register/sendCode";
    var formData =new FormData();
    var username = document.getElementById("userR").value;
    formData.append("email", username);
   
    $.ajax({
      type:"post",
      url:path,
      async:false,
      data:formData,
      processData: false,    	  
      contentType: false,
      success:function(data){
        alert(data.msg);
      }
    });
}

//  // 记住账号
 if ($("#rememberL").attr("checked")) {
　　　　$.cookie("rmbUser", "true", { expires: 7 }); //存储一个带7天期限的cookie
　　　　$.cookie("username", userL.vlaue, { expires: 7 });
　　　　$.cookie("password", passwordL.value, { expires: 7 });
　　}
　　else {
　　　　$.cookie("rmbUser", "false", { expire: -1 });
　　　　$.cookie("username", "", { expires: -1 });
　　　　$.cookie("password", "", { expires: -1 });
　　}
$(function(){
   //获取cookie的值
　　　　var username = $.cookie('username');
　　　　var password = $.cookie('password');
　　　　//将获取的值填充入输入框中
　　　　$('#userL').val(username);
　　　　$('#passwordL').val(password); 
　　　　if(username != null && username != '' && password != null && password != ''){//选中保存秘密的复选框
　　　　　　$("#rememberL").attr('checked',true);
　　　}

})




function login() {
    var xmlhttp;
    var userName = document.getElementById("user");
    var password = document.getElementById("password");

    if (userName.value == "" || password.value == "") {
        document.getElementById("tips").innerHTML = "用户或密码不能为空";
        return;
    }

    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject();
    }

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var json = xmlhttp.responseText;
            var login=eval("("+json+")");
            if(login.success){
                

                location.href=login.url;


            }else{
                password.value="";
                document.getElementById("tips").innerHTML=login.message;
            }
        }
    }
    xmlhttp.open("POST", "/login/validate", true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("email=" + userName.value + "&password=" + password.value);

}
//document.getElementById("loginBtn").onclick=login;

// 注册
function register(){
    var userName = document.getElementById("user");
    var password = document.getElementById("password");

    if (userName.value == "" || password.value == "") {
        document.getElementById("tips").innerHTML = "用户或密码不能为空";
        return;
    }

    var path=$("#basePath").val()+"/register/sendCode";
    var a={
      email:userName,
      password:password,
      code:code
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
     })
}
