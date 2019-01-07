var pageii = null;
var grid = null;
$(function() {
    grid = lyGrid({
        l_column : [{
            colkey:'itemId',
            name:'编号',
            width	:"150px"
        },{
            colkey:'itemName',
            name:'名称',
            width	:"150px"
        },{
            colkey:'itemSpc',
            name:'规格',
            width	:"150px"
        },{
            colkey:'itemUnit',
            name:'单位',
            width	:"150px"
        },{
            colkey:'itemBatch',
            name:'批号',
            width	:"150px"
        },{
            colkey:'proType',
            name:'属性',
            width	:"150px"
        },{
            colkey:'luHao',
            name:'采购合同号',
            width	:"150px"
        },{
            colkey:'prvName',
            name:'客户/供应商',
            width	:"150px"
        },{
            colkey:'psName',
            name:'状态',
            width	:"150px"
        },{
            colkey:'numIs',
            name:'数量',
            width	:"150px"
        },{
            colkey:'wareName',
            name:'仓库',
            width	:"150px"
        }],
        jsonUrl : rootPath + '/devicem/findDeviceStorageList.shtml',
        checkbox : true,
        serNumber : true
    });
    $("#button").click("click", function() {
        var searchParams = $("#form").serializeJson();// 初始化传参数
        grid.setOptions({
            data : searchParams
        });
    });
})

