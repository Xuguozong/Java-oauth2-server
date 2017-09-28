package com.fu.utils;

import java.util.Random;

/**
 * 
 * @ClassName: Generator
 * @Description: 生成各类字符串的工具类
 * @author 041897
 * @date 2017年9月28日下午3:21:28
 */
public class Generator {

	private static final Random RANDOM = new Random();

	private static final String CHARS = "XZYabc034OPQ621defgSRTljik_hnm587ACBDqpostr9VUWuvwyzxFEGHIJ-KLMN";

	/**
	 * 
	 * @Title: generateString
	 * @Description: 生成指定长度的随机字符串
	 * @param length
	 * @return: String
	 */
	public static String generateString(int length) {
		StringBuilder builder = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			builder.append(CHARS.charAt(RANDOM.nextInt(CHARS.length())));
		}
		return builder.toString();
	}

	/**
	 * 
	 * @Title: generateString
	 * @Description: 生成固定长度为99的随机字符串
	 * @return: String
	 */
	public static String generateString() {
		StringBuilder builder = new StringBuilder(99);
		for (int i = 0; i < 99; i++) {
			builder.append(CHARS.charAt(RANDOM.nextInt(CHARS.length())));
		}
		return builder.toString();
	}

}
