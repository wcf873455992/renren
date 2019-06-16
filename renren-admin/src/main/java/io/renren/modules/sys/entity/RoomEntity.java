package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-16 18:42:34
 */
@Data
@TableName("tb_room")
public class RoomEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 房间号
	 */
	private String number;
	/**
	 * 公司名称
	 */
	private String name;
	/**
	 * 楼层
	 */
	private Integer floor;
	/**
	 * 简介
	 */
	private String intro;
	/**
	 * 总价
	 */
	private Float totalPrices;
	/**
	 * 单价
	 */
	private Float unitPrices;
	/**
	 * 面积
	 */
	private Float acreage;
	/**
	 * 装修
	 */
	private String decorate;
	/**
	 * 租用状态
	 */
	private String leaseState;
	/**
	 * 工位数
	 */
	private Integer galleryful;
	/**
	 * 租期
	 */
	private Date deadline;
	/**
	 * 房型图
	 */
	private String map;
	/**
	 * 所属园区
	 */
	private String garden;
	/**
	 * 水费
	 */
	private Float waterBill;
	/**
	 * 水费截止时间
	 */
	private Date waterDeadline;
	/**
	 * 电费
	 */
	private Float electricityBill;
	/**
	 * 电费截止时间
	 */
	private Date electricityDeadline;
	/**
	 * 物业费
	 */
	private Float propertyCosts;
	/**
	 * 物业费截止时间
	 */
	private Date propertyDeadline;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;

}
