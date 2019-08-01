package io.renrenapi.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renrenapi.common.utils.Query;

import io.renrenapi.dao.BuildingDao;
import io.renrenapi.entity.BuildingEntity;
import io.renrenapi.service.BuildingService;


@Service("buildingService")
public class BuildingServiceImpl extends ServiceImpl<BuildingDao, BuildingEntity> implements BuildingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BuildingEntity> page = this.page(
                new Query<BuildingEntity>().getPage(params),
                new QueryWrapper<BuildingEntity>()
        );

        return new PageUtils(page);
    }

}
