package com.mk.controller.phone;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.entity.Remark;
import com.mk.info.NameInfo;
import com.mk.service.impl.RemarkService;
import com.mk.url.URL;

@Controller
public class RemarkController {

	@Autowired
	HttpSession session;
	@Autowired
	private RemarkService remarkService;
	
	@ResponseBody
	@RequestMapping(URL.Phone.Remark)
	public List<Map<String, Object>> getRemark(Integer id, Integer start, Integer limit) {

		return remarkService.getRemark(id, start, limit);

	}
	

	
	@ResponseBody
	@RequestMapping(URL.Phone.checkRemark)
	public Map<String, Object> checkRemark(Integer id, Integer start, Integer limit) {

		Integer uid =(Integer) session.getAttribute(NameInfo.userId);
		return remarkService.checkRemark(id,uid);
	}
	
	@ResponseBody
	@RequestMapping(URL.Phone.saveWantRemark)
	public Map<String, Object> saveWanter(String text,Integer pid,Integer rank) {

		Integer uid =(Integer) session.getAttribute(NameInfo.userId);
		return remarkService.saveRemark(text,pid,uid,rank,0);

	}
	
	@ResponseBody
	@RequestMapping(URL.Phone.saveBuyRemark)
	public Map<String, Object> saveBuyer(String text,Integer pid,Integer rank) {

		Integer uid =(Integer) session.getAttribute(NameInfo.userId);
		return remarkService.saveRemark(text,pid,uid,rank,1);

	}

}
