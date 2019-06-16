package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.GardenDao;
import io.renren.modules.sys.entity.GardenEntity;
import io.renren.modules.sys.service.GardenService;


@Service("gardenService")
public class GardenServiceImpl extends ServiceImpl<GardenDao, GardenEntity> implements GardenService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GardenEntity> page = this.page(
                new Query<GardenEntity>().getPage(params),
                new QueryWrapper<GardenEntity>()
        );

        return new PageUtils(page);
    }

}
