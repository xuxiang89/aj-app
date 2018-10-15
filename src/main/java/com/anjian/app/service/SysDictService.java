package com.anjian.app.service;

import com.anjian.app.common.PageUtils;
import com.anjian.app.entity.SysDictEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;


public interface SysDictService extends IService<SysDictEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

