package com.mk.controller.phone;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.entity.BuyerRemark;
import com.mk.entity.WanterRemark;
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
	@RequestMapping(URL.Phone.wantRemark)
	public List<Map<String, Object>> getWanter(Integer id, Integer start, Integer limit) {
		return remarkService.getWanterRemark(id, start, limit);
	}
	
	@ResponseBody
	@RequestMapping(URL.Phone.buyRemark)
	public List<Map<String, Object>> getBuyer(Integer id, Integer start, Integer limit) {

		return remarkService.getBuyerRemark(id, start, limit);

	}
	
	@ResponseBody
	@RequestMapping(URL.Phone.checkWantRemark)
	public Map<String, Object> checkWanter(Integer id) {
		Integer uid =(Integer) session.getAttribute(NameInfo.userId);
		return remarkService.checkWanterRemark(id,uid);
	}
	
	@ResponseBody
	@RequestMapping(URL.Phone.checkBuyRemark)
	public Map<String, Object> checkBuyer(Integer id, Integer start, Integer limit) {

		Integer uid =(Integer) session.getAttribute(NameInfo.userId);
		return remarkService.checkBuyerRemark(id,uid);
	}
	
	@ResponseBody
	@RequestMapping(URL.Phone.saveWantRemark)
	public Map<String, Object> saveWanter(String text,Integer pid,Integer rank) {

		Integer uid =(Integer) session.getAttribute(NameInfo.userId);
		return remarkService.saveWanterRemark(text,pid,uid,rank);

	}
	
	@ResponseBody
	@RequestMapping(URL.Phone.saveBuyRemark)
	public Map<String, Object> saveBuyer(String text,Integer pid,Integer rank) {

		Integer uid =(Integer) session.getAttribute(NameInfo.userId);
		return remarkService.saveBuyerRemark(text,pid,uid,rank);

	}

}
