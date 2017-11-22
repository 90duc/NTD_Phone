package com.mk.info;

public interface MsgInfo {

	public static interface OtherError {

		String databaseError = "数据库出错";
		String dataNoSync = "数据不同步";		

	}
	public static interface Info {

		String saveSuccess = "保存成功";

	}
	
	public static interface Register {

		String registerSuccess = "注册成功";	

	}
	
	public static interface Login {

		String loginSuccess = "登录成功";	
		String noLogin ="未登录";
		String logined = "已经登录";

	}
	
	public static interface Account {

		String accountNoExist = "用户不存在";	
		String accountExist = "账号已经存在";
	}

	public static interface Password {

		String nullPassword = "密码为空";
		String shortPassword = "密码太短";
		String longPassword = "密码太长";
		String lowSafe = "安全系数低";
		String passwordSafe = "密码安全";
		String twoPasswordDifferent = "两次密码不相同";
		String twoNewPasswordDifferent = "两次新密码不相同";
		String passwordError = "密码错误";
		String modifyPasswordSuccess ="修改密码成功";
		String oldPasswordDifferent = "旧密码错误";
		String oldNewPasswordSame = "新旧密码相同";
	}
	
	public static interface UserName {

		String nullUserName = "用户名为空";
		String shortUserName = "用户名太短";
		String longUserName = "用户名太长";
		String noRightChar = "非英文、数字或中文或\"_\"";
		String userNameRight = "用户名合适";
		String newOldNameSame = "新旧昵称相同";

	}
	
	public static interface Email {

		String emailError = "邮箱格式错误";
		String emailExist = "邮箱已注册";	
		String emailRight = "邮箱正确";
		String nullEmail = "邮箱为空";
		String modifyEmailSuccess = "修改邮箱成功";
		String newOldEmailSame = "新旧邮箱相同";

	}
}
