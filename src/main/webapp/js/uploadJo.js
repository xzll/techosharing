
    //选择图片，马上预览
  function xmTanUploadImg(obj) {
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
                var oimgbox=document.getElementById("imgboxid");
                var ndiv=document.createElement("div");

                ndiv.innerHTML=imgstr;
                ndiv.className="img-div";
                oimgbox.appendChild(ndiv);   
            }
            reader.readAsDataURL(file);
        }
    }
    function xmTanUploadImg2(obj) {
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
    function onlyUp(){
      $("#hideM").css("display","block");
    }
    // 上传手账文本信息
    function uploadJo(){
    	var formData =new FormData();
    	var imgFiles = $("#xdaTanFileImg")[0].files;
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
              alert("上传成功，获取100豆豆");
              $("#hideM").css("display","none");
              $("#eImages").css("display","block");
              $("button").attr("tid",data.msg);
            }else if(data.code=="1501"){
              alert("上传失败，请重试");
            }
          }
      });
    }
    function clearImg(){
      clearAll("imgboxid");
      $("#hideM").css("display","none");
    }
// 上传素材
    function uploadMe(){
      var tid = $("#upMe").attr("tid");
      var formData =new FormData();  
        formData.append("imgFile", $("#meFileImg")[0].files[0]);
        formData.append("name", $("#name").val());
        formData.append("number", $("#num").val());
        formData.append("price", $("#price").val());
        formData.append("tid", tid);
      var path = $("#basePath").val()+"/material/add";
      $.ajax({
        processData: false,       
          contentType: false,
          type:"post",
          url:path,
          data:formData,
          success:function(data){
            if(data.code=="1400"){
              alert("发布成功");
              reset();
            }else if(data.code=="1401"){
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
    