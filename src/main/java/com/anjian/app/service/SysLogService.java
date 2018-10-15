package com.anjian.app.service;


import com.anjian.app.common.PageUtils;
import com.anjian.app.entity.SysLogEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;


public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
