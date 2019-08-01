package io.renrenapi.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renrenapi.common.utils.Query;

import io.renrenapi.dao.HouseDao;
import io.renrenapi.entity.HouseEntity;
import io.renrenapi.service.HouseService;


@Service("houseService")
public class HouseServiceImpl extends ServiceImpl<HouseDao, HouseEntity> implements HouseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HouseEntity> page = this.page(
                new Query<HouseEntity>().getPage(params),
                new QueryWrapper<HouseEntity>()
        );

        return new PageUtils(page);
    }

}
