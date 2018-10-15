package com.anjian.app.service;


import com.anjian.app.entity.SysDeptEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;


public interface SysDeptService extends IService<SysDeptEntity> {

	List<SysDeptEntity> queryList(Map<String, Object> map);


	List<Long> queryDetpIdList(Long parentId);


	List<Long> getSubDeptIdList(Long deptId);

	/**
	 * 获取当前部门节点的所有上级部门的信息: 如：DeptCode
	 * @param curEntity
	 * @return
	 */
	SysDeptEntity getCurDeptWithUpperDepts(SysDeptEntity curEntity);

	/**
	 * 迭代返回Dept部门的层级关系
	 * @param curEntity
	 * @param returnEntityList
	 * @return
	 */
	public List<SysDeptEntity> getParentDeptList(SysDeptEntity curEntity, List<SysDeptEntity> returnEntityList);
}
