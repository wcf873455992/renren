package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.GardenEntity;
import io.renren.modules.sys.service.GardenService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-16 18:42:34
 */
@RestController
@RequestMapping("sys/garden")
//@Api(tags = "园区管理")
public class GardenController {
    @Autowired
    private GardenService gardenService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:garden:list")
//    @ApiOperation("获取园区列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gardenService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:garden:info")
    public R info(@PathVariable("id") Integer id){
        GardenEntity garden = gardenService.getById(id);

        return R.ok().put("garden", garden);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:garden:save")
    public R save(@RequestBody GardenEntity garden){
        gardenService.save(garden);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:garden:update")
    public R update(@RequestBody GardenEntity garden){
        ValidatorUtils.validateEntity(garden);
        gardenService.updateById(garden);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:garden:delete")
    public R delete(@RequestBody Integer[] ids){
        gardenService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
