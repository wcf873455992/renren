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

import io.renren.modules.sys.entity.TbuserEntity;
import io.renren.modules.sys.service.TbuserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 用户
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-17 11:12:24
 */
@RestController
@RequestMapping("sys/tbuser")
public class TbuserController {
    @Autowired
    private TbuserService tbuserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:tbuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tbuserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:tbuser:info")
    public R info(@PathVariable("userId") Long userId){
        TbuserEntity tbuser = tbuserService.getById(userId);

        return R.ok().put("tbuser", tbuser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:tbuser:save")
    public R save(@RequestBody TbuserEntity tbuser){
        tbuserService.save(tbuser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:tbuser:update")
    public R update(@RequestBody TbuserEntity tbuser){
        ValidatorUtils.validateEntity(tbuser);
        tbuserService.updateById(tbuser);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:tbuser:delete")
    public R delete(@RequestBody Long[] userIds){
        tbuserService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}
