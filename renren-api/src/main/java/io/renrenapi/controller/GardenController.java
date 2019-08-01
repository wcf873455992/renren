package io.renrenapi.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renrenapi.entity.GardenEntity;
import io.renrenapi.service.GardenService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-20 20:12:24
 */

@CrossOrigin
@RestController
@RequestMapping("api/garden")
@Api(tags = "园区管理")
public class GardenController {
    @Autowired
    private GardenService gardenService;

    /**
     * 列表
     */
    @CrossOrigin
    @RequestMapping("/list")
    @ApiOperation(value = "列表",httpMethod = "POST")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gardenService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @CrossOrigin
    @RequestMapping("/info/{gardenId}")
    @ApiOperation(value = "info",httpMethod = "POST")
    public R info(@PathVariable("gardenId") Integer gardenId){
        GardenEntity garden = gardenService.getById(gardenId);

        return R.ok().put("garden", garden);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GardenEntity garden){
        gardenService.save(garden);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GardenEntity garden){
        ValidatorUtils.validateEntity(garden);
        gardenService.updateById(garden);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] gardenIds){
        gardenService.removeByIds(Arrays.asList(gardenIds));

        return R.ok();
    }

}
