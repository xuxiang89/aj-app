package com.anjian.app.service.impl;

import com.anjian.app.common.PageUtils;
import com.anjian.app.common.Query;
import com.anjian.app.dao.SysAreaDao;
import com.anjian.app.entity.SysAreaEntity;
import com.anjian.app.service.SysAreaService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysAreaService")
public class SysAreaServiceImpl extends ServiceImpl<SysAreaDao, SysAreaEntity> implements SysAreaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysAreaEntity> page = this.selectPage(
                new Query<SysAreaEntity>(params).getPage(),
                new EntityWrapper<SysAreaEntity>()
        );

        return new PageUtils(page);
    }

}
