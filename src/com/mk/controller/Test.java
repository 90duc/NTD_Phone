package com.mk.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.entity.Company;
import com.mk.entity.Phone;
import com.mk.service.impl.CompanyService;
import com.mk.service.impl.PhoneService;

@Controller
public class Test {

	@Autowired
	private CompanyService companyDao;
	
	@Autowired
	private PhoneService phoneDao;
	
	@ResponseBody
	@RequestMapping("/a")
	public Company name() {
		
		Company b=(Company) companyDao.get(1);
		
		 return b;
	}
	
	@ResponseBody
	@RequestMapping("/p")
	public Phone phone() {
		
		Phone b=(Phone) phoneDao.get(1);
		
		 return b;
	}
	
	public static void main(String[] args) {
		String password ="a-\\p@q9.com";
		System.out.println(password.matches("[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+"));
	}
	
	
}
