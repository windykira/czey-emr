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
