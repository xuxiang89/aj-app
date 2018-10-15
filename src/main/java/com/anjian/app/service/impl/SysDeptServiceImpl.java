package com.anjian.app.service.impl;

import com.anjian.app.common.UtilValidate;
import com.anjian.app.dao.SysDeptDao;
import com.anjian.app.entity.SysDeptEntity;
import com.anjian.app.service.SysDeptService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDeptEntity> implements SysDeptService {
	
	@Override
	public List<SysDeptEntity> queryList(Map<String, Object> params){
		EntityWrapper<SysDeptEntity> ew =new EntityWrapper<SysDeptEntity>();
		if(UtilValidate.isNotEmpty(params.get("deptAuth"))){
			ew.addFilter("FIND_IN_SET(dept_id,{0})",params.get("deptAuth"));
		}
		List<SysDeptEntity> deptList =
			this.selectList(ew.orderBy("order_num",true));

		for(SysDeptEntity sysDeptEntity : deptList){
			SysDeptEntity parentDeptEntity =  this.selectById(sysDeptEntity.getParentId());
			if(parentDeptEntity != null){
				sysDeptEntity.setParentName(parentDeptEntity.getName());
			}
		}
		return deptList;
	}

	@Override
	public List<Long> queryDetpIdList(Long parentId) {
		return baseMapper.queryDetpIdList(parentId);
	}

	@Override
	public List<Long> getSubDeptIdList(Long deptId){
		//部门及子部门ID列表
		List<Long> deptIdList = new ArrayList<>();

		//获取子部门ID
		List<Long> subIdList = queryDetpIdList(deptId);
		getDeptTreeList(subIdList, deptIdList);

		return deptIdList;
	}


	private void getDeptTreeList(List<Long> subIdList, List<Long> deptIdList){
		for(Long deptId : subIdList){
			List<Long> list = queryDetpIdList(deptId);
			if(list.size() > 0){
				getDeptTreeList(list, deptIdList);
			}

			deptIdList.add(deptId);
		}
	}

	/**
	 * 迭代设置上级部门的信息: 如：DeptCode
	 *
	 * @param parentEntity
	 */
	private void iterateUpperDepts(SysDeptEntity parentEntity) {
		//通过子节点查询父节点
		if(parentEntity.getParentId() != 0 && parentEntity.getParentId() != -1) {
			SysDeptEntity upperEntity = this.selectById(parentEntity.getParentId());
			if(upperEntity != null ) {
				parentEntity.setParent(upperEntity);
				iterateUpperDepts(upperEntity);
			}
		}
	}

	/**
	 * 获取当前部门节点的所有上级部门的信息: 如：DeptCode
	 * @param curEntity
	 * @return
	 */
	public SysDeptEntity getCurDeptWithUpperDepts(SysDeptEntity curEntity) {
		//通过子节点查询父节点
		if(curEntity != null && curEntity.getParentId() != 0 && curEntity.getParentId() != -1) {
			SysDeptEntity parentEntity = this.selectById(curEntity.getParentId());
			if(parentEntity != null ) {
				curEntity.setParent(parentEntity);
				iterateUpperDepts(parentEntity);
			}
		}
		return curEntity;
	}

	/**
	 * 迭代返回Dept部门的层级关系
	 * @param curEntity
	 * @param returnEntityList
	 * @return
	 */
	public List<SysDeptEntity> getParentDeptList(SysDeptEntity curEntity, List<SysDeptEntity> returnEntityList) {

		if(curEntity.getParent() != null) {
			returnEntityList.add(curEntity.getParent());
			getParentDeptList(curEntity.getParent(), returnEntityList);
		}
		return returnEntityList;
	}
}
