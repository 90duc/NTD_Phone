package com.mk.service.impl;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mk.dao.impl.LoginInfoDao;
import com.mk.dao.impl.SensitiveOperationDao;
import com.mk.dao.impl.UserDao;
import com.mk.dao.impl.UserInfoDao;
import com.mk.entity.LoginInfo;
import com.mk.entity.LoginInfoPK;
import com.mk.entity.SensitiveOperation;
import com.mk.entity.SensitiveOperationPK;
import com.mk.entity.User;
import com.mk.entity.UserInfo;
import com.mk.info.MsgInfo.Account;
import com.mk.info.MsgInfo.Email;
import com.mk.info.MsgInfo.Info;
import com.mk.info.MsgInfo.Login;
import com.mk.info.MsgInfo.OtherError;
import com.mk.info.MsgInfo.Password;
import com.mk.info.MsgInfo.Register;
import com.mk.info.NameInfo;
import com.mk.info.UserDetail;
import com.mk.info.status.Status;
import com.mk.util.*;

@Transactional
@org.springframework.stereotype.Service
public class UserService extends Service<User, UserDao> {

	public Map<String, Object> login(String account, String password,String preLogin,long time) {

		account = Utils.toTrimOrNull(account);
		// password = Utils.toTrimOrNull(password);
		Status status;
		Map<String, Object> map = new HashMap<>();
		User user = dao.get(account);
		if (user == null) {
			status = Status.error(Account.accountNoExist);
		} else

		if (Utils.verifyPassword(password, preLogin, time, user.getPassword())) {
			status = Status.success(Login.loginSuccess);

		} else {
			status = Status.error(Password.passwordError);
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
				user.setPassword(password.toUpperCase());
				// 保存成功
				if (dao.save(user)) {
					status = Status.success(Register.registerSuccess);
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

	public Map<String, Object> modifyPassword(Integer id, String oldPassword,String preLogin,long time,
			String newPassword) {

		Map<String, Object> map = new HashMap<String, Object>();
		Status status = null;
		// 密码检验
		if ((status = Utils.checkPassword(newPassword)).isSuccess()) {
			String lock = getLock(id, "u");
			synchronized (lock) {
				User user = dao.get(id);
				// 账号不存在
				if (Utils.isNull(user)) {
					status = Status.error(Account.accountNoExist);
				} else if(Objects.equals(newPassword, user.getPassword())){
					status = Status.error(Password.oldNewPasswordSame);
				}else{

					if (Utils.verifyPassword(oldPassword, preLogin, time, user.getPassword())) {
						user.setPassword(newPassword.toUpperCase());
						// 密码保存成功
						if (dao.update(user)) {
							status = Status
									.success(Password.modifyPasswordSuccess);
						} else
						// 数据库出错
						{
							status = Status.error(OtherError.databaseError);
						}
					} else {
						status = Status.error(Password.oldPasswordDifferent);
					}
				}
			}
		} else {
			status = Status.error("新" + status.getValue());
		}
		// 填充返回结果
		map.put(NameInfo.status, status.isSuccess());
		map.put(NameInfo.msg, status.getValue());

		return map;
	}

	private String getLock(Integer id, String prefix) {
		return (prefix + id).intern();
	}

	public Map<String, Object> modifyEmail(Integer id, String oldEmail,
			String newEmail) {

		Map<String, Object> map = new HashMap<String, Object>();
		Status status = null;
		// 邮箱检验
		if ((status = Utils.checkEmail(newEmail)).isSuccess()) {

			String lock = getLock(id, "u");
			synchronized (lock) {
				User user = dao.get(id);
				// 账号不存在
				if (Utils.isNull(user)) {
					status = Status.error(Account.accountNoExist);
				} else if (!Utils.isNull(dao.get(newEmail))) {
					status = Status.error(Email.emailExist);
				} else
				// 账号存在
				{

					if (Objects.equals(user.getEmail(), oldEmail)) {
						user.setEmail(newEmail);
						// 密码保存成功
						if (dao.update(user)) {
							status = Status.success(Email.modifyEmailSuccess);
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

	@Autowired
	private LoginInfoDao loginInfoDao;

	public List<LoginInfo> getLoginInfo(Integer id, int start, int limit) {

		return loginInfoDao.list(id, start, limit);
	}

	@Autowired
	private SensitiveOperationDao sensitiveOperationDao;

	public List<SensitiveOperation> getSensitiveOperation(Integer id,
			int start, int limit) {

		return sensitiveOperationDao.list(id, start, limit);
	}

	public void saveLoginInfo(Integer uid, String ip) {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setLoginInfoPK(new LoginInfoPK(uid, new Date()));
		loginInfo.setIp(ip);
		loginInfo.setProduct("NTD Phone");
		loginInfoDao.save(loginInfo);
	}

	public void saveModifyOperation(Integer uid, String ip, String type) {
		SensitiveOperation operation = new SensitiveOperation();
		operation.setSensitiveOperationPK(new SensitiveOperationPK(uid,
				new Date()));
		operation.setIp(ip);
		operation.setOperation(type);
		sensitiveOperationDao.save(operation);

	}

	public Map<String, Object> modifyNickName(Integer id, String oldName,
			String newName) {

		Map<String, Object> map = new HashMap<String, Object>();
		Status status = null;
		// 昵称检验
		if ((status = Utils.checkUserName(newName)).isSuccess()) {

			String lock = getLock(id, "u");
			synchronized (lock) {
				User user = dao.get(id);
				// 账号不存在
				if (Utils.isNull(user)) {
					status = Status.error(Account.accountNoExist);
				} else
				// 账号存在
				{
					if (Objects.equals(user.getName(), oldName)) {
						user.setName(newName);
						// 密码保存成功
						if (dao.update(user)) {
							status = Status.success(Email.modifyEmailSuccess);
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

	public Map<String, Object> modifyInfo(Integer id, String sex,
			String birthday, String info) {
		info = Utils.toTrimOrNull(info);
		Date birth = null;
		try {
			birth = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Status status = null;
		String lock = getLock(id, "u");

		synchronized (lock) {
			UserInfo userInfo = userInfoDao.get(id);
			// 账号不存在
			if (Utils.isNull(userInfo)) {
				userInfo = new UserInfo(id);
			}
			userInfo.setSex(sex.charAt(0));
			userInfo.setBirthday(birth);
			userInfo.setInfo(info);
			// 信息保存成功
			if (userInfoDao.saveOrUpdate(userInfo)) {
				status = Status.success(Info.saveSuccess);
			} else
			// 数据库出错
			{
				status = Status.error(OtherError.databaseError);
			}

		}

		map.put(NameInfo.status, status.isSuccess());
		map.put(NameInfo.msg, status.getValue());

		return map;
	}

	public Map<String, Object> modifyDetail(Integer id, UserDetail userDetail) {

		Field[] fs = UserDetail.class.getDeclaredFields();
		Field[] ufs = UserInfo.class.getDeclaredFields();

		Map<String, Object> map = new HashMap<String, Object>();
		Status status = null;
		String lock = getLock(id, "u");

		synchronized (lock) {
			UserInfo userInfo = userInfoDao.get(id);
			// 账号不存在
			if (Utils.isNull(userInfo)) {
				userInfo = new UserInfo(id);
			}
			for (Field f : fs) {
				f.setAccessible(true);
				String name = f.getName();
				for (Field uf : ufs)
					if (uf.getName().equalsIgnoreCase(name)) {
						uf.setAccessible(true);

						try {
							Object value = f.get(userDetail);
							if (value instanceof String)
								value = Utils.toTrimOrNull((String) value);
							uf.set(userInfo, value);
						} catch (IllegalAccessException e) {

							e.printStackTrace();
						}
						break;
					}
			}

			// 信息保存成功
			if (userInfoDao.saveOrUpdate(userInfo)) {
				status = Status.success(Info.saveSuccess);
			} else
			// 数据库出错
			{
				status = Status.error(OtherError.databaseError);
			}

		}

		map.put(NameInfo.status, status.isSuccess());
		map.put(NameInfo.msg, status.getValue());

		return map;
	}

	public boolean save(Integer id, String image) {
		   return dao.save(id,image);
	}
}
