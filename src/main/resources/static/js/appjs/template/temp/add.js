$().ready(function() {
	validateRule();

	$.ajax({  
        type : 'get',  
        url : "/template/temp/getTypes",  
        dataType : 'json',  
        success : function(datas) {//返回list数据并循环获取  
            var select = $("#typeSel");  
            for (var i = 0; i < datas.length; i++) {  
                select.append("<option value='"+datas[i].PK_TMP_CLASS+"'>"  
                        + datas[i].NAME_CLASS + "</option>");  
            }  
       	 var select = $("#rangeSel");  
       	 select.append("<option value='QY'>全院</option>");  
       	 select.append("<option value='KS'>科室</option>");  
       	 select.append("<option value='GR'>个人</option>");  

        }
    });
	
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	parent.templateName = $("#templateName").val();
	parent.rangeSel = $("#rangeSel").val();
	parent.typeSel = $("#typeSel").val();
	parent.openFlag = 1;
	var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
	parent.layer.close(index);
	parent.loadEditPage();
	return;
//	$.ajax({
//		cache : true,
//		type : "POST",
//		url : "/emrsys/dept/add",
//		data : $('#templateForm').serialize(),// 你的formid
//		async : false,
//		error : function(request) {
//			parent.layer.alert("Connection error");
//		},
//		success : function(data) {
//			if (data.code == 1) {
//				parent.layer.msg("操作成功");
//				parent.reLoad();
//				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
//				parent.layer.close(index);
//
//			} else {
//				parent.layer.alert(data.msg)
//			}
//		}
//	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#templateForm").validate({
		rules : {
			templateName : {
				required : true
			},
			rangeSel : {
				required : true
			},
			typeSel : {
				required : true
			}
		},
		messages : {
			name : {
				templateName : icon + "请输入模板名称",
				rangeSel : icon + "请选择范围",
				typeSel : icon + "请选择类型"
			}
		}
	})
}

function cancel(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}