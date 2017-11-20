package com.mk.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.mk.dao.impl.UserDao;
import com.mk.dao.impl.UserInfoDao;
import com.mk.entity.User;
import com.mk.entity.UserInfo;
import com.mk.info.MsgInfo.Account;
import com.mk.info.MsgInfo.Email;
import com.mk.info.MsgInfo.Login;
import com.mk.info.MsgInfo.OtherError;
import com.mk.info.MsgInfo.Password;
import com.mk.info.MsgInfo.Register;
import com.mk.info.NameInfo;
import com.mk.info.status.Status;
import com.mk.util.*;

@org.springframework.stereotype.Service
public class UserService extends Service<User, UserDao> {

	public Map<String, Object> login(String account, String password) {

		account = Utils.toTrimOrNull(account);
		// password = Utils.toTrimOrNull(password);
		Status status;
		Map<String, Object> map = new HashMap<>();
		User user = dao.get(account);
		if (user == null) {
			status = Status.error(Account.accountNoExist);
		} else

		if (Objects.equals(user.getPassword(), password)) {
			status = Status.success(Login.loginSuccess);

		} else {
			status = Status.error(Password.twoPasswordDifferent);
		}

		map.put(NameInfo.user, user);
		map.put(NameInfo.status, status.isSuccess());
		map.put(NameInfo.msg, status.getValue());
		return map;
	}

	public Map<String, Object> register(String account, String userName,
			String password) {

		account = Utils.toTrimOrNull(account);
		userName = Utils.toTrimOrNull(userName);
		// password = Utils.toTrimOrNull(password);

		Map<String, Object> map = new HashMap<String, Object>();
		Status status = null;
		User user = null;
		// 邮箱，用户名，密码检验
		if ((status = Utils.checkEmail(account)).isSuccess()
				&& (status = Utils.checkUserName(userName)).isSuccess()
				&& (status = Utils.checkPassword(password)).isSuccess()) {

			user = dao.get(account);
			// 账号已经存在
			if (!Utils.isNull(user)) {
				status = Status.error(Account.accountExist);
			} else
			// 账号未存在
			{
				user = new User();
				user.setEmail(account);
				user.setName(userName);
				user.setPassword(password);
				// 保存成功
				if (dao.save(user)) {
					status = Status.error(Register.registerSuccess);
				} else
				// 数据库出错
				{
					status = Status.error(OtherError.databaseError);
				}
			}
		}
		// 填充返回结果
		map.put(NameInfo.user, user);
		map.put(NameInfo.status, status.isSuccess());
		map.put(NameInfo.msg, status.getValue());

		return map;
	}

	public Map<String, Object> checkLogin(Integer id) {

		Map<String, Object> map = new HashMap<String, Object>();
		Status status = null;
		User user = null;

		if (Utils.isNull(id)) {
			status = Status.error(Login.noLogin);
		} else {
			user = dao.get(id);
			if (Utils.isNull(user))
				status = Status.error(Account.accountNoExist);
			else
				status = Status.success(Login.logined);
		}

		map.put(NameInfo.user, user);
		map.put(NameInfo.status, status.isSuccess());
		map.put(NameInfo.msg, status.getValue());

		return map;
	}

	@Autowired
	private UserInfoDao userInfoDao;

	public UserInfo getUserInfo(Integer id) {

		UserInfo userInfo = null;
		if (!Utils.isNull(id)) {
			userInfo = userInfoDao.get(id);
		}
		return userInfo;
	}

	public Map<String, Object> modifyPassword(Integer id, String oldPassword,
			String newPassword) {

		Map<String, Object> map = new HashMap<String, Object>();
		Status status = null;
		// 密码检验
		if ((status = Utils.checkPassword(newPassword)).isSuccess()) {

			User user = dao.get(id);
			// 账号不存在
			if (Utils.isNull(user)) {
				status = Status.error(Account.accountNoExist);
			} else
			// 账号存在
			{
				String lock = ("u" + user.getUid()).intern();
				synchronized (lock) {
					if (Objects.equals(user.getPassword(), oldPassword)) {
						user.setPassword(newPassword);
						// 密码保存成功
						if (dao.save(user)) {
							status = Status
									.success(Password.modifyPasswordSuccess);
						} else
						// 数据库出错
						{
							status = Status.error(OtherError.databaseError);
						}
					} else {
						status = Status.error(Password.oldNewDifferent);
					}
				}
			}
		}
		// 填充返回结果
		map.put(NameInfo.status, status.isSuccess());
		map.put(NameInfo.msg, status.getValue());

		return map;
	}

	public Map<String, Object> modifyEmail(Integer id, String oldEmail,
			String newEmail) {

		Map<String, Object> map = new HashMap<String, Object>();
		Status status = null;
		// 邮箱检验
		if ((status = Utils.checkEmail(newEmail)).isSuccess()) {

			User user = dao.get(id);
			// 账号不存在
			if (Utils.isNull(user)) {
				status = Status.error(Account.accountNoExist);
			} else
			// 账号存在
			{
				String lock = ("u" + user.getUid()).intern();
				synchronized (lock) {
					if (Objects.equals(user.getEmail(), oldEmail)) {
						user.setEmail(newEmail);
						// 密码保存成功
						if (dao.save(user)) {
							status = Status
									.success(Email.modifyEmailSuccess);
						} else
						// 数据库出错
						{
							status = Status.error(OtherError.databaseError);
						}
					} else {
						status = Status.error(OtherError.dataNoSync);
					}
				}

			}
		}
		// 填充返回结果
		map.put(NameInfo.status, status.isSuccess());
		map.put(NameInfo.msg, status.getValue());

		return map;
	}
}
