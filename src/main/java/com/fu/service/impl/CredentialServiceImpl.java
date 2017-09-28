package com.fu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fu.dao.CredentialMapper;
import com.fu.entity.Credential;
import com.fu.service.CredentialService;
import com.fu.utils.Generator;

/**
 * 
 * @ClassName: CredentialServiceImpl
 * @Description: CredentialService的实现类
 * @author 041897
 * @date 2017年9月28日下午3:27:12
 */
@Service("credentialService")
public class CredentialServiceImpl implements CredentialService {

	@Autowired
	private CredentialMapper cMapper;

	public Credential addCredentials(long userId) {
		Credential credential = new Credential();
		credential.setUserId(userId);
		credential.setClientId(Generator.generateString(80));
		credential.setClientSecret(Generator.generateString(80));
		cMapper.insert(credential);
		return credential;
	}

	public Credential selectByClientId(String clientId) {
		return this.cMapper.selectByClientId(clientId);
	}
}
