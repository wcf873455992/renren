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
 * @date 2019-06-16 18:35:02
 */
@Data
@TableName("tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 密码
	 */
	private String passwd;
	/**
	 * 用户类型（普通，租户）
	 */
	private String type;
	/**
	 * 所属房间号
	 */
	private String room;
	/**
	 * 所属园区
	 */
	private String garden;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;

}
