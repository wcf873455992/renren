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
@TableName("tb_House")
public class HouseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long renttype;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Float unitprice;
	/**
	 * 
	 */
	private Float totalprice;
	/**
	 * 
	 */
	private Long buildingid;
	/**
	 * 
	 */
	private Long worknum;
	/**
	 * 
	 */
	private String heightcatedesc;
	/**
	 * 
	 */
	private Long visitnum;
	/**
	 * 
	 */
	private Float area;
	/**
	 * 装修
	 */
	private String decoratetypedesc;
	/**
	 * 
	 */
	private String rentexperience;
	/**
	 * 
	 */
	private Long evalutedegree;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private String pic;
	/**
	 * 
	 */
	private String traffic;
	/**
	 * 
	 */
	private String isfavorites;
	/**
	 * 维度
	 */
	private Float lat;
	/**
	 * 经度
	 */
	private Float lng;
	/**
	 * 朝向
	 */
	private String orientationdesc;
	/**
	 * 房间状态
	 */
	private String housestatus;
	/**
	 * 租金类型（按面积）
	 */
	private String renttypename;
	/**
	 * 分享链接
	 */
	private String houseshareurl;
	/**
	 * 
	 */
	private String houseshareurlwithlabels;
	/**
	 * 房型图
	 */
	private String housetypepicture;
	/**
	 * 房间特性
	 */
	private String housefeature;
	/**
	 * 房屋佣金
	 */
	private String houselabels;
	/**
	 * 佣金介绍
	 */
	private String brokeragedesc;
	/**
	 * 装修交付类型
	 */
	private String deliverystandard;
	/**
	 * 装修描述
	 */
	private String deliverydesc;
	/**
	 * 特殊服务
	 */
	private String specialexplain;
	/**
	 * 最短租期
	 */
	private String minrentperiod;
	/**
	 * 免租期
	 */
	private String remitrentperiod;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 
	 */
	private String supperoffice;
	/**
	 * 带看
	 */
	private Long housewithseecount;
	/**
	 * 
	 */
	private Long housewithsigndistance;
	/**
	 * 建筑类型
	 */
	private String buildingtype;
	/**
	 * 
	 */
	private Long buildingtypeid;

}
