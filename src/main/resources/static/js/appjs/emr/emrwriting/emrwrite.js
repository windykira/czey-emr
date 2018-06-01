$(function() {

    //初始化病历目录数据
    loadEmrCataLog();

    $(".nav-tabs li").click(function () {
        $(this).addClass("active").siblings(".active").removeClass("active");
    });
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

            $(".list-group").find("li").remove();
            $.each(datas,function(i,e){
                if(i == 0){
                    $(".list-group").append(" <li class='list-group-item active' style='cursor: pointer;' value="+e.id+" onclick='reloadTemplate(this)'>"+e.nameClass+"</li>")
                }else{
                    $(".list-group").append(" <li class='list-group-item' style='cursor: pointer;' value="+e.id+" onclick='reloadTemplate(this)'>"+e.nameClass+"</li>")
                }
            });
            $("#addMedical").modal("toggle");
            //加载模板表格数据
            loadTemplateTable(1);
            $(".list-group li").click(function () {
                $(this).addClass("active").siblings(".active").removeClass("active");
            });
        }
    });
}

function reloadTemplate(e){

    $('#templateTable').bootstrapTable('refreshOptions',{
        queryParams: function (params) {
            return {
                // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: params.limit,
                page:(params.offset / params.limit) + 1,
                range:$(".nav-tabs").find(".active").attr("value"),
                templateClassId:$(e).attr("value")
            };
        }
    });
}

function reloadTemplateTable(rangeValue){

    //alert($(e).attr("value"));
    $('#templateTable').bootstrapTable('refreshOptions',{
        queryParams: function (params) {
            return {
                // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: params.limit,
                page:(params.offset / params.limit) + 1,
                range:rangeValue,
                templateClassId:$(".list-group").find(".active").attr("value")
            };
        }
    });
}

/*function reloadTemplateTable(templateClassId,rangeValue){
    $('#templateTable').bootstrapTable('refreshOptions',{

        queryParams: function (params) {
            return {
                // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: params.limit,
                page:(params.offset / params.limit) + 1,
                range:rangeValue,
                templateClassId:$(".list-group").find(".active").attr("value")
            };
        }
    });
}*/

function loadTemplateTable(rangeValue){

    $('#templateTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: "/template/class/listEmrTemplateClass", // 服务器数据的加载地址
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                singleSelect: false, // 设置为true将禁止多选
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 server
                sortable: true,                     //是否启用排序
                sortOrder: "asc",
                queryParams: function (params) {
                    return {
                        // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        page:(params.offset / params.limit) + 1,
                        range:rangeValue,
                        templateClassId:$(".list-group").find(".active").attr("value")
                        /*sort: params.sort,      //排序列名
                        sortOrder: params.order, //排位命令（desc，asc）
                        name: $('#searchName').val(),
                        createStatus: $('input[name="status"]:checked').val()*/
                    };
                },
                columns: [
                    {
                        checkbox: true
                    },
                    {
                        field: 'templateId',
                        title: '序号',
                        formatter: function (value, row, index) {
                            return index + 1;
                        }
                    },
                    {
                        field: 'templateName',
                        title: '模板名称',
                        sortable: true
                    },
                    {
                        field: 'creator',
                        title: '创建人'
                    },
                    {
                        field: 'createTime',
                        title: '创建时间'
                    }
                    /*{
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a  class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit "></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            var f = '<a class="btn btn-success btn-sm ' + s_resetPwd_h + '" href="#" title="重置密码"  mce_href="#" onclick="resetPwd(\''
                                + row.id
                                + '\')"><i class="fa fa-key"></i></a> ';
                            var g = '<a class="btn btn-success btn-sm ' + s_resetPwd_h + '" href="#" title="新增"  mce_href="#" onclick="add(\''
                                + row.pkEmp
                                + '\')"><i class="fa fa-save"></i></a> ';
                            return g;
                        }
                    }*/
                ]
            });
}

var treeObj = $.fn.zTree.getZTreeObj("tree");
treeObj.expandAll(true);
