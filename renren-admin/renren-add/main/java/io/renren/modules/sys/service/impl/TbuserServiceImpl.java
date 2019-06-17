package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.TbuserDao;
import io.renren.modules.sys.entity.TbuserEntity;
import io.renren.modules.sys.service.TbuserService;


@Service("tbuserService")
public class TbuserServiceImpl extends ServiceImpl<TbuserDao, TbuserEntity> implements TbuserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TbuserEntity> page = this.page(
                new Query<TbuserEntity>().getPage(params),
                new QueryWrapper<TbuserEntity>()
        );

        return new PageUtils(page);
    }

}
