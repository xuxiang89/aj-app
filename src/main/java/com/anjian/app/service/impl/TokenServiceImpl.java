package com.anjian.app.service.impl;

import com.anjian.app.dao.SysUserDao;
import com.anjian.app.entity.SysUserEntity;
import com.anjian.app.service.TokenService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;


@Service("tokenService")
public class TokenServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements TokenService {

	private final static int EXPIRE = 3600 * 12;

	@Override
	public SysUserEntity queryByToken(String token) {
		return this.selectOne(new EntityWrapper<SysUserEntity>().eq("token", token));
	}

	@Override
	public SysUserEntity createToken(long userId) {
		//当前时间
		Date now = new Date();
		//过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

		//生成token
		String token = generateToken();

		//保存或更新用户token
		SysUserEntity tokenEntity = new SysUserEntity();
		tokenEntity.setUserId(userId);
		tokenEntity.setToken(token);
		tokenEntity.setExpireTime(expireTime);
		this.insertOrUpdate(tokenEntity);

		return tokenEntity;
	}

	@Override
	public void expireToken(long userId){
		Date now = new Date();

		SysUserEntity tokenEntity = new SysUserEntity();
		tokenEntity.setUserId(userId);
		tokenEntity.setExpireTime(now);
		this.insertOrUpdate(tokenEntity);
	}

	private String generateToken(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
