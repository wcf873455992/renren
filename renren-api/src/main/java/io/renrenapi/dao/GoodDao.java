/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renrenapi.io
 *
 * 版权所有，侵权必究！
 */

package io.renrenapi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renrenapi.entity.GoodEntity;
import io.renrenapi.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface GoodDao extends BaseMapper<GoodEntity> {

}
