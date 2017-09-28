package com.fu.dao;

import com.fu.entity.Credential;

public interface CredentialMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Credential record);

	int insertSelective(Credential record);

	Credential selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Credential record);

	int updateByPrimaryKey(Credential record);

	Credential selectByClientId(String clientId);
}