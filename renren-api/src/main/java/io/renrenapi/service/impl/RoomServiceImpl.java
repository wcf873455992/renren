package io.renrenapi.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renrenapi.common.utils.Query;

import io.renrenapi.dao.RoomDao;
import io.renrenapi.entity.RoomEntity;
import io.renrenapi.service.RoomService;


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

//    @Override
    public PageUtils queryList(Map<String, Object> gardenID) {
        IPage<RoomEntity> page = this.page(
                new Query<RoomEntity>().getPage(gardenID),
                new QueryWrapper<RoomEntity>()
        );

        return new PageUtils(page);
    }

}
