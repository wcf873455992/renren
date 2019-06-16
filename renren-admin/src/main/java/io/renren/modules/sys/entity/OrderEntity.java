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
@TableName("tb_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 订单编号
	 */
	private String number;
	/**
	 * 用户名字
	 */
	private String name;
	/**
	 * 所属房间号
	 */
	private String room;
	/**
	 * 所属园区
	 */
	private String garden;
	/**
	 * 缴费类型（水电。。。）
	 */
	private String type;
	/**
	 * 缴费方式
	 */
	private String paymentMethod;
	/**
	 * 缴费金额
	 */
	private Float paymentAmount;
	/**
	 * 缴费状态
	 */
	private String state;
	/**
	 * 缴费日期
	 */
	private Date date;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;

}
