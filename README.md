# boot-oauth2-server
**简介：**基于Spring Boot框架对OAuth2服务端的简单实现。

> `基础环境：`

	JDK1.8+
	Maven3+
	MySQL5.6+

> `运行步骤：`

	1、clone项目到本地，导入IDE中，数据库中导入oauth.sql
	2、修改数据库连接的配置文件
	3、启动BootOauth2.java

> `测试：`

	# curl测试
	编辑发送 curl -v 你的ip:你的port/api/v1/oauth2/token \
		     -H "Accept:application/json" \
			 -u "<clientId:clientSecret>" \
			 -d "grant_type=client_credential" 

	响应：{
    		"scope": "all",
    		"access_token": "MhOUoDngS_mLfArXMbxqtCE9WABALNJ-z20-RCbWBu36JyBOCZuG4IT085F8Vxa6hPA9i9hEU51yet2s9DzZcbTCUQPto3_SZdk",
    		"token_type": "Bearer",
    		"expires_in": 31200,
    		"code": 200,
    		"descriprion": "generated token"
		  }
