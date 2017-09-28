package com.fu.response;

/**
 * 
 * @ClassName: GetTokenResponse
 * @Description: 获取access_token的响应实体
 * @author 041897
 * @date 2017年9月28日下午3:29:30
 */
public class GetTokenResponse extends OauthResponse {
	private static final long serialVersionUID = 1L;
	// access_token的权限范围
	private String scope;
	// access_token
	private String access_token;
	// token类型，默认为Bearer
	private String token_type;
	// 过期时间，单位秒
	private long expires_in;

	public GetTokenResponse() {
	}

	public GetTokenResponse(String scope, String access_token, String token_type, long expires_in) {
		super(200, "generated token");
		this.scope = scope;
		this.access_token = access_token;
		this.token_type = token_type;
		this.expires_in = expires_in;
	}

	public String getScope() {
		return scope;
	}

	public String getAccess_token() {
		return access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public long getExpires_in() {
		return expires_in;
	}

}
