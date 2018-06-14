$(function() {

    //初始化病历目录数据
    loadEmrCataLog();
});

function addCatalog(){

    layer.open({
        type:2,
        title:"新增目录",
        shadeClose: true,
        area : [ '780px', '710px' ],
        skin: 'layui-layer-molv',
        offset:'t',
        content:"/template/medicalrecord/add"
    })
}

function openCatalog(){
    layer.open({
        type:2,
        title:"选择上级目录",
        shadeClose: true,
        area : [ '400px', '600px' ],
        skin: 'layui-layer-molv',
        content:"/template/medicalrecord/catalogTree",
        btn: ['确定', '取消', ],
        yes: function(index, layero){
            var iframeWin = window[layero.find('iframe')[0]['name']];
            var object = iframeWin.callBack();
            layer.close(index);
            $("#parentCatalog").val(object.catalogName);
        }
    })
}

var zTree = "";
function loadEmrCataLog() {
    var setting = {
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onClick: function (event, treeId, treeNode) {

            }
        }
    };
    $.ajax({
        type: "GET",
        url: "/emr/catalog/list",
        success: function (data) {
            zTree = $.fn.zTree.init($("#treeRm"), setting, data);
            zTree.expandAll(true);
        }
    });
}