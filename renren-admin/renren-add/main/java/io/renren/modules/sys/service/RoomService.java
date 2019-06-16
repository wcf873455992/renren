package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.RoomEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-16 18:35:02
 */
public interface RoomService extends IService<RoomEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

