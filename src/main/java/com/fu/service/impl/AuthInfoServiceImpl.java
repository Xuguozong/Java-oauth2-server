package com.fu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fu.dao.AuthInfoMapper;
import com.fu.entity.AuthInfo;
import com.fu.service.AuthInfoService;

/**
 * 
 * @ClassName: AuthInfoServiceImpl
 * @Description: AuthInfoService的实现类
 * @author 041897
 * @date 2017年9月28日下午3:26:52
 */
@Service("authInfoService")
public class AuthInfoServiceImpl implements AuthInfoService {
	@Autowired
	private AuthInfoMapper aMapper;

	public AuthInfo getByClientId(String clientId) {
		return this.aMapper.getByClientId(clientId);
	}

	public Long add(AuthInfo authInfo) {
		return this.aMapper.insert(authInfo);
	}

	public void update(AuthInfo authInfo) {
		this.aMapper.updateByPrimaryKeySelective(authInfo);

	}
}
