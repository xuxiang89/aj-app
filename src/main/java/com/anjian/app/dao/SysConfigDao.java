package com.anjian.app.dao;


import com.anjian.app.entity.SysConfigEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysConfigDao extends BaseMapper<SysConfigEntity> {


	SysConfigEntity queryByKey(String paramKey);


	int updateValueByKey(@Param("key") String key, @Param("value") String value);
	
}
