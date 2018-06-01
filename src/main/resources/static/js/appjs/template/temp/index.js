
var prefix = "/template/temp";
var templateName;
var rangeSel;
var typeSel;
var openFlag = 0;
$(function() {
	load();
});

function load() {
     //$(".selectpicker").selectpicker({
     //    noneSelectedText : '请选择',//默认显示内容
     //    width: 100,
     //    style: 'btn-white',
     //    liveSearch: false
     //});
	 $.ajax({  
         type : 'get',  
         url : prefix + "/getTypes",  
         dataType : 'json',  
         success : function(datas) {//返回list数据并循环获取  
             var select = $("#type_sel");
             select.append("<option value=''> </option>");
             for (var i = 0; i < datas.length; i++) {  
                 select.append("<option value='"+datas[i].PK_TMP_CLASS+"'>"  
                         + datas[i].NAME_CLASS + "</option>");  
             }  
        	 var select = $("#status_sel");
             select.append("<option value=''> </option>");
             select.append("<option value='0'>可用</option>");
             select.append("<option value='1'>不可用</option>");
        	 
        	 var select = $("#range_sel");
             select.append("<option value=''> </option>");
             select.append("<option value='QY'>全院</option>");
             select.append("<option value='KS'>科室</option>");
        	 select.append("<option value='GR'>个人</option>");  

         }
     });  
	 $('#exampleTable')
     .bootstrapTable(
         {
             method: 'get', // 服务器数据的请求方式 get or post
             url: prefix + "/list", // 服务器数据的加载地址
             cache: false,//禁用缓存 默认为true
             // showRefresh : true,
             // showToggle : true,
             // showColumns : true,
             iconSize: 'outline',
             toolbar: '#exampleToolbar',
             striped: true, // 设置为true会有隔行变色效果
             dataType: "json", // 服务器返回的数据类型
             pagination: true, // 设置为true会在底部显示分页条
             // queryParamsType : "limit",
             // //设置为limit则会发送符合RESTFull格式的参数
             singleSelect: false, // 设置为true将禁止多选
             // contentType : "application/x-www-form-urlencoded",
             // //发送到服务器的数据编码类型
             pageSize: 10, // 如果设置了分页，每页数据条数
             pageNumber: 1, // 如果设置了分布，首页页码
             // search : true, // 是否显示搜索框
             showColumns: false, // 是否显示内容下拉框（选择显示的列）
             sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 server
             sortable: true,                     //是否启用排序
             sortOrder: "asc",
             // "server"
             queryParams: function (params) {
                 return {
                     // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                     limit: params.limit,
                     //offset: params.offset,
                     //pageNumber:params.limit,//每页记录数
                     //pageSize:(params.offset / params.limit) + 1,//页码
                     page:(params.offset / params.limit) + 1,
                     sort: params.sort,      //排序列名
                     sortOrder: params.order, //排位命令（desc，asc）
                     range: $('#range_sel').val(),
                     type : $('#type_sel').val(),
                     status : $('#status_sel').val(),
                     name : $('#name').val()
                 };
             },
             // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
             // queryParamsType = 'limit' ,返回参数必须包含
             // limit, offset, search, sort, order 否则, 需要包含:
             // pageSize, pageNumber, searchText, sortName,
             // sortOrder.
             // 返回false将会终止请求
             columns: [
                 {
                     checkbox: true
                 },
                 {
                     field: 'pkTemplate', // 列字段名
                     title: '序号', // 列标题
                     formatter: function (value, row, index) {
                         return index + 1;
                     }
                 },
                 {
                     field: 'stopFlag',
                     title: '状态',
                     sortable: true,
                     formatter: function (value, row, index) {
                    	 if(value==='0'){
                    		 return '可用';
                    	 }
                    	 if(value==='1'){
                    		 return '不可用';
                    	 }
                     }
                 },
                 {
                     field: 'tmpClassName',
                     title: '模板类型',
                     sortable: true
                 },
                 {
                     field: 'nameTmp',
                     title: '模板名称',
                 },
                 {
                     field: 'creatorName',
                     title: '创建人'
                 },
                 {
                     field: 'createTimeString',
                     title: '创建时间'
                 },
                 {
                     field: 'range',
                     title: '适用范围',
                     formatter: function (value, row, index) {
                    	 if(value==='QY'){
                    		 return '全院';
                    	 }
                    	 if(value==='KS'){
                    		 return '科室';
                    	 }
                    	 if(value==='GR'){
                    		 return '个人';
                    	 }
                     }
                 }
                ]
         });
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add',
		end : function(){

		}
	});
}
var index1;
function loadEditPage(){
    index1 =layer.open({
        type : 2,
        title : '增加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : '/emr/dc/index',
        yes : function(index, layero){
            myWindow = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
        },

    });
    //layer.full(index1);
}
