$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'renrenapi/house/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'Id', width: 50, key: true },
			{ label: '', name: 'renttype', index: 'RentType', width: 80 }, 			
			{ label: '', name: 'name', index: 'Name', width: 80 }, 			
			{ label: '', name: 'unitprice', index: 'UnitPrice', width: 80 }, 			
			{ label: '', name: 'totalprice', index: 'TotalPrice', width: 80 }, 			
			{ label: '', name: 'buildingid', index: 'BuildingId', width: 80 }, 			
			{ label: '', name: 'worknum', index: 'WorkNum', width: 80 }, 			
			{ label: '', name: 'heightcatedesc', index: 'HeightCateDesc', width: 80 }, 			
			{ label: '', name: 'visitnum', index: 'VisitNum', width: 80 }, 			
			{ label: '', name: 'area', index: 'Area', width: 80 }, 			
			{ label: '装修', name: 'decoratetypedesc', index: 'DecorateTypeDesc', width: 80 }, 			
			{ label: '', name: 'rentexperience', index: 'RentExperience', width: 80 }, 			
			{ label: '', name: 'evalutedegree', index: 'EvaluteDegree', width: 80 }, 			
			{ label: '', name: 'description', index: 'Description', width: 80 }, 			
			{ label: '', name: 'pic', index: 'Pic', width: 80 }, 			
			{ label: '', name: 'traffic', index: 'Traffic', width: 80 }, 			
			{ label: '', name: 'isfavorites', index: 'IsFavorites', width: 80 }, 			
			{ label: '维度', name: 'lat', index: 'Lat', width: 80 }, 			
			{ label: '经度', name: 'lng', index: 'Lng', width: 80 }, 			
			{ label: '朝向', name: 'orientationdesc', index: 'OrientationDesc', width: 80 }, 			
			{ label: '房间状态', name: 'housestatus', index: 'HouseStatus', width: 80 }, 			
			{ label: '租金类型（按面积）', name: 'renttypename', index: 'RentTypeName', width: 80 }, 			
			{ label: '分享链接', name: 'houseshareurl', index: 'HouseShareUrl', width: 80 }, 			
			{ label: '', name: 'houseshareurlwithlabels', index: 'HouseShareurlWithLabels', width: 80 }, 			
			{ label: '房型图', name: 'housetypepicture', index: 'HouseTypePicture', width: 80 }, 			
			{ label: '房间特性', name: 'housefeature', index: 'HouseFeature', width: 80 }, 			
			{ label: '房屋佣金', name: 'houselabels', index: 'HouseLabels', width: 80 }, 			
			{ label: '佣金介绍', name: 'brokeragedesc', index: 'BrokerageDesc', width: 80 }, 			
			{ label: '装修交付类型', name: 'deliverystandard', index: 'DeliveryStandard', width: 80 }, 			
			{ label: '装修描述', name: 'deliverydesc', index: 'DeliveryDesc', width: 80 }, 			
			{ label: '特殊服务', name: 'specialexplain', index: 'SpecialExplain', width: 80 }, 			
			{ label: '最短租期', name: 'minrentperiod', index: 'MinRentPeriod', width: 80 }, 			
			{ label: '免租期', name: 'remitrentperiod', index: 'RemitRentPeriod', width: 80 }, 			
			{ label: '详细地址', name: 'address', index: 'Address', width: 80 }, 			
			{ label: '', name: 'supperoffice', index: 'SupperOffice', width: 80 }, 			
			{ label: '带看', name: 'housewithseecount', index: 'HouseWithSeeCount', width: 80 }, 			
			{ label: '', name: 'housewithsigndistance', index: 'HouseWithSignDistance', width: 80 }, 			
			{ label: '建筑类型', name: 'buildingtype', index: 'BuildingType', width: 80 }, 			
			{ label: '', name: 'buildingtypeid', index: 'BuildingTypeId', width: 80 }			
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
		house: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.house = {};
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
                var url = vm.house.id == null ? "renrenapi/house/save" : "renrenapi/house/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.house),
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
                        url: baseURL + "renrenapi/house/delete",
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
			$.get(baseURL + "renrenapi/house/info/"+id, function(r){
                vm.house = r.house;
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