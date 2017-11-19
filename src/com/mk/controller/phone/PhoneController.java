package com.mk.controller.phone;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.entity.Company;
import com.mk.entity.Phone;
import com.mk.service.impl.PhoneService;
import com.mk.url.URL;

@Controller
public class PhoneController {


	@Autowired
	private PhoneService phoneService;
	
	@ResponseBody
	@RequestMapping(URL.Phone.detail)
	public Map<String, Object> get(Integer id) {
		
	     Phone p=phoneService.get(id);
	     List<String> imgs=phoneService.getImages(id);
		 Map<String, Object> map =new HashMap<String, Object>();
		 map.put("phone", p);
		 map.put("images", imgs);
		 return map;
	}
	@ResponseBody
	@RequestMapping(URL.Phone.images)
	public List<String> getImage(Integer id) {
		
	     List<String> imgs=phoneService.getImages(id);
		 return imgs;
	}
	
	@ResponseBody
	@RequestMapping(URL.Phone.search)
	public List<Phone> search(String text,Integer start,Integer limit) {
		
	    List<Phone> list=phoneService.search(text,start, limit);
		
		 return list;
	}
	
	@ResponseBody
	@RequestMapping(URL.Phone.hobby)
	public List<Phone> hobby(String type,Integer start,Integer limit) {
		
		List<Phone> list=phoneService.hobby(type,start, limit);
		
		 return list;
	}
	
	@ResponseBody
	@RequestMapping(URL.Phone.searchBy)
	public List<Phone> searchBy(String key,String value,Integer start,Integer limit) {
		
		List<Phone> list=phoneService.searchBy(key,value,start, limit);
		
		 return list;
	}
	
	@ResponseBody
	@RequestMapping(URL.Phone.typeList)
	public List<Phone> typeList(String type,Integer start,Integer limit) {
		
		 List<Phone> list=phoneService.typeList(type,start, limit);	
		 return list;
	}
	
	@ResponseBody
	@RequestMapping(URL.Phone.company)
	public List<Company> topCompany(Integer start,Integer limit) {
		
		List<Company> list=phoneService.topCompany(start, limit);
		
		 return list;
	}
}
