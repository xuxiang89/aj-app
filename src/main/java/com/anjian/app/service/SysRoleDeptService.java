package com.anjian.app.service;

import com.anjian.app.entity.SysRoleDeptEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;


public interface SysRoleDeptService extends IService<SysRoleDeptEntity> {
	
	void saveOrUpdate(Long roleId, List<Long> deptIdList);
	

	List<Long> queryDeptIdList(Long[] roleIds) ;


	int deleteBatch(Long[] roleIds);
}
