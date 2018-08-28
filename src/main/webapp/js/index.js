// 点击主页，跳到主页或刷新
$("#homepage").click(function(){

})
// 登录注册及切换
$("#goLogin").click(function(){
  $("#lo").css("display","block");
  $("#loginBox").css("display","block");
})
$("#goRegister").click(function(){
  $("#lo").css("display","block");
  $("#registerBox").css("display","block");
})
$("#login").click(function(){
  $("#registerBox").css("display","none");
  $("#loginBox").css("display","block");
})
$("#register").click(function(){
  $("#loginBox").css("display","none");
  $("#registerBox").css("display","block");
})
$("#login2").click(function(){
  $("#registerBox").css("display","none");
  $("#loginBox").css("display","block");
})
$("#register2").click(function(){
  $("#loginBox").css("display","none");
  $("#registerBox").css("display","block");
})