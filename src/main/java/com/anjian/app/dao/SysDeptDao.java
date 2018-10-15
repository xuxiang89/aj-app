package com.anjian.app.dao;

import com.anjian.app.entity.SysDeptEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;


public interface SysDeptDao extends BaseMapper<SysDeptEntity> {


    List<Long> queryDetpIdList(Long parentId);
    List<Long> queryIdByAuth(Long parentId, String deptIds);

}
