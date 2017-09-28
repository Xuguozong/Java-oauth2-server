package com.fu.service;

import com.fu.response.OauthResponse;
import com.fu.wrapper.RequestWrapper;

public interface RequestHandleService {

	OauthResponse handle(RequestWrapper wrapper);

}
