package com.fu.exceptions;

/**
 * 
 * @ClassName: OauthException
 * @Description: 自定义异常
 * @author 041897
 * @date 2017年9月28日下午3:33:11
 */
public abstract class OauthException extends Exception {

	private static final long serialVersionUID = 1L;

	private int code;// 错误码

	private String description;// 错误描述

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	protected OauthException(int code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	protected OauthException(String description) {
		this(400, description);
	}

	public abstract String getType();

	// 无效的请求错误
	public static class InvalidRequest extends OauthException {

		private static final long serialVersionUID = 1L;

		public InvalidRequest(String description) {
			super(401, description);
		}

		public InvalidRequest(int code, String description) {
			super(code, description);
		}

		@Override
		public String getType() {
			return "invalid_request";
		}

	}

	// 无效的客户端错误
	public static class InvalidClient extends OauthException {

		private static final long serialVersionUID = 1L;

		protected InvalidClient(String description) {
			super(401, description);
		}

		@Override
		public String getType() {
			return "invalid_client";
		}

	}

	// 未授权的客户端错误
	public static class UnauthorizedClient extends OauthException {
		private static final long serialVersionUID = 1L;

		protected UnauthorizedClient(String description) {
			super(401, description);
		}

		@Override
		public String getType() {
			return "unauthorized_client";
		}

	}

	// 跳转地址不符合错误
	public static class RedirectUrlMismatch extends OauthException {

		private static final long serialVersionUID = 1L;

		protected RedirectUrlMismatch(String description) {
			super(401, description);
		}

		@Override
		public String getType() {
			return "redirect_url_mismatch";
		}

	}

	// 拒绝访问
	public static class AccessDenied extends OauthException {

		private static final long serialVersionUID = 1L;

		protected AccessDenied(String description) {
			super(401, description);
		}

		@Override
		public String getType() {
			return "access_denied";
		}

	}

	// 不支持的响应类型错误
	public static class UnsupportedResponseType extends OauthException {

		private static final long serialVersionUID = 1L;

		/**
		 * Initialize this instance. The HTTP status code is set as 400.
		 * 
		 * @param description
		 *            The error description string.
		 */
		public UnsupportedResponseType(String description) {
			super(description);
		}

		@Override
		public String getType() {
			return "unsupported_response_type";
		}

	}

	// 无效的授权类型
	public static class InvalidGrant extends OauthException {

		private static final long serialVersionUID = 1L;

		public InvalidGrant(String description) {
			super(401, description);
		}

		@Override
		public String getType() {
			return "invalid_grant";
		}

	}

	// 不支持的授权类型
	public static class UnsupportedGrantType extends OauthException {

		private static final long serialVersionUID = 1L;

		public UnsupportedGrantType(String description) {
			super(description);
		}

		@Override
		public String getType() {
			return "unsupported_grant_type";
		}

	}

	// 无效的授权范围
	public static class InvalidScope extends OauthException {

		private static final long serialVersionUID = 1L;

		public InvalidScope(String description) {
			super(401, description);
		}

		@Override
		public String getType() {
			return "invalid_scope";
		}

	}

	// 无效的token
	public static class InvalidToken extends OauthException {

		private static final long serialVersionUID = 1L;

		public InvalidToken(String description) {
			super(401, description);
		}

		@Override
		public String getType() {
			return "invalid_token";
		}

	}

	// 过期的token
	public static class ExpiredToken extends OauthException {

		private static final long serialVersionUID = 1L;

		public ExpiredToken() {
			super(401, "The access token expired");
		}

		@Override
		public String getType() {
			return "invalid_token";
		}

	}

	// 无效的scope
	public static class InsufficientScope extends OauthException {

		private static final long serialVersionUID = 1L;

		public InsufficientScope(String description) {
			super(401, description);
		}

		@Override
		public String getType() {
			return "insufficient_scope";
		}

	}
}
