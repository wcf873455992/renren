$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'renrenapi/building/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'Id', width: 50, key: true },
			{ label: '地区', name: 'address', index: 'Address', width: 80 }, 			
			{ label: '办公面积范围', name: 'areas', index: 'Areas', width: 80 }, 			
			{ label: '建筑详细地址', name: 'buildingaddress', index: 'BuildingAddress', width: 80 }, 			
			{ label: '园区介绍', name: 'buildingintroduction', index: 'BuildingIntroduction', width: 80 }, 			
			{ label: '建筑类型(自营等)', name: 'buildingtype', index: 'BuildingType', width: 80 }, 			
			{ label: '商圈', name: 'circlename', index: 'CircleName', width: 80 }, 			
			{ label: '封面图片', name: 'coverpic', index: 'CoverPic', width: 80 }, 			
			{ label: '区地址', name: 'districtname', index: 'DistrictName', width: 80 }, 			
			{ label: '楼盘特点', name: 'features', index: 'Features', width: 80 }, 			
			{ label: '佣金', name: 'houselabels', index: 'HouseLabels', width: 80 }, 			
			{ label: '建筑名称', name: 'name', index: 'Name', width: 80 }, 			
			{ label: '超级办公', name: 'supperoffice', index: 'SupperOffice', width: 80 }, 			
			{ label: '单价', name: 'unitprice', index: 'UnitPrice', width: 80 }, 			
			{ label: '最低价', name: 'unitpricenum', index: 'UnitPriceNum', width: 80 }, 			
			{ label: '访问数', name: 'visitnum', index: 'VisitNum', width: 80 }, 			
			{ label: '待租数量', name: 'waittingrentcount', index: 'WaittingRentCount', width: 80 }, 			
			{ label: '纬度', name: 'latitude', index: 'Latitude', width: 80 }, 			
			{ label: '经度', name: 'longitude', index: 'Longitude', width: 80 }, 			
			{ label: '入住企业介绍', name: 'settledenterprise', index: 'SettledEnterprise', width: 80 }, 			
			{ label: '分享链接', name: 'shareurl', index: 'ShareUrl', width: 80 }, 			
			{ label: '建筑面积', name: 'area', index: 'Area', width: 80 }, 			
			{ label: '建筑描述', name: 'description', index: 'Description', width: 80 }, 			
			{ label: '开发商', name: 'developer', index: 'Developer', width: 80 }, 			
			{ label: '开发年份', name: 'developeryear', index: 'DeveloperYear', width: 80 }, 			
			{ label: '标准层高', name: 'floorheight', index: 'FloorHeight', width: 80 }, 			
			{ label: '总楼层', name: 'floornum', index: 'FloorNum', width: 80 }, 			
			{ label: '电梯数', name: 'liftnum', index: 'LiftNum', width: 80 }, 			
			{ label: '停车位', name: 'parkinglotnum', index: 'ParkingLotNum', width: 80 }, 			
			{ label: '物业公司', name: 'propertycompany', index: 'PropertyCompany', width: 80 }, 			
			{ label: '物业费', name: 'propertyfee', index: 'PropertyFee', width: 80 }			
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
		building: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.building = {};
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
                var url = vm.building.id == null ? "renrenapi/building/save" : "renrenapi/building/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.building),
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
                        url: baseURL + "renrenapi/building/delete",
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
			$.get(baseURL + "renrenapi/building/info/"+id, function(r){
                vm.building = r.building;
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