package io.renrenapi.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renrenapi.entity.HouseEntity;
import io.renrenapi.service.HouseService;
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
@RequestMapping("api/house")
@Api(tags = "House管理")
public class HouseController {
    @Autowired
    private HouseService houseService;

    /**
     * 列表
     */
    @CrossOrigin
    @RequestMapping("/list")
    @ApiOperation(value = "列表",httpMethod = "POST")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = houseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @CrossOrigin
    @RequestMapping("/info/{id}")
    @ApiOperation(value = "房间信息",httpMethod = "POST")
    public R info(@PathVariable("id") Long id){
        HouseEntity house = houseService.getById(id);

        return R.ok().put("house", house);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HouseEntity house){
        houseService.save(house);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HouseEntity house){
        ValidatorUtils.validateEntity(house);
        houseService.updateById(house);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        houseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
