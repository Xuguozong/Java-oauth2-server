package com.fu.utils;

/**
 * 
 * @ClassName: Constants
 * @Description: 常量类型信息
 * @author 041897
 * @date 2017年9月28日下午3:09:00
 */
public class Constants {
	// 授权类型字段
	public static final String GRANT_TYPE = "grant_type";
	// client_credentials类型
	public static final String CLIENT_CREDENTIALS = "client_credentials";
	// implicit类型
	public static final String IMPLICIT = "implicit";
	// password_credentials类型
	public static final String PASSWORD_CREDENTIALS = "password_credentials";
	// authorization_code类型
	public static final String AUTHORIZATION_CODE = "authorization_code";
	// refresh_token类型
	public static final String REFRESH_TOKEN = "refresh_token";
	// authorization头信息
	public static final String AUTHORIZATION = "authorization";
	// Bearer类型的token
	public static final String BEARER = "Bearer";
	// token过期时间
	public static final Long EXPIRES_IN = 32000L;
}
