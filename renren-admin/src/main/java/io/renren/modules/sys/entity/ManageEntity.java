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
@TableName("tb_manage")
public class ManageEntity implements Serializable {
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
	 * 权限
	 */
	private String authority;
	/**
	 * 所属园区
	 */
	private String garden;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;

}
