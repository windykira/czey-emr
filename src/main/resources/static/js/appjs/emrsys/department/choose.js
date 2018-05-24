var departmentId = "";
$().ready(function () {
    var userId = parent.$("#userId").val();
    if(departmentId == ""){
        loadDepartment();
        validateRule();
    }

});

$.validator.setDefaults({
    submitHandler: function () {
        //businessRefresh();
    }
});

$(".btn-primary").click(function () {

    //parent.location.href = '/index';
    departmentId = $("#sysdept").val();
    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
    parent.layer.close(index);
});

function businessRefresh() {

    $.ajax({
        type: "POST",
        url: "/main",
        data: $('#signupForm').serialize(),// 你的formid
        async: false,
        error: function (request) {
            parent.layer.alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);

            } else {
                parent.layer.alert(data.msg)
            }

        }
    });
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            sysdept: {
                required: true
            }
        },
        messages: {
            sysdept: {
                required: icon + "请选择科室"
            }
        }
    })
}

function loadDepartment() {
    var html = "";
    var data = parent.departmentData;
    for (var i = 0; i < data.length; i++) {
        html += '<option value="' + data[i].id + '">' + data[i].departmentName + '</option>'
    }
    (".chosen-select").append(html);
    $(".chosen-select").chosen({
        maxHeight: 200
    });
    /*$.ajax({
        type:"GET",
        url: '/emrsys/dept/listByUserId/' + parent.$("#userId").val(),
        success: function (data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].id + '">' + data[i].departmentName + '</option>'
            }
            $(".chosen-select").append(html);
            $(".chosen-select").chosen({
                maxHeight: 200
            });
        }
    });*/
}
