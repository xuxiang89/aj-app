package com.anjian.app.service.impl;

import com.anjian.app.common.PageUtils;
import com.anjian.app.common.Query;
import com.anjian.app.dao.SysRecordOperDao;
import com.anjian.app.entity.SysRecordOperEntity;
import com.anjian.app.service.SysRecordOperService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysRecordOperService")
public class SysRecordOperServiceImpl extends ServiceImpl<SysRecordOperDao, SysRecordOperEntity> implements SysRecordOperService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysRecordOperEntity> page = this.selectPage(
                new Query<SysRecordOperEntity>(params).getPage(),
                new EntityWrapper<SysRecordOperEntity>()
        );

        return new PageUtils(page);
    }

}
