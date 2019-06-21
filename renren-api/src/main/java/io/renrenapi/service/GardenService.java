package io.renrenapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renrenapi.entity.GardenEntity;

import java.util.Map;

/**
 * 
 *
 * @author wcf
 * @email 873455992@qq.com
 * @date 2019-06-21 17:11:47
 */
public interface GardenService extends IService<GardenEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

