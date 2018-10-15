package com.anjian.app.service.impl;


import com.anjian.app.common.*;
import com.anjian.app.dao.SysUserDao;
import com.anjian.app.entity.SysDeptEntity;
import com.anjian.app.entity.SysUserEntity;
import com.anjian.app.service.SysDeptService;
import com.anjian.app.service.SysUserRoleService;
import com.anjian.app.service.SysUserService;
import com.anjian.app.service.TokenService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysUserService userService;
	@Autowired
	private SysDeptService sysDeptService;
	@Autowired
	private TokenService tokenService;

	@Override
	public List<Long> queryAllMenuId(Long userId) {
		return baseMapper.queryAllMenuId(userId);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
//		String username = (String)params.get("username");
		String nickName = (String) params.get("nickName");
		EntityWrapper<SysUserEntity> ew =new EntityWrapper<SysUserEntity>();
		if(UtilValidate.isNotEmpty(params.get("deptAuth"))){
			ew.addFilter("FIND_IN_SET(dept_id,{0})",params.get("deptAuth"));
		}
		if(UtilValidate.isNotEmpty(nickName)){
			ew.like(StringUtils.isNotBlank(nickName),"nick_name", nickName);
		}
		Page<SysUserEntity> page = this.selectPage(
			new Query<SysUserEntity>(params).getPage(),ew.orderBy("order_num",true));

		for(SysUserEntity sysUserEntity : page.getRecords()){
			SysDeptEntity sysDeptEntity = sysDeptService.selectById(sysUserEntity.getDeptId());
			if (UtilValidate.isNotEmpty(sysDeptEntity)) {
				sysUserEntity.setDeptName(sysDeptEntity.getName());
			}
		}

		return new PageUtils(page);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(SysUserEntity user) {
		user.setUserId(IdWorker.getId());//
		user.setCreateTime(new Date());
		//sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		user.setSalt(salt);
		user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
		this.insert(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(SysUserEntity user) {
		if(StringUtils.isBlank(user.getPassword())){
			user.setPassword(null);
		}else{
			user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
		}
		this.updateById(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}


	@Override
	public boolean updatePassword(Long userId, String password, String newPassword) {
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setPassword(newPassword);
        return this.update(userEntity,
                new EntityWrapper<SysUserEntity>().eq("user_id", userId).eq("password", password));
    }

	@Override
	public List<SysUserEntity> queryUserList(SysUserEntity userEntity,boolean filtByDeptFlag) {
			return baseMapper.queryUserList(UtilPage.wrapperEntitpParam2Map(userEntity,"u",filtByDeptFlag));
	}

	@Override
	public Map<String, Object> login(String username, String password) {
		SysUserEntity userTemp=userService.selectOne(new EntityWrapper<SysUserEntity>().eq("username",username));
		// Assert.isNull(userTemp, "用户名或密码错误");
		String saltpwd=ShiroUtils.sha256(password, userTemp.getSalt());
		//密码错误
		if (!saltpwd.equals(userTemp.getPassword())) {
			throw new GeneralRuntimeException("用户名或密码错误");
		}

		//获取登录token
		SysUserEntity tokenEntity = tokenService.createToken(userTemp.getUserId());

		Map<String, Object> map = new HashMap<>(2);
		map.put("token", tokenEntity.getToken());
		map.put("expire", tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());

		return map;
	}

}
