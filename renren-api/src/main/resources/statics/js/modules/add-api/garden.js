$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'add-api/garden/list',
        datatype: "json",
        colModel: [			
			{ label: 'gardenId', name: 'gardenId', index: 'garden_id', width: 50, key: true },
			{ label: '园区名称', name: 'gardenName', index: 'garden_name', width: 80 }, 			
			{ label: '位置', name: 'location', index: 'location', width: 80 }, 			
			{ label: '地址', name: 'address', index: 'address', width: 80 }, 			
			{ label: '面积', name: 'acreage', index: 'acreage', width: 80 }, 			
			{ label: '价格范围', name: 'prices', index: 'prices', width: 80 }, 			
			{ label: '园区简介', name: 'intro', index: 'intro', width: 80 }, 			
			{ label: '园区特点', name: 'characteristics', index: 'characteristics', width: 80 }, 			
			{ label: '图片目录', name: 'image', index: 'image', width: 80 }, 			
			{ label: '层高', name: 'floorHeight', index: 'Floor_Height', width: 80 }, 			
			{ label: '开发商', name: 'developer', index: 'developer', width: 80 }, 			
			{ label: '物业', name: 'property', index: 'property', width: 80 }, 			
			{ label: '剩余房间', name: 'vacantRoom', index: 'vacant_room', width: 80 }, 			
			{ label: '创建时间', name: 'gmtCreate', index: 'gmt_create', width: 80 }, 			
			{ label: '', name: 'image2', index: 'image2', width: 80 }, 			
			{ label: '', name: 'image3', index: 'image3', width: 80 }			
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
		garden: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.garden = {};
		},
		update: function (event) {
			var gardenId = getSelectedRow();
			if(gardenId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(gardenId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.garden.gardenId == null ? "add-api/garden/save" : "add-api/garden/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.garden),
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
			var gardenIds = getSelectedRows();
			if(gardenIds == null){
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
                        url: baseURL + "add-api/garden/delete",
                        contentType: "application/json",
                        data: JSON.stringify(gardenIds),
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
		getInfo: function(gardenId){
			$.get(baseURL + "add-api/garden/info/"+gardenId, function(r){
                vm.garden = r.garden;
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