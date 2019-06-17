package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.TbuserEntity;

import java.util.Map;

/**
 * 用户
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-17 11:12:24
 */
public interface TbuserService extends IService<TbuserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

