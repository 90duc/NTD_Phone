package com.mk.controller.person;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.entity.Company;
import com.mk.entity.Phone;
import com.mk.entity.User;
import com.mk.entity.UserInfo;
import com.mk.info.MsgInfo.Password;
import com.mk.info.NameInfo;
import com.mk.info.status.Status;
import com.mk.service.impl.PhoneService;
import com.mk.service.impl.UserService;
import com.mk.url.URL;
import com.mk.util.IpUtils;
import com.mk.util.Utils;

@Controller
public class LoginController {

	@Autowired
	HttpSession session;

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(URL.Person.checkLogin)
	public Map<String, Object> checkLogin() {

		Integer id =(Integer) session.getAttribute(NameInfo.userId);
		Map<String, Object> map = userService.checkLogin(id);	
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(URL.Person.preLogin)
	public String preLogin() {

		String id =session.getId()+"|"+System.currentTimeMillis();	
		session.setAttribute(NameInfo.preLogin, id);
		return id;
	}
	
	@ResponseBody
	@RequestMapping(URL.Person.login)
	public Map<String, Object> login(String account, String password,long time,HttpServletRequest request) {
        String preLogin=(String) session.getAttribute(NameInfo.preLogin);
		Map<String, Object> map = userService.login(account, password,preLogin,time);
		
		this.saveLoginStatus(map,request);
		
		return map;
	}

	private void saveLoginStatus(Map<String, Object> map,HttpServletRequest request) {
		boolean status=(boolean) map.get(NameInfo.status);
		if (status){
			User user =(User)map.get(NameInfo.user);
			session.setAttribute(NameInfo.userId, user.getUid());
			userService.saveLoginInfo(user.getUid(),IpUtils.getIp(request)+':'+request.getRemotePort());
		}
	}
	
	@ResponseBody
	@RequestMapping(URL.Person.logout)
	public void logout() {
    
		session.removeAttribute(NameInfo.userId);
		
	}
	
	@ResponseBody
	@RequestMapping(URL.Person.register)
	public Map<String, Object> register(String account, String userName,
			String password, String password2,HttpServletRequest request) {

		Map<String, Object> map = null;
		if (Objects.equals(password, password2))
			map = userService.register(account, userName, password);
		else {
			//两次密码不正确
			map = new HashMap<>();
			Status status = Status.error(Password.twoPasswordDifferent);
			map.put(NameInfo.status, status.isSuccess());
			map.put(NameInfo.msg, status.getValue());
		}

		this.saveLoginStatus(map,request);
			
		return map;
	}

	
}
