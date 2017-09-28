package com.fu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 
 * @ClassName: BootOauth2
 * @Description: 工程启动类
 * @author 041897
 * @date 2017年9月28日下午3:48:48
 */
@SpringBootApplication
public class BootOauth2 extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(BootOauth2.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BootOauth2.class);
	}
}
