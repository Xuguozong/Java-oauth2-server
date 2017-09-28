package com.fu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: AccessToken
 * @Description: AccessToken实体类
 * @author 041897
 * @date 2017年9月28日下午3:33:49
 */
public class AccessToken implements Serializable {
	private static final long serialVersionUID = 1L;
	// 对应授权信息AuthInfo的主键id
	private Long authId;
	// 用户id
	private Long userId;
	// access_token
	private String token;
	// 过期时间
	private Long expiresIn;
	// 创建时间
	private Date createDate;

	public Long getAuthId() {
		return authId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}