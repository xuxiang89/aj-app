package com.anjian.app.service;

import com.anjian.app.common.PageUtils;
import com.anjian.app.entity.SysUserEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;


public interface SysUserService extends IService<SysUserEntity> {

	PageUtils queryPage(Map<String, Object> params);
	

	List<Long> queryAllMenuId(Long userId);
	

	void save(SysUserEntity user);
	

	void update(SysUserEntity user);


	boolean updatePassword(Long userId, String password, String newPassword);

	List<SysUserEntity> queryUserList(SysUserEntity userEntity, boolean filtByDeptFlag);

	Map<String, Object> login(String username, String password);
}
