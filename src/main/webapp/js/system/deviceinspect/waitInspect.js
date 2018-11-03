
var pageii = null;
var grid = null;
$(function() {
    
    $.ajax({
        type:"GET",
        url:"/inspect/updateWaitInspect.shtml",
        async:true,
        success:function (data) {
            if (!data){
                alert("更新点检信息失败");
            }
        },
    });

    loadData();

    $("#search").click("click", function() {// 绑定查询按扭
        alert("test");
        var searchParams = $("#searchForm").serializeJson();// 初始化传参数
        grid.setOptions({
            data : searchParams
        });
    });
    $("#excuInspect").click("click",function(){
        excuInspect();
    })

});
function excuInspect(){
    var cbox = grid.getSelectedCheckbox();
    if (cbox.length > 1 || cbox == "") {
        layer.msg("只能选中一个");
        return;
    }
    $.ajax({
        type:"GET",
        url:"/inspect/executeWaitInspect.shtml",
        data:{"ids":cbox[0]},
        success:function (data) {
            if (data){
                alert("执行成功!");
            }else{
                alert("执行失败!");
            }
            loadData();
        }
    });
}

function  loadData() {
    grid = lyGrid({
        pagId : 'paging',
        l_column : [{
            colkey : "id",
            isSort:true,
            name:"id",
            width: '35px'
        }, {
            colkey : "dnumber",
            name : "点检设备编号",
        },{
            colkey : "inspectman",
            name : "计划点检人员",
        },{
            colkey : "dname",
            name : "点检设备名称"
        },{
            colkey : "inspectinfo",
            name : "点检项目",
            width:'300px'
        },{
            colkey : "inspectrule",
            name : "点检标准",
            width:'300px'
        },{
            colkey : "name",
            name : "计划名称"
        },{
            colkey : "cycle",
            name : "周期"
        }],
        jsonUrl : rootPath + '/inspect/findWaitInspectByPage.shtml',
        checkbox : true,
        serNumber : true
    });
}
