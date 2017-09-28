package com.fu.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: Credential
 * @Description: 授权凭证实体类
 * @author 041897
 * @date 2017年9月28日下午3:38:23
 */
public class Credential implements Serializable {
	private static final long serialVersionUID = 1L;
	// 主键
	private Long id;
	// 用户id
	private Long userId;
	// clientId
	private String clientId;
	// clientSecret
	private String clientSecret;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}