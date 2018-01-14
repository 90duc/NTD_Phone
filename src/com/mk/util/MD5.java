package com.mk.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String pass(String text) {
 
		try {
			 MessageDigest m = MessageDigest.getInstance("MD5");
			 byte[] bs = m.digest(text.getBytes("utf-8"));
		     return byte2hex(bs);
		} catch (NoSuchAlgorithmException|UnsupportedEncodingException e) {
			//e.printStackTrace();
		}
      
        return null;
    }

    public static String byte2hex(byte[] b) 
    {
        String hs = "";
        String stmp;
        for (int n = 0; n < b.length; n++) {
            stmp =Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
            //if (n<b.length-1)  //hs=hs+":";
        }
        return hs.toUpperCase();
    }
}
