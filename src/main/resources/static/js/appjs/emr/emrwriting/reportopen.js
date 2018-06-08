$(function(){


});

function openReport(hisCallType){

    layer.open({
        type: 2,
        closeBtn:0,
        title: false,
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['1100px', '620px'],
        offset:['300px', '450px'],
        content: '/emr/emrwriting/reportimport/' + hisCallType
    });
}