package com.mk.controller.person;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.entity.UserInfo;
import com.mk.info.NameInfo;
import com.mk.service.impl.UserService;
import com.mk.url.URL;

@Controller
public class PersonInfoController {

	@Autowired
	HttpSession session;
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(URL.Person.userInfo)
	public UserInfo getUserInfo() {

		Integer id =(Integer) session.getAttribute(NameInfo.userId);
		return userService.getUserInfo(id);	
	
	}
	
	
}
