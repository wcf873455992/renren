$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/room/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '房间号', name: 'number', index: 'number', width: 80 }, 			
			{ label: '公司名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '楼层', name: 'floor', index: 'floor', width: 80 }, 			
			{ label: '简介', name: 'intro', index: 'intro', width: 80 }, 			
			{ label: '总价', name: 'totalPrices', index: 'total_prices', width: 80 }, 			
			{ label: '单价', name: 'unitPrices', index: 'unit_prices', width: 80 }, 			
			{ label: '面积', name: 'acreage', index: 'acreage', width: 80 }, 			
			{ label: '装修', name: 'decorate', index: 'decorate', width: 80 }, 			
			{ label: '租用状态', name: 'leaseState', index: 'Lease_state', width: 80 }, 			
			{ label: '工位数', name: 'galleryful', index: 'galleryful', width: 80 }, 			
			{ label: '租期', name: 'deadline', index: 'deadline', width: 80 }, 			
			{ label: '房型图', name: 'map', index: 'map', width: 80 }, 			
			{ label: '所属园区', name: 'garden', index: 'garden', width: 80 }, 			
			{ label: '水费', name: 'waterBill', index: 'water_bill', width: 80 }, 			
			{ label: '水费截止时间', name: 'waterDeadline', index: 'water_deadline', width: 80 }, 			
			{ label: '电费', name: 'electricityBill', index: 'electricity_bill', width: 80 }, 			
			{ label: '电费截止时间', name: 'electricityDeadline', index: 'electricity_deadline', width: 80 }, 			
			{ label: '物业费', name: 'propertyCosts', index: 'Property_costs', width: 80 }, 			
			{ label: '物业费截止时间', name: 'propertyDeadline', index: 'Property_deadline', width: 80 }, 			
			{ label: '创建时间', name: 'gmtCreate', index: 'gmt_create', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		room: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.room = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.room.id == null ? "sys/room/save" : "sys/room/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.room),
                    success: function(r){
                        if(r.code === 0){
                             layer.msg("操作成功", {icon: 1});
                             vm.reload();
                             $('#btnSaveOrUpdate').button('reset');
                             $('#btnSaveOrUpdate').dequeue();
                        }else{
                            layer.alert(r.msg);
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        }
                    }
                });
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "sys/room/delete",
                        contentType: "application/json",
                        data: JSON.stringify(ids),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(id){
			$.get(baseURL + "sys/room/info/"+id, function(r){
                vm.room = r.room;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});