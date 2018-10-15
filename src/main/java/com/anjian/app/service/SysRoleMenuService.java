package com.anjian.app.service;

import com.anjian.app.entity.SysRoleMenuEntity;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;


public interface SysRoleMenuService extends IService<SysRoleMenuEntity> {
	
	void saveOrUpdate(Long roleId, List<Long> menuIdList);
	

	List<Long> queryMenuIdList(Long roleId);


	int deleteBatch(Long[] roleIds);
	
}
