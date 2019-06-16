package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.RoomDao;
import io.renren.modules.sys.entity.RoomEntity;
import io.renren.modules.sys.service.RoomService;


@Service("roomService")
public class RoomServiceImpl extends ServiceImpl<RoomDao, RoomEntity> implements RoomService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RoomEntity> page = this.page(
                new Query<RoomEntity>().getPage(params),
                new QueryWrapper<RoomEntity>()
        );

        return new PageUtils(page);
    }

}
