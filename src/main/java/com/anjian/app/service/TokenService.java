package com.anjian.app.service;

import com.anjian.app.entity.SysUserEntity;
import com.baomidou.mybatisplus.service.IService;


public interface TokenService extends IService<SysUserEntity> {

	SysUserEntity queryByToken(String token);


	SysUserEntity createToken(long userId);


	void expireToken(long userId);

}
