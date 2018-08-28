$(function() {
	common.showMessage($("#message").val());
});

function search(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}

function remove(id) {
	if(confirm("确定要删除这条评论吗？")) {
		$("#id").val(id);
		$("#mainForm").attr("action",$("#basePath").val() + "/admin/comment/remove");
		$("#mainForm").submit();
	}
}

