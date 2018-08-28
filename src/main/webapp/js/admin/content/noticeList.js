$(function() {
	common.showMessage($("#message").val());
});

function search(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}

function remove(id) {
	if(confirm("确定要删除这条公告吗？")) {
		$("#id").val(id);
		$("#mainForm").attr("action",$("#basePath").val() + "/admin/notice/remove");
		$("#mainForm").submit();
	}
}

$(function(){
  $("#btnAd").click(function(){
    addAd();
  })
  $("#uploadAd").click(function(){
    uploadAd();
  })
  function addAd(){
    $("#hideM").css("display","block")
    $("#adMain").css("display","block");
    document.body.style.overflow='hidden';//ie9ie10chrome
    document.documentElement.style.overflow='hidden';//ie6,ie7,ie8
    function pupclose(){
    document.body.style.overflow='';//ie9ie10chrome
    document.documentElement.style.overflow='';//ie6,ie7,ie8
    }
  }
  function uploadAd(){
    var title = $("#adTitle").html();
    var content = $("#adContent").html();
    var aPath = $("#basePath").val()+"/admin/notice/add"; 
    var path=$("#basePath").val()+"/admin/notice";
    var d={
        title:title,
        content:content
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
        alert("发布公告成功！")
        window.location.href=path;
       }
      }
    })
  }
})