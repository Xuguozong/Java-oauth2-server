package com.fu.wrapper;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @ClassName: RequestWrapper
 * @Description: HttpServletRequest的包装类，获取它的header、parameter以及parameterMap信息
 * @author 041897
 * @date 2017年9月28日下午3:19:08
 */
public class RequestWrapper implements Serializable {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;

	public RequestWrapper(HttpServletRequest request) {
		super();
		this.request = request;
	}

	public String getParameter(String name) {
		return request.getParameter(name);
	}

	public String getHeader(String name) {
		return request.getHeader(name);
	}

	public Map<String, String[]> getParameterMap() {
		return request.getParameterMap();
	}
}
