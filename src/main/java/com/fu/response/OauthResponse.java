package com.fu.response;

import java.io.Serializable;

/**
 * 
 * @ClassName: OauthResponse
 * @Description: OAuth2授权后返回的实体类
 * @author 041897
 * @date 2017年9月28日下午3:27:38
 */
public class OauthResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	// 状态码
	private int code;

	// 描述信息
	private String descriprion;

	public OauthResponse() {
	}

	public OauthResponse(int code, String description) {
		this.code = code;
		this.descriprion = description;
	}

	public OauthResponse(String description) {
		this(400, description);
	}

	public int getCode() {
		return code;
	}

	public String getDescriprion() {
		return descriprion;
	}

}
