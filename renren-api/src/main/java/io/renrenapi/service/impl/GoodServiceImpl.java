/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renrenapi.io
 *
 * 版权所有，侵权必究！
 */

package io.renrenapi.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.exception.RRException;
import io.renren.common.validator.Assert;
import io.renrenapi.dao.GoodDao;
import io.renrenapi.dao.UserDao;
import io.renrenapi.entity.GoodEntity;
import io.renrenapi.entity.TokenEntity;
import io.renrenapi.entity.UserEntity;
import io.renrenapi.form.LoginForm;
import io.renrenapi.service.GoodService;
import io.renrenapi.service.TokenService;
import io.renrenapi.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("GoodService")
public class GoodServiceImpl extends ServiceImpl<GoodDao, GoodEntity> implements GoodService {
	@Autowired
	private TokenService tokenService;

//	@Override
//	public UserEntity queryByMobile(String mobile) {
//		return baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("mobile", mobile));
//	}

	@Override
	public GoodEntity queryByGardenId(String gardenid) {
		return baseMapper.selectOne(new QueryWrapper<GoodEntity>().eq("garden_id", gardenid));
	}

//	@Override
//	public Map<String, Object> login(LoginForm form) {
//		UserEntity user = queryByMobile(form.getMobile());
//		Assert.isNull(user, "手机号或密码错误");
//
//		//密码错误
//		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
//			throw new RRException("手机号或密码错误");
//		}
//
//		//获取登录token
//		TokenEntity tokenEntity = tokenService.createToken(user.getUserId());
//
//		Map<String, Object> map = new HashMap<>(2);
//		map.put("token", tokenEntity.getToken());
//		map.put("username", user.getUsername());
//		map.put("expire", tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());
//
//		return map;
//	}

	@Override
	public Map<String, Object> list(LoginForm form) {
		GoodEntity good = queryByGardenId(form.getMobile());

		Map<String, Object> map = new HashMap<>(2);
		map.put("garden_name", good.getUsername());
		return map;
	}

}
