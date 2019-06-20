/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renrenapi.io
 *
 * 版权所有，侵权必究！
 */

package io.renrenapi.controller;

import io.renrenapi.annotation.Login;
import io.renrenapi.annotation.LoginUser;
import io.renren.common.utils.R;
import io.renrenapi.entity.GoodEntity;
import io.renrenapi.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 测试接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/api")
@Api(tags="测试接口")
public class ApiTestController {

    @Login
    @GetMapping("userInfo")
    @ApiOperation(value="获取用户信息", response=UserEntity.class)
    public R userInfo(@ApiIgnore @LoginUser UserEntity user){

        return R.ok().put("user", user);
    }

    @Login
    @GetMapping("userId")
    @ApiOperation("获取用户ID")
    @ApiImplicitParam(name = "token")
    public R userInfo(@ApiIgnore @RequestAttribute("userId") Integer userId){

        return R.ok().put("userId", userId);
    }

    @GetMapping("notToken")
    @ApiOperation("忽略Token验证测试")
    public R notToken(){

        return R.ok().put("msg", "无需token也能访问。。。");
    }


    @GetMapping("goodlist")
    @ApiOperation(value="获取园区信息", response= GoodEntity.class)
    public R goodInfo(  GoodEntity good){

        return R.ok().put("user", good);
    }
}
