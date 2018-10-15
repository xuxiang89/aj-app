package com.anjian.app.dao;

import com.anjian.app.entity.SysUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;


public interface SysUserDao extends BaseMapper<SysUserEntity> {
	

	List<String> queryAllPerms(Long userId);
	

	List<Long> queryAllMenuId(Long userId);

	List<SysUserEntity> queryUserList(Map<String, Object> params);

}
