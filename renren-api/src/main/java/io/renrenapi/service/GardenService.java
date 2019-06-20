package io.renrenapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renrenapi.entity.GardenEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-20 20:12:24
 */
public interface GardenService extends IService<GardenEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

