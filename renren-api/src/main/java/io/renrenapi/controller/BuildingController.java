package io.renrenapi.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renrenapi.entity.BuildingEntity;
import io.renrenapi.service.BuildingService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author wcf
 * @email 873455992@qq.com
 * @date 2019-08-01 16:57:05
 */
@CrossOrigin
@RestController
@RequestMapping("api/building")
@Api(tags = "园区管理")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    /**
     * 列表
     */
    @CrossOrigin
    @RequestMapping("/list")
    @ApiOperation(value = "列表",httpMethod = "POST")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = buildingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @CrossOrigin
    @RequestMapping("/info/{id}")
    @ApiOperation(value = "info",httpMethod = "POST")
    public R info(@PathVariable("id") Long id){
        BuildingEntity building = buildingService.getById(id);

        return R.ok().put("building", building);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BuildingEntity building){
        buildingService.save(building);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BuildingEntity building){
        ValidatorUtils.validateEntity(building);
        buildingService.updateById(building);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        buildingService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
