package io.renrenapi.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wcf
 * @email 873455992@qq.com
 * @date 2019-08-01 16:57:05
 */
@Data
@TableName("tb_Building")
public class BuildingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 地区
	 */
	private String address;
	/**
	 * 办公面积范围
	 */
	private String areas;
	/**
	 * 建筑详细地址
	 */
	private String buildingaddress;
	/**
	 * 园区介绍
	 */
	private String buildingintroduction;
	/**
	 * 建筑类型(自营等)
	 */
	private String buildingtype;
	/**
	 * 商圈
	 */
	private String circlename;
	/**
	 * 封面图片
	 */
	private String coverpic;
	/**
	 * 区地址
	 */
	private String districtname;
	/**
	 * 楼盘特点
	 */
	private String features;
	/**
	 * 佣金
	 */
	private String houselabels;
	/**
	 * 建筑名称
	 */
	private String name;
	/**
	 * 超级办公
	 */
	private String supperoffice;
	/**
	 * 单价
	 */
	private String unitprice;
	/**
	 * 最低价
	 */
	private Float unitpricenum;
	/**
	 * 访问数
	 */
	private Long visitnum;
	/**
	 * 待租数量
	 */
	private Long waittingrentcount;
	/**
	 * 纬度
	 */
	private Float latitude;
	/**
	 * 经度
	 */
	private Float longitude;
	/**
	 * 入住企业介绍
	 */
	private String settledenterprise;
	/**
	 * 分享链接
	 */
	private String shareurl;
	/**
	 * 建筑面积
	 */
	private String area;
	/**
	 * 建筑描述
	 */
	private String description;
	/**
	 * 开发商
	 */
	private String developer;
	/**
	 * 开发年份
	 */
	private Date developeryear;
	/**
	 * 标准层高
	 */
	private Double floorheight;
	/**
	 * 总楼层
	 */
	private Integer floornum;
	/**
	 * 电梯数
	 */
	private Integer liftnum;
	/**
	 * 停车位
	 */
	private Integer parkinglotnum;
	/**
	 * 物业公司
	 */
	private String propertycompany;
	/**
	 * 物业费
	 */
	private String propertyfee;

}
