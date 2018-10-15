package com.anjian.app.dao;

import com.anjian.app.entity.SysMenuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;


public interface SysMenuDao extends BaseMapper<SysMenuEntity> {
	

	List<SysMenuEntity> queryListParentId(Long parentId);
	

	List<SysMenuEntity> queryNotButtonList();

	List<Map<String,Object>> queryForZtree();

}
