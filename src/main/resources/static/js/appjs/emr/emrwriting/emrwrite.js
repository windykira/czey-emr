$(function() {
    loadEmrCataLog();
});
var zTree = "";
//var selectNodes = zTree.getSelectedNodes();
function loadEmrCataLog(){
    var setting = {
        data: {
            simpleData: {
                enable: true}
        }
    };
    $.ajax({
        type : "GET",
        url : "/emr/catalog/list",
        success : function(data) {
            zTree = $.fn.zTree.init($("#treeDemo"), setting, data);
        }
    });
}

function showModal(){
    //$("#addMedical").modal("toggle");
    var selectNodes = zTree.getSelectedNodes();
    if(selectNodes.length == 0){
        layer.msg("请选择病历目录。");
        return;
    }
    $.ajax({
        type : "GET",
        url : "/template/class/list/"+selectNodes[0].id,
        success : function(datas) {

            $.each(datas,function(i,e){
                $(".list-group").append(" <li class='list-group-item active' value="+e.id+">"+e.nameClass+"</li>")
            });
            //$(".list-group").append();
            $("#addMedical").modal("toggle");
        }
    });
}

var treeObj = $.fn.zTree.getZTreeObj("tree");
treeObj.expandAll(true);
/*
function getTreeData() {
    $.ajax({
        type : "GET",
        url : "/emrsys/menu/tree",
        success : function(treeData) {
            loadTree(treeData);
        }
    });
}
function loadTree(treeData) {
    $('#treeDemo').jstree({
        'core' : {
            'data' : treeData
        },
        "checkbox" : {
            "three_state" : true,
        },
        "plugins" : [ "wholerow", "checkbox" ]
    });
    $('#treeDemo').jstree("open_all");
}*/
