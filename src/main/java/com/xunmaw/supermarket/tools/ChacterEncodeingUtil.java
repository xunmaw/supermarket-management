package com.xunmaw.supermarket.tools;

import java.io.UnsupportedEncodingException;

/**
 * 功能说明
 */
public class ChacterEncodeingUtil {
	public static String toChinese(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "NULL";
		}
	}
}
