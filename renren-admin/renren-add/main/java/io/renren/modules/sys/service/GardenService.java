package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.GardenEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-16 18:35:02
 */
public interface GardenService extends IService<GardenEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

