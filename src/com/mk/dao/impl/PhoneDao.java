package com.mk.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.entity.Company;
import com.mk.entity.Imgs;
import com.mk.entity.Phone;
import com.mk.entity.Remark;
import com.mk.util.Utils;

@Repository
public class PhoneDao extends Dao<Phone> {

	public PhoneDao() {
		super(Phone.class);
		// TODO Auto-generated constructor stub
	}

	public List<String> getImages(Integer id) {
		List<String> userList = null;
		Session session = getSession();
		String hql = "select p.imgsPK.image from " + Imgs.class.getSimpleName()
				+ " p where p.imgsPK.pid=?";
		try {
			Query query = (Query) session.createQuery(hql);
			query.setParameter(0, id);
			userList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	public List<Phone> search(String text, int start, int limit) {
		List<Phone> userList = null;
		Session session = getSession();
		String hql = "from " + entityClass.getSimpleName()
				+ " p where p.name like ? order by p.rank desc";
		try {
			Query query = (Query) session.createQuery(hql);
			if (Utils.isNullOrEmpty(text))
				text = "";
			query.setString(0, "%" + text + "%");
			query.setFirstResult(start);
			query.setMaxResults(limit);
			userList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	public List<Phone> hobby(String key, String value, Integer start,
			Integer limit) {
		List<Phone> userList = null;
		Session session = getSession();
		String hql = "from " + entityClass.getSimpleName() + "  where " + key
				+ " >= ? order by " + key + " desc";
		try {
			Query query = (Query) session.createQuery(hql);
			query.setString(0, value);
			query.setFirstResult(start);
			query.setMaxResults(limit);
			userList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	public List<Phone> searchBy(String key, String value, Integer start,
			Integer limit) {
		List<Phone> userList = null;
		Session session = getSession();
		String hql = "from " + entityClass.getSimpleName() + " p  where p."
				+ key + " like ? order by p.name asc , p." + key + " desc";
		try {
			Query query = (Query) session.createQuery(hql);
			query.setString(0, "%" + value + "%");
			query.setFirstResult(start);
			query.setMaxResults(limit);
			userList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	public List<Phone> typeList(String key, Integer start, Integer limit) {
		List<Phone> userList = null;
		Session session = getSession();
		String hql = "from " + entityClass.getSimpleName() + " p order by "
				+ key + " desc";
		try {
			Query query = (Query) session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(limit);
			userList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	public List<Phone> searchCompany(String value, Integer start, Integer limit) {
		List<Phone> userList = null;
		Session session = getSession();
		String hql = "from " + entityClass.getSimpleName()
				+ " p  where p.cid=?";
		try {
			Query query = (Query) session.createQuery(hql);
			query.setString(0, value);
			query.setFirstResult(start);
			query.setMaxResults(limit);
			userList = query.list();

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return userList;
	}

	public List<Company> topCompany(Integer start, Integer limit) {
		List<Company> userList = null;
		Session session = getSession();
		String hql = "select p.cid from " + entityClass.getSimpleName()
				+ " p group by p.cid order by max(p.rank) desc ";
		try {
			Query query = (Query) session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(limit);
			userList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	public List<Company> topRecomCompany(Integer uid, Integer start,
			Integer limit) {
		List<Company> userList = null;
		Session session = getSession();

		String hql = "select p.cid from " + entityClass.getSimpleName()
				+ " as p , Remark as r where p.pid=r.pk.pid ";
		if (uid != null)
			hql = hql + "and r.pk.uid=? ";
		hql = hql + "group by p.cid order by sum(p.rank) desc ";
		try {
			Query query = (Query) session.createQuery(hql);
			if (uid != null)
				query.setInteger(0, uid);
			query.setFirstResult(start);
			query.setMaxResults(limit);
			userList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	public List<Company> topCompanySearchBy(String key, String value,
			Integer start, Integer limit) {
		List<Company> userList = null;
		Session session = getSession();
		String hql = "select p.cid from " + entityClass.getSimpleName()
				+ " p  where p." + key
				+ " like ? group by p.cid order by sum(p.rank) desc";
		try {
			Query query = (Query) session.createQuery(hql);
			query.setString(0, "%" + value + "%");
			query.setFirstResult(start);
			query.setMaxResults(limit);
			userList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	public List<Company> topCompanyHobby(String key, String value,
			Integer start, Integer limit) {
		List<Company> userList = null;
		Session session = getSession();
		String hql = "select p.cid from " + entityClass.getSimpleName()
				+ " p  where p." + key
				+ " >= ? group by p.cid order by sum(p.rank) desc";
		try {
			Query query = (Query) session.createQuery(hql);
			query.setString(0, value);
			query.setFirstResult(start);
			query.setMaxResults(limit);
			userList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	public List<Phone> getRemarkPhone(Integer uid, Integer start, Integer limit) {

		List<Phone> userList = null;
		Session session = getSession();
		String hql = "from " + entityClass.getSimpleName()
				+ " p  where p.pid in ( select pk.pid from "
				+ Remark.class.getSimpleName() + " where pk.uid=? )";
		try {
			Query query = (Query) session.createQuery(hql);
			query.setInteger(0, uid);
			query.setFirstResult(start);
			query.setMaxResults(limit);
			userList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	public List<Company> topCompanyByCid(String cid, Integer start,
			Integer limit) {

		return null;
	}

}
