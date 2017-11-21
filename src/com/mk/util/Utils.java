package com.mk.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import com.mk.info.MsgInfo.Email;
import com.mk.info.MsgInfo.Password;
import com.mk.info.MsgInfo.UserName;
import com.mk.info.status.Status;



public class Utils {
	private Utils() {

	}

	public static boolean isNullOrSpaceWhite(String a) {

		return a == null || a.trim().isEmpty();
	}
	
	public static boolean isNullOrEmpty(String a) {

		return a == null || a.isEmpty();
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

    public static Status checkPassword(String password) {
		
    	Status status;
    	if(isNullOrEmpty(password))
    		status=Status.error(Password.nullPassword);
    	else
    	if(password.length()<6)
    		status=Status.error(Password.shortPassword);
    	else if(password.length()>20)
    		status=Status.error(Password.longPassword);
    	else if(password.matches("\\w(1)+")){
    		status=Status.error(Password.lowSafe);
    	}else {
    		status=Status.success(Password.passwordSafe);
		}
    	return status;
	}

	public static Status checkUserName(String userName) {
	
		Status status;
    	if(isNullOrEmpty(userName))
    		status=Status.error(UserName.nullUserName);
    	else
    	if(userName.length()<2)
    		status=Status.error(UserName.shortUserName);
    	else if(userName.length()>14)
    		status=Status.error(UserName.longUserName);
    	else if(!userName.matches("[\u4e00-\u9fa5a-zA-Z0-9_]{2,14}")){
    		status=Status.error(UserName.noRightChar);
    	}else {
    		status=Status.success(UserName.userNameRight);
		}
    	return status;
	}

	public static Status checkEmail(String email) {
 
		Status status;
    	if(isNullOrEmpty(email))
    		status=Status.error(Email.nullEmail);
    	else if(!email.matches("[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+")){
    		status=Status.error(Email.emailError);
    	}else {
    		status=Status.success(Email.emailRight);
		}
    	return status;
	}

	public static String getRemoteHost(HttpServletRequest request){
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
}
