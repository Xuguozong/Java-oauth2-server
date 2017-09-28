package com.fu.service.impl;

import java.util.Base64;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fu.entity.AccessToken;
import com.fu.entity.AuthInfo;
import com.fu.entity.Credential;
import com.fu.exception.OauthException;
import com.fu.response.ErrorResponse;
import com.fu.response.GetTokenResponse;
import com.fu.response.OauthResponse;
import com.fu.service.AccessTokenService;
import com.fu.service.AuthInfoService;
import com.fu.service.CredentialService;
import com.fu.service.RequestHandleService;
import com.fu.utils.Constants;
import com.fu.utils.Generator;
import com.fu.wrapper.RequestWrapper;

/**
 * 
 * @ClassName: RequestHandleServiceImpl
 * @Description: 处理授权类型请求的实现类
 * @author 041897
 * @date 2017年9月28日下午3:12:13
 */
@Service("requestHandleService")
public class RequestHandleServiceImpl implements RequestHandleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestHandleServiceImpl.class);

	@Autowired
	private AuthInfoService authInfoService;

	@Autowired
	private AccessTokenService accessTokenService;

	@Autowired
	private CredentialService credentialService;

	public OauthResponse handle(RequestWrapper wrapper) {
		// 获取授权类型字段
		String type = wrapper.getParameter(Constants.GRANT_TYPE);
		try {
			if (StringUtils.isEmpty(type)) {
				throw new OauthException.InvalidRequest(400, "'grant_type' not found");
			} else {
				// 根据授权类型选取相应方法处理
				return this.handle(type, wrapper);
			}
		} catch (OauthException e) {
			LOGGER.error("OauthException.InvalidRequest", e.getDescription());
			return new ErrorResponse(400, e.getDescription());
		}
	}

	/**
	 * 
	 * @Title: handle
	 * @Description: 根据授权类型选取相应的方法处理
	 * @param type:授权类型
	 * @param wrapper:request的包装类
	 * @return: OauthResponse
	 */
	private OauthResponse handle(String type, RequestWrapper wrapper) {
		if (Constants.CLIENT_CREDENTIALS.equals(type)) {
			return this.handleClientCredentials(wrapper);
		}
		if (Constants.AUTHORIZATION_CODE.equals(type)) {
			return this.handleAuthorizationCode(wrapper);
		}
		if (Constants.PASSWORD_CREDENTIALS.equals(wrapper)) {
			return this.handlePasswordCredentials(wrapper);
		}
		if (Constants.IMPLICIT.equals(type)) {
			return this.handleImplicit(wrapper);
		}
		if (Constants.REFRESH_TOKEN.equals(type)) {
			return this.handleRefreshToken(wrapper);
		}
		return new ErrorResponse(400, "upsupported grant_type");
	}

	/**
	 * 
	 * @Title: handleRefreshToken
	 * @Description: 请求刷新access_token的情况
	 * @param wrapper
	 * @return: OauthResponse
	 */
	private OauthResponse handleRefreshToken(RequestWrapper wrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @Title: handleImplicit
	 * @Description: OAuth授权类型为Implicit的情况
	 * @param wrapper
	 * @return: OauthResponse
	 */
	private OauthResponse handleImplicit(RequestWrapper wrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @Title: handlePasswordCredentials
	 * @Description: OAuth授权类型为Resource Owner Password Credential的情况
	 * @param wrapper
	 * @return: OauthResponse
	 */
	private OauthResponse handlePasswordCredentials(RequestWrapper wrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @Title: handleAuthorizationCode
	 * @Description: OAuth授权类型为Authorization Code的情况
	 * @param wrapper
	 * @return: OauthResponse
	 */
	private OauthResponse handleAuthorizationCode(RequestWrapper wrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @Title: handleClientCredentials
	 * @Description: OAuth授权类型为Client Credential的情况
	 * @param wrapper
	 * @return: OauthResponse
	 */
	private OauthResponse handleClientCredentials(RequestWrapper wrapper) {
		// 获取请求头中的Authorization信息
		String auth = wrapper.getHeader(Constants.AUTHORIZATION);
		Credential credential = null;
		String clientId = null;
		try {
			if (StringUtils.isEmpty(auth)) {
				throw new OauthException.InvalidRequest("authorization empty");
			}
			// base64解码，前6位字符为Basic加一个空格
			byte[] decode = Base64.getDecoder().decode(auth.substring(6).getBytes());
			// 解码后的字符格式为 <clientId>:<clientSecret>
			String[] split = StringUtils.split(new String(decode), ":");
			clientId = split[0];
			System.out.println("clientId: " + clientId);
			String clientSecret = split[1];
			System.out.println("clientSecret: " + clientSecret);

			// 在数据库查询凭证信息
			credential = credentialService.selectByClientId(clientId);

			// 凭证错误的情况
			if (credential == null || !clientSecret.equals(credential.getClientSecret())) {
				throw new OauthException.InvalidRequest("authorization validate error");
			}

		} catch (OauthException e) {
			e.printStackTrace();
			LOGGER.error("OauthException: ", e.getDescription());
			return new ErrorResponse(e.getDescription());
		}
		Long userId = credential.getUserId();

		// 在数据库查询授权信息
		AuthInfo authInfo = authInfoService.getByClientId(clientId);

		// 生成access_token
		String accessToken = Generator.generateString(99);
		if (null == authInfo) {// 第一次生成access_token
			authInfo = new AuthInfo();
			authInfo.setClientId(clientId);
			authInfo.setUserId(userId);
			Long id = authInfoService.add(authInfo);
			System.out.println("new authinfo id: " + id);
			authInfo.setId(id);
		} else {// 更新access_token
			authInfo.setRefreshToken(accessToken);
			authInfoService.update(authInfo);
		}

		// 查询access_token
		AccessToken token = accessTokenService.getById(authInfo.getId());
		if (null == token) {// 新建
			token = new AccessToken();
			token.setAuthId(authInfo.getId());
			token.setCreateDate(new Date());
			token.setExpiresIn(Constants.EXPIRES_IN);
			token.setToken(accessToken);
			token.setUserId(userId);
			accessTokenService.insert(token);
		} else {// 更新
			token.setToken(accessToken);
			accessTokenService.updata(token);
		}

		return new GetTokenResponse("all", accessToken, Constants.BEARER, token.getExpiresIn());
	}
}
