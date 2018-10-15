package com.anjian.app.service;

import com.anjian.app.common.PageUtils;
import com.anjian.app.entity.SysRecordOperEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * 系统增删改日志
 *
 * @author XuMinglu
 * @email 542686693@qq.com
 * @date 2018-03-21 17:51:17
 */
public interface SysRecordOperService extends IService<SysRecordOperEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

