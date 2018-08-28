
    // 上传手账文本信息
    function uploadAn(){
    	var formData =new FormData();
    	for(var i=0;i<imgFiles.length;i++){
    		formData.append("imgFiles", imgFiles[i]);
    	}
    	  formData.append("content", $("#eContent").text());
    	  formData.append("title", $("#eTitle").text());
      var path = $("#basePath").val()+"/techo/add";
      $.ajax({
//        headers: { 
//              'Accept': 'application/json',
//              'Content-Type': 'application/json' 
//          },
    	  processData: false,    	  
          contentType: false,
          type:"post",
          url:path,
//          contentType:"application/json;charset=utf-8",
          data:formData,
          success:function(data){
            if(data.code=="1500"){
              alert("发布成功");
              //跳转公告管理页面manageAn.jsp
            }else if(data.code=="1501"){
              alert("上传失败，请重试");
            }
          }
      });
    }
    function reset(){
    	var par = document.getElementById("meimgboxid");
        var childs = par.childNodes;
        par.removeChild(childs[2]);
        $("#name").val(null);
        $("#num").val(null);
        $("#price").val(null);
    }
    