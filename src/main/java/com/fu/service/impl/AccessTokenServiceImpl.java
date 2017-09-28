package com.fu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fu.dao.AccessTokenMapper;
import com.fu.entity.AccessToken;
import com.fu.service.AccessTokenService;

/**
 * 
 * @ClassName: AccessTokenServiceImpl
 * @Description: AccessTokenService的实现类
 * @author 041897
 * @date 2017年9月28日下午3:26:23
 */
@Service("accessTokenService")
public class AccessTokenServiceImpl implements AccessTokenService {
	@Autowired
	private AccessTokenMapper aMapper;

	public void insert(AccessToken token) {
		this.aMapper.insert(token);
	}

	public AccessToken getById(Long authId) {
		return aMapper.selectByPrimaryKey(authId);
	}

	public void updata(AccessToken token) {
		this.aMapper.updateByPrimaryKeySelective(token);

	}
}
