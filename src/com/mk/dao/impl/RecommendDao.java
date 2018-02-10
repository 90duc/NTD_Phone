package com.mk.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.entity.Company;
import com.mk.entity.Phone;

@Repository
public class RecommendDao extends Dao<Phone> {

	public RecommendDao() {
		super(Phone.class);

	}

	public List<Integer> queryPhoneRecom(int pid, int start, int limit) {
		Session session = getSession();
		List<Integer> list = null;
		String sql = "select dpid from phone_recom where spid=? order by degree desc ";
		try {
			Query query = (Query) session.createSQLQuery(sql);
			query.setInteger(0, pid);
			query.setFirstResult(start);
			query.setMaxResults(limit);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Integer> queryItemRecom(Integer uid, int start, int limit) {
		Session session = getSession();
		List<Integer> list = null;
		String sql = "select pid from item_recom ";
		if (uid != null)
			sql = sql + "where uid=? ";
		sql = sql + "order by degree desc ";
		try {
			Query query = (Query) session.createSQLQuery(sql);
			if (uid != null) {
				query.setInteger(0, uid);
			}
			query.setFirstResult(start);
			query.setMaxResults(limit);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Integer> queryUserRecom(Integer uid, int start, int limit) {
		Session session = getSession();
		List<Integer> list = null;
		String sql = "select pid from user_recom ";
		if (uid != null)
			sql = sql + "where uid=? ";
		sql = sql + "order by degree desc ";
		try {
			Query query = (Query) session.createSQLQuery(sql);
			if (uid != null) {
				query.setInteger(0, uid);
			}
			query.setFirstResult(start);
			query.setMaxResults(limit);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
