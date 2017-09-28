package com.fu.service;

import com.fu.entity.Credential;

public interface CredentialService {

	Credential addCredentials(long userId);

	Credential selectByClientId(String clientId);

}
