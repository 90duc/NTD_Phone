package com.mk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mk.dao.impl.PhoneDao;
import com.mk.dao.impl.RecommendDao;
import com.mk.entity.Company;
import com.mk.entity.Phone;
import com.mk.util.Utils;

@Transactional
@org.springframework.stereotype.Service
public class PhoneService extends Service<Phone, PhoneDao> {

	@Autowired
	private RecommendDao recommendDao;

	public List<String> getImages(Integer id) {
		List<String> ps = null;
		if (Utils.isNull(id))
			return ps;
		ps = dao.getImages(id);
		return ps;
	}

	public List<Phone> search(String text, Integer start, Integer limit) {
		List<Phone> ps = null;
		if (Utils.isNull(start) || Utils.isNull(limit))
			return ps;

		text = Utils.toTrimOrNull(text);
		ps = dao.search(text, start, limit);

		return ps;
	}

	public static String[][] hobbys = {
			{ "pixels", "backcamera", "battery", "ram" },
			{ "1920x1080像素", "1200万像素", "2750mAh", "4GB" } };

	public List<Phone> hobby(String type, Integer start, Integer limit) {
		List<Phone> ps = null;
		type = Utils.toTrimOrNull(type);
		if (Utils.isNullOrEmpty(type) || Utils.isNull(start)
				|| Utils.isNull(limit))
			return ps;
		int index = getHobbyIndex(type);
		String key = hobbys[0][index];
		String value = hobbys[1][index];
		ps = dao.hobby(key, value, start, limit);
		return ps;
	}

	private int getHobbyIndex(String type) {
		int index = 0;
		for (int i = 0; i < hobbys[0].length; i++) {
			if (hobbys[0][i].equals(type)) {
				index = i;
				break;
			}
		}
		return index;
	}

	static String[][] types = { { "new", "hot", "top" },
			{ "year", "commentSize", "rank" } };

	public List<Phone> typeList(String type, Integer start, Integer limit) {
		List<Phone> ps = null;
		type = Utils.toTrimOrNull(type);
		if (Utils.isNullOrEmpty(type) || Utils.isNull(start)
				|| Utils.isNull(limit))
			return ps;
		int index = 0;
		for (int i = 0; i < types[0].length; i++) {
			if (types[0][i].equals(type)) {
				index = i;
				break;
			}
		}
		String key = types[1][index];
		ps = dao.typeList(key, start, limit);

		return ps;
	}

	static String[] tagAttr = { "core", "coreRate", "coreType", "rom", "ram",
			"battery", "batteryType", "year" };

	public List<Phone> searchBy(String key, String value, Integer start,
			Integer limit) {
		List<Phone> ps = null;
		key = Utils.toTrimOrNull(key);
		value = Utils.toTrimOrNull(value);
		if (Utils.isNullOrEmpty(key) || Utils.isNullOrEmpty(value)
				|| Utils.isNull(start) || Utils.isNull(limit))
			return ps;
		if (key.equals("company"))
			ps = dao.searchCompany(value, start, limit);
		else
			for (String tag : tagAttr)
				if (tag.equals(key))
					ps = dao.searchBy(key, value, start, limit);

		return ps;
	}

	String[] companyType = { "remark", "hobby","config"};

	public List<Company> topCompany(Integer uid,String type,String key, String value, Integer start,
			Integer limit) {
		List<Company> ps = null;

		if (Utils.isNull(type) || Utils.isNull(start) || Utils.isNull(limit))
			return ps;
		if (companyType[0].equalsIgnoreCase(type)) {
			
			ps = dao.topCompany(start, limit);
		} else if (companyType[1].equalsIgnoreCase(type)) {

			ps=dao.topRemarkCompany(uid, start, limit);
		} else if (companyType[2].equalsIgnoreCase(type)) {
			int index=getHobbyIndex(key);
			ps=dao.topCompanyHobby(hobbys[0][index],hobbys[1][index], start, limit);
		} else if (companyType[3].equalsIgnoreCase(type)) {
			if("company".equalsIgnoreCase(key)){
				ps=dao.topCompany(start, limit);
			}else{
			 ps=dao.topCompanySearchBy(key, value, start, limit);
			}
		}
		return ps;
	}

	final String[] recommType = { "user", "item", "phone" };

	public List<Phone> getRecommend(Integer start, Integer limit, String type,
			Integer uid, Integer pid) {
		List<Phone> phones = null;
		List<Integer> pidList = null;
		if (recommType[0].equalsIgnoreCase(type)) {
			pidList = recommendDao.queryUserRecom(uid, start, limit);
		} else if (recommType[1].equalsIgnoreCase(type)) {
			pidList = recommendDao.queryItemRecom(uid, start, limit);
		} else if (recommType[2].equalsIgnoreCase(type)) {
			pidList = recommendDao.queryPhoneRecom(pid, start, limit);
		}
		if (pidList != null) {
			phones = new ArrayList<>();
			for (Integer u : pidList) {
				phones.add(dao.get(u));
			}
		}
		return phones;
	}

	public List<Phone> getRemarkPhone(Integer uid, Integer start, Integer limit) {

		return dao.getRemarkPhone(uid, start, limit);
	}

}
