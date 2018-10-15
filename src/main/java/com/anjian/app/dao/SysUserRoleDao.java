package com.anjian.app.dao;

import com.anjian.app.entity.SysUserRoleEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;


public interface SysUserRoleDao extends BaseMapper<SysUserRoleEntity> {
	

	List<Long> queryRoleIdList(Long userId);


	int deleteBatch(Long[] roleIds);
}
