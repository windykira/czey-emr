$(function(){

    initTable($("#hisCallType").val());
})

function cancel(){

    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}
var element = "";
function initTable(hisCallType){

    var columns = "";
    switch (hisCallType){
        case "1":
            element = $("#doctorAdvice");
            columns = [
                {
                    checkbox: true
                },
                {
                    field: 'patientId',
                    title: '住院号',
                    formatter: function (value, row, index) {
                        return index + 1;
                    }
                },
                {
                    field: 'orderText',
                    title: '医嘱内容'
                },
                {
                    field: 'freqDetail',
                    title: '医嘱辅助信息'
                },
                {
                    field: 'startDateTime',
                    title: '医嘱开始日期'
                },
                {
                    field: 'endDateTime',
                    title: '医嘱停止日期'
                }
            ];break;
        case "2":
            element = $("#checkUp");
            columns = [
                {
                    checkbox: true
                },
                {
                    field: 'checkNo',
                    title: '编号',
                    formatter: function (value, row, index) {
                        return index + 1;
                    }
                },
                {
                    field: 'checkClass',
                    title: '检查类型'
                },
                {
                    field: 'applyTime',
                    title: '时间'
                }
            ];break;
        case "3":
            element = $("#inspect");
            columns = [
                {
                    checkbox: true
                },
                {
                    field: 'checkNo',
                    title: '编号',
                    formatter: function (value, row, index) {
                        return index + 1;
                    }
                },
                {
                    field: 'checkClass',
                    title: '检查类型'
                },
                {
                    field: 'applyTime',
                    title: '时间'
                }
            ];break;
        case "4":
            element = $("#prescription");
            columns = [
                {
                    checkbox: true
                },
                {
                    field: 'patientId',
                    title: '编号',
                    formatter: function (value, row, index) {
                        return index + 1;
                    }
                },
                {
                    field: 'orderedBy',
                    title: '科室'
                },
                {
                    field: 'performedNameBy',
                    title: '药房'
                },
                {
                    field: 'prescriber',
                    title: '姓名'
                }
            ];break;
    }

    var params = {
        hisCallType:hisCallType,
        patientId:"343939"
    };

    element.bootstrapTable(
        {
            method: 'get', // 服务器数据的请求方式 get or post
            url: "/emr/emrwriting/listHisResponseDatas", // 服务器数据的加载地址
            iconSize: 'outline',
            toolbar: '#exampleToolbar',
            /*onCheck:function(row,$element){
                //$element.children().toggleClass("rowChecked");
                $(element).parent().parent().children().addClass("rowChecked");
            },*/
            striped: true, // 设置为true会有隔行变色效果
            dataType: "json", // 服务器返回的数据类型
            pagination: true, // 设置为true会在底部显示分页条
            singleSelect: false, // 设置为true将禁止多选
            pageSize: 10, // 如果设置了分页，每页数据条数
            pageNumber: 1, // 如果设置了分布，首页页码
            showColumns: false, // 是否显示内容下拉框（选择显示的列）
            sidePagination: "client", // 设置在哪里进行分页，可选值为"client" 或者 server
            sortable: true,                     //是否启用排序
            sortOrder: "asc",
            queryParams : params,
            /*queryParams: function (params) {
             return {
             //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
             limit: params.limit,
             page:(params.offset / params.limit) + 1,
             patientId:"343939"
             sort: params.sort,      //排序列名
             sortOrder: params.order, //排位命令（desc，asc）
             name: $('#searchName').val(),
             createStatus: $('input[name="status"]:checked').val()
             };
             },*/
            columns: columns
        });
    }

    function importReport(){

        var ctl = parent.document.getElementById("myWriter");
        var rows = element.bootstrapTable('getSelections');

        var reportContent = "";
        $.each(rows, function (i, row) {
            reportContent += row.doctorSign + row.orderText;
        });
        ctl.ExecuteCommand("InsertString", false, reportContent);
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }