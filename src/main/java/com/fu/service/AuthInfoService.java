package com.fu.service;

import com.fu.entity.AuthInfo;

public interface AuthInfoService {

	AuthInfo getByClientId(String clientId);

	Long add(AuthInfo authInfo);

	void update(AuthInfo authInfo);

}
