$(function() {
    load();
});
function load() {
    $.ajax({
        url:"/emr/patient/getPatientList",
        dataType:"json",
        data:{
            name : $('#name').val(),
            bedNo : $('#bedNo').val(),
            patientId : $('#patientId').val(),
            type : $('#typeSel').val()
        },
        success:function(data){
//			console.log(data);
            var patientJson = data.date;
//             myWriter.ExecuteCommand("InsertXML", false, data);
//            $('#exampleTable').bootstrapTable('hideLoading');
            $('#exampleTable')
                .bootstrapTable(
                    {
//					method : 'get', // 服务器数据的请求方式 get or post
//					url : prefix + "/list", // 服务器数据的加载地址
                        // showRefresh : true,
                        // showToggle : true,
                        // showColumns : true,
                        iconSize : 'outline',
                        formatLoadingMessage: function(){
                            return null;
                        },
                        //toolbar : '#exampleToolbar',
                        //search:true,
                        striped : true, // 设置为true会有隔行变色效果
                        data : patientJson,
                        dataType : "json", // 服务器返回的数据类型
                        pagination : true, // 设置为true会在底部显示分页条
                        // queryParamsType : "limit",
                        // //设置为limit则会发送符合RESTFull格式的参数
                        singleSelect : false, // 设置为true将禁止多选
                        // contentType : "application/x-www-form-urlencoded",
                        // //发送到服务器的数据编码类型
                        pageSize : 10, // 如果设置了分页，每页数据条数
                        pageNumber : 1, // 如果设置了分布，首页页码
                        // search : true, // 是否显示搜索框
                        showColumns : false, // 是否显示内容下拉框（选择显示的列）
                        sidePagination : "client", // 设置在哪里进行分页，可选值为"client" 或者
                        // "server"
                        onLoadSuccess:function(){
                            alert(1)
                            $(".fixed-table-loading").hide();
                        },
                        uniqueId : 'PATIENT_ID',
                        columns : [
                            {
                                checkbox : true
                            },
                            {
                                field : 'PATIENT_ID', // 列字段名
                                title : 'id', // 列标题
                                visible : false
                            },

                            {
                                field : 'BED_NO',
                                title : '床号'
                            },
                            {
                                field : 'NAME',
                                title : '姓名'
                            },
                            {
                                field : 'SEX',
                                title : '性别'
                            },
                            {
                                field : 'AGE',
                                title : '年龄'
                            },
                            {
                                field : 'CHARGE_TYPE',
                                title : '费用类型'
                            },
                            {
                                field : 'DEPT_ALIAS',
                                title : '所在病区'
                            },
                            {
                                field : 'INDATE',
                                title : '入院时间'
                            },
                            {
                                field : 'DIAGNOSIS',
                                title : '主要诊断'
                            },
                            {
                                field : 'DOCTNAME',
                                title : '喻强'
                            },
                            {
                                title : '操作',
                                field : 'NAME',
                                align : 'center',
                                formatter : function(value, row, index) {
                                    var btn = '<button type="button" class="btn  btn-primary" onclick="add('+row.PATIENT_ID+')"><i class="fa fa-plus hidden" aria-hidden="true"></i>写病历 </button>';
                                    return btn;
                                }
                            }
//						{
//							field : 'pyCode',
//							title : '拼音码'
//						},
//						{
//							field : 'wbCode',
//							title : '五笔码'
//						}
                        ]
                    });
        },
        error:function(){
            alert("读取出错");
        }
    })

}
function reLoad() {
    //$('#exampleTable').bootstrapTable('refresh');
    load();
}