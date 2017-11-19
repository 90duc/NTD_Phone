package com.mk.controller.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.entity.Company;
import com.mk.entity.Phone;
import com.mk.service.impl.PhoneService;
import com.mk.url.URL;
import com.mk.util.Utils;

@Controller
public class PersonController {


	@Autowired
	private PhoneService phoneDao;
	
	@ResponseBody
	@RequestMapping(URL.Person.login)
	public Company login(String account,String password) {
		
	    String pass = Utils.decode( password);
		 System.out.println(pass);
		 return null;
	}
	
	
}
