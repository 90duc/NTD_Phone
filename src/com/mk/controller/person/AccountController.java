package com.mk.controller.person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.entity.LoginInfo;
import com.mk.entity.SensitiveOperation;
import com.mk.entity.User;
import com.mk.entity.UserInfo;
import com.mk.info.MsgInfo.Email;
import com.mk.info.MsgInfo.Login;
import com.mk.info.MsgInfo.Password;
import com.mk.info.NameInfo;
import com.mk.info.status.Status;
import com.mk.service.impl.UserService;
import com.mk.url.URL;
import com.mk.util.Utils;

@Controller
public class AccountController {

	@Autowired
	HttpSession session;

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(URL.Person.modifyPassword)
	public Map<String, Object> modifyPassword(String old, String new1,
			String new2,HttpServletRequest request) {

		Map<String, Object> map = null;
		if (!Objects.equals(new1, new2)) {
			// 两次新密码不一致
			map = new HashMap<>();
			Status status = Status.error(Password.twoNewPasswordDifferent);
			map.put(NameInfo.status, status.isSuccess());
			map.put(NameInfo.msg, status.getValue());
		}else if(Objects.equals(new1, old)){
			
			map = new HashMap<>();
			Status status = Status.error(Password.oldNewPasswordSame);
			map.put(NameInfo.status, status.isSuccess());
			map.put(NameInfo.msg, status.getValue());
		}else{
			
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
		} 
		
		saveModifyStatus(map, request,"修改密码");
		return map;
	}

	@ResponseBody
	@RequestMapping(URL.Person.modifyEmail)
	public Map<String, Object> modifyEmail(String old, String new1,HttpServletRequest request) {

		Map<String, Object> map = null;

		Integer id = (Integer) session.getAttribute(NameInfo.userId);
		if (id == null){
			// 未登录
			map = new HashMap<>();
			Status status = Status.error(Login.noLogin);
			map.put(NameInfo.status, status.isSuccess());
			map.put(NameInfo.msg, status.getValue());
		}else if(Objects.equals(old, new1)){
			map = new HashMap<>();
			Status status = Status.error(Email.newOldEmailSame);
			map.put(NameInfo.status, status.isSuccess());
			map.put(NameInfo.msg, status.getValue());
		}
		else map = userService.modifyEmail(id, old, new1);
		
        saveModifyStatus(map, request,"修改邮箱");
		return map;
	}
	private void saveModifyStatus(Map<String, Object> map,HttpServletRequest request,String type) {
		boolean status=(boolean) map.get(NameInfo.status);
		if (status){
			Integer id=(Integer) session.getAttribute(NameInfo.userId);
			userService.saveModifyOperation(id,Utils.getRemoteHost(request)+':'+request.getRemotePort(),type);
		}
	}
	@ResponseBody
	@RequestMapping(URL.Person.loginInfo)
	public Map<String, Object> getLoginInfo() {
		
		Map<String, Object> map = new HashMap<>();
		Status status ;
		Integer id = (Integer) session.getAttribute(NameInfo.userId);
		if (id == null){
			// 未登录	
			status = Status.error(Login.noLogin);			
		}else {
			status = Status.success(null);
			List<LoginInfo> list=userService.getLoginInfo(id,0,10);
			map.put(NameInfo.loginInfo, list);
		}
		map.put(NameInfo.status, status.isSuccess());
		map.put(NameInfo.msg, status.getValue());
		return map;
	}
	
	@ResponseBody
	@RequestMapping(URL.Person.sensitiveOperation)
	public Map<String, Object> getSensitiveOperation() {
		
		Map<String, Object> map = new HashMap<>();
		Status status ;
		Integer id = (Integer) session.getAttribute(NameInfo.userId);
		if (id == null){
			// 未登录	
			status = Status.error(Login.noLogin);			
		}else {
			status = Status.success(null);
			List<SensitiveOperation> list=userService.getSensitiveOperation(id,0,10);
			map.put(NameInfo.sensitiveOperation, list);
		}
		map.put(NameInfo.status, status.isSuccess());
		map.put(NameInfo.msg, status.getValue());
		return map;
	}
}
