package com.mk.info.status;

public class Status {
	
	private boolean success;
	private String value;
	
	private Status(String value,boolean success){
		this.value=value;
		this.success=success;
	}
	public String getValue(){
		return value;
	}
	
	public boolean isSuccess(){
		return success;
	}
	
	public static Status success(String value) {
		return new Status(value, true);
	}
	
	public static Status error(String value) {
		return new Status(value, false);
	}
}
