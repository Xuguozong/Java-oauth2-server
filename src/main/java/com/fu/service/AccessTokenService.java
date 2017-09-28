package com.fu.service;

import com.fu.entity.AccessToken;

public interface AccessTokenService {

	void insert(AccessToken token);

	AccessToken getById(Long authId);

	void updata(AccessToken token);

}
