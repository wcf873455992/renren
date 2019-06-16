package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.ManageEntity;
import io.renren.modules.sys.service.ManageService;
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
@RequestMapping("sys/manage")
public class ManageController {
    @Autowired
    private ManageService manageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:manage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = manageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:manage:info")
    public R info(@PathVariable("id") Integer id){
        ManageEntity manage = manageService.getById(id);

        return R.ok().put("manage", manage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:manage:save")
    public R save(@RequestBody ManageEntity manage){
        manageService.save(manage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:manage:update")
    public R update(@RequestBody ManageEntity manage){
        ValidatorUtils.validateEntity(manage);
        manageService.updateById(manage);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:manage:delete")
    public R delete(@RequestBody Integer[] ids){
        manageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
