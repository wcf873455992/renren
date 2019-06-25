package io.renrenapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renrenapi.entity.RoomEntity;

import java.util.Map;

/**
 * 
 *
 * @author wcf
 * @email 873455992@qq.com
 * @date 2019-06-25 15:31:08
 */
public interface RoomService extends IService<RoomEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

