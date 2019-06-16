package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.ManageDao;
import io.renren.modules.sys.entity.ManageEntity;
import io.renren.modules.sys.service.ManageService;


@Service("manageService")
public class ManageServiceImpl extends ServiceImpl<ManageDao, ManageEntity> implements ManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageEntity> page = this.page(
                new Query<ManageEntity>().getPage(params),
                new QueryWrapper<ManageEntity>()
        );

        return new PageUtils(page);
    }

}
