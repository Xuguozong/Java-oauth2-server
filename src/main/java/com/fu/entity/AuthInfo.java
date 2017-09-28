package com.fu.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: AuthInfo
 * @Description: 授权信息实体类
 * @author 041897
 * @date 2017年9月28日下午3:37:57
 */
public class AuthInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	// 主键
	private Long id;
	// 用户id
	private Long userId;
	// clientId
	private String clientId;
	// access_token的权限范围
	private String scope;
	// 刷新的access_token
	private String refreshToken;
	// 授权码（对应授权码模式）
	private String code;
	// 回调地址信息
	private String redirecrUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRedirecrUrl() {
		return redirecrUrl;
	}

	public void setRedirecrUrl(String redirecrUrl) {
		this.redirecrUrl = redirecrUrl;
	}
}