package com.fu.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fu.entity.Credential;
import com.fu.service.CredentialService;

@SpringBootTest
public class CredentialServiceImplTest {
	@Autowired
	private CredentialService credentialService;

	@Test
	public void testGetByClientId() {
		Credential credential2 = new CredentialServiceImpl()
				.selectByClientId("H6JL-cyC0GH4qi1E-0BTw5YZSXGOXBBQwYY17O9aeJgmR01HMLkRTjgUPglpc0CE7O9ELe49CBQEI-r4");
		Credential credential = credentialService
				.selectByClientId("H6JL-cyC0GH4qi1E-0BTw5YZSXGOXBBQwYY17O9aeJgmR01HMLkRTjgUPglpc0CE7O9ELe49CBQEI-r4");

	}
}
