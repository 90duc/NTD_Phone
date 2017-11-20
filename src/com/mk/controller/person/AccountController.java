package com.mk.controller.person;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.entity.UserInfo;
import com.mk.info.MsgInfo.Login;
import com.mk.info.MsgInfo.Password;
import com.mk.info.NameInfo;
import com.mk.info.status.Status;
import com.mk.service.impl.UserService;
import com.mk.url.URL;

@Controller
public class AccountController {

	@Autowired
	HttpSession session;

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(URL.Person.modifyPassword)
	public Map<String, Object> modifyPassword(String old, String new1,
			String new2) {

		Map<String, Object> map = null;
		if (Objects.equals(new1, new2)) {
			Integer id = (Integer) session.getAttribute(NameInfo.userId);
			if (id != null)
				map = userService.modifyPassword(id, old, new1);
			else {
				// 未登录
				map = new HashMap<>();
				Status status = Status.error(Login.noLogin);
				map.put(NameInfo.status, status.isSuccess());
				map.put(NameInfo.msg, status.getValue());
			}
		} else {
			// 两次新密码不一致
			map = new HashMap<>();
			Status status = Status.error(Password.twoNewPasswordDifferent);
			map.put(NameInfo.status, status.isSuccess());
			map.put(NameInfo.msg, status.getValue());
		}

		return map;
	}

	@ResponseBody
	@RequestMapping(URL.Person.modifyEmail)
	public Map<String, Object> modifyEmail(String old, String new1) {

		Map<String, Object> map = null;

		Integer id = (Integer) session.getAttribute(NameInfo.userId);
		if (id != null)
			map = userService.modifyEmail(id, old, new1);
		else {
			// 未登录
			map = new HashMap<>();
			Status status = Status.error(Login.noLogin);
			map.put(NameInfo.status, status.isSuccess());
			map.put(NameInfo.msg, status.getValue());
		}

		return map;
	}
}
