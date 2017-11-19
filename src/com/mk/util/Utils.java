package com.mk.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;


public class Utils {
	private Utils() {

	}

	public static boolean isNullOrEmpty(String a) {

		return a == null || a.trim().isEmpty();
	}

	public static boolean isNull(Object a) {

		return a == null;
	}
	
	public static String toTrimOrNull(String a) {
		if(a==null)
			return null;
        a=a.trim();
        if(a.isEmpty())
        	a=null;
		return a;
	}
	
	public static String decode(String pass) {
		String base="";
		try {
			base = new String(Base64.decodeBase64(pass),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		base=base.substring(DigestUtils.sha1Hex("a").length(), DigestUtils.sha1Hex("a").length());
		return base;
	}
	
}
