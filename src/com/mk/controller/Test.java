package com.mk.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.dao.impl.CompanyDao;
import com.mk.dao.impl.PhoneDao;
import com.mk.entity.Company;
import com.mk.entity.Phone;
import com.mk.service.impl.CompanyService;
import com.mk.service.impl.PhoneService;
import com.mk.util.Utils;

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
		String a="张三";
		String p="YTVlMGUwZjU4OGNmMGM1NDliN2Y0NjhkMmQyMGYzOWY3YzRhOGQwOWNhMzc2MmFmNjFlNTk1MjA5NDNkYzI2NDk0Zjg5NDFiMDAwMDQzMmFjYTNhMWUzNDVlMzM5ZjM1YTMwYzhmNjVlZGNl";
		String b="7c4a8d09ca3762af61e59520943dc26494f8941b";
		System.out.println(Utils.decode(p));
	}
}
