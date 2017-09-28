package com.fu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fu.entity.Credential;
import com.fu.response.OauthResponse;
import com.fu.service.AccessTokenService;
import com.fu.service.AuthInfoService;
import com.fu.service.CredentialService;
import com.fu.service.RequestHandleService;
import com.fu.wrapper.RequestWrapper;
import com.google.gson.GsonBuilder;

/**
 * 
 * @ClassName: Oauth2Controller
 * @Description: OAuth2服务端的前端Controller
 * @author 041897
 * @date 2017年9月28日下午3:40:34
 */
@RestController
@RequestMapping("/api/v1")
public class Oauth2Controller {

	private static final GsonBuilder GSONBUILDER = new GsonBuilder();

	@Autowired
	private AuthInfoService authInfoService;

	@Autowired
	private AccessTokenService accessTokenService;

	@Autowired
	private CredentialService credentialService;

	@Autowired
	private RequestHandleService requestHandleService;

	/**
	 * 
	 * @Title: addCredentials
	 * @Description: 登陆用户请求生成clientId和clientSecret
	 * @param userId
	 * @return: Credential
	 */
	@RequestMapping(value = "/credential", method = RequestMethod.POST)
	public Credential addCredentials(long userId) {
		return this.credentialService.addCredentials(userId);
	}

	/**
	 * 
	 * @Title: getToken
	 * @Description: 根据clientId和clientSecret做Basic Authorization来获取access_token
	 * @param request
	 * @param res
	 * @return: String
	 */
	@RequestMapping("/oauth2/token")
	public String getToken(HttpServletRequest request, HttpServletResponse res) {
		// 包装请求信息
		RequestWrapper wrapper = new RequestWrapper(request);
		// 处理请求信息
		OauthResponse response = requestHandleService.handle(wrapper);
		return GSONBUILDER.disableHtmlEscaping().create().toJson(response);
	}

}
