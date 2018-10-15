package com.anjian.app.service;

import com.anjian.app.common.PageUtils;
import com.anjian.app.entity.SysAreaEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * 区域信息
 *
 * @author XuMinglu
 * @email 542686693@qq.com
 * @date 2018-04-17 23:54:04
 */
public interface SysAreaService extends IService<SysAreaEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

