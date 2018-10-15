package com.anjian.app.dao;

import com.anjian.app.entity.SysRoleDeptEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;


public interface SysRoleDeptDao extends BaseMapper<SysRoleDeptEntity> {
	

	List<Long> queryDeptIdList(Long[] roleIds);


	int deleteBatch(Long[] roleIds);
}
