package com.fu.dao;

import com.fu.entity.AuthInfo;

public interface AuthInfoMapper {
	int deleteByPrimaryKey(Long id);

	Long insert(AuthInfo record);

	int insertSelective(AuthInfo record);

	AuthInfo selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(AuthInfo record);

	int updateByPrimaryKey(AuthInfo record);

	AuthInfo getByClientId(String clientId);
}