package io.renrenapi.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renrenapi.entity.RoomEntity;
import io.renrenapi.service.RoomService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author wcf
 * @email 873455992@qq.com
 * @date 2019-06-25 15:31:08
 */
@RestController
@RequestMapping("renrenapi/room")
@Api(tags = "房间管理")
public class RoomController {
    @Autowired
    private RoomService roomService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @ApiOperation(value = "列表",httpMethod = "POST")
    @ApiOperation(value = "列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = roomService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{roomId}")
//    @ApiOperation(value = "房间信息",httpMethod = "POST")
    @ApiOperation(value = "房间信息")
    public R info(@PathVariable("roomId") Integer roomId){
        RoomEntity room = roomService.getById(roomId);

        return R.ok().put("room", room);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RoomEntity room){
        roomService.save(room);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RoomEntity room){
        ValidatorUtils.validateEntity(room);
        roomService.updateById(room);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] roomIds){
        roomService.removeByIds(Arrays.asList(roomIds));

        return R.ok();
    }

}
