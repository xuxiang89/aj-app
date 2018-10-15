package com.anjian.app.service;


import com.anjian.app.common.PageUtils;
import com.anjian.app.entity.SysRoleEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;


public interface SysRoleService extends IService<SysRoleEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void save(SysRoleEntity role);

	void update(SysRoleEntity role);
	
	void deleteBatch(Long[] roleIds);

}
