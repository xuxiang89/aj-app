package com.anjian.app.dao;

import com.anjian.app.entity.SysRoleMenuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;


public interface SysRoleMenuDao extends BaseMapper<SysRoleMenuEntity> {
	

	List<Long> queryMenuIdList(Long roleId);


	int deleteBatch(Long[] roleIds);
}
