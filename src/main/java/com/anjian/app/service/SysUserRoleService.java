package com.anjian.app.service;

import com.anjian.app.entity.SysUserRoleEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;


public interface SysUserRoleService extends IService<SysUserRoleEntity>  {
	
	void saveOrUpdate(Long userId, List<Long> roleIdList);
	

	List<Long> queryRoleIdList(Long userId);


	int deleteBatch(Long[] roleIds);
}
