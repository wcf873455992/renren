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
 * @date 2019-06-21 17:11:47
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
	private String image;
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
	/**
	 * 
	 */
	private String image2;
	/**
	 * 
	 */
	private String image3;

}
