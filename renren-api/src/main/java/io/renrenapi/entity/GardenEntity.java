package io.renrenapi.entity;

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
 * @date 2019-06-20 20:12:24
 */
@Data
@TableName("tb_garden")
public class GardenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer gardenId;
	/**
	 * 园区名称
	 */
	private String gardenName;
	/**
	 * 位置
	 */
	private String location;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 面积
	 */
	private Float acreage;
	/**
	 * 价格范围
	 */
	private String prices;
	/**
	 * 园区简介
	 */
	private String intro;
	/**
	 * 园区特点
	 */
	private String characteristics;
	/**
	 * 图片目录
	 */
	private String picture;
	/**
	 * 层高
	 */
	private Float floorHeight;
	/**
	 * 开发商
	 */
	private String developer;
	/**
	 * 物业
	 */
	private String property;
	/**
	 * 剩余房间
	 */
	private Integer vacantRoom;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;

}
