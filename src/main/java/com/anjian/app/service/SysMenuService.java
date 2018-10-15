package com.anjian.app.service;


import com.anjian.app.entity.SysMenuEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;


public interface SysMenuService extends IService<SysMenuEntity> {


	List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);


	List<SysMenuEntity> queryListParentId(Long parentId);
	

	List<SysMenuEntity> queryNotButtonList();
	

	List<SysMenuEntity> getUserMenuList(Long userId);


	void delete(Long menuId);

	List<Map<String,Object>> queryForZtree();
}
