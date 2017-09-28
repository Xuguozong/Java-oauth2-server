package com.fu.response;

/**
 * 
 * @ClassName: ErrorResponse
 * @Description: 获取授权信息时的错误响应体
 * @author 041897
 * @date 2017年9月28日下午3:31:51
 */
public class ErrorResponse extends OauthResponse {

	private static final long serialVersionUID = 1L;

	// 错误描述
	private String error;

	public ErrorResponse() {
	}

	public ErrorResponse(String error) {
		super(401, error);

	}

	public ErrorResponse(Integer code, String error) {
		super(code, error);

	}

	public String getError() {
		return error;
	}
}
