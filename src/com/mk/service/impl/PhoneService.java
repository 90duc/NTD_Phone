package com.mk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mk.dao.impl.CompanyDao;
import com.mk.dao.impl.PhoneDao;
import com.mk.entity.Company;
import com.mk.entity.Phone;
import com.mk.util.Utils;

@org.springframework.stereotype.Service
public class PhoneService extends Service<Phone, PhoneDao> {

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
		if (Utils.isNullOrEmpty(text))
			ps = dao.list(start, limit);
		else {
			ps = dao.search(text, start, limit);
		}

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
		int index = 0;
		for (int i = 0; i < hobbys[0].length; i++) {
			if (hobbys[0][i].equals(type)) {
				index = i;
				break;
			}
		}
		String key = hobbys[0][index];
		String value = hobbys[1][index];
		ps = dao.hobby(key, value, start, limit);
		return ps;
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

	@Autowired
	private CompanyDao companyDao;
	
	public List<Company> topCompany(Integer start, Integer limit) {
		List<Company> ps = null;
		
		if ( Utils.isNull(start) || Utils.isNull(limit))
			return ps;
		ps=dao.topCompany(start, limit);
		
		return ps;
	}

}
