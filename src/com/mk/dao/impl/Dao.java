package com.mk.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mk.dao.IDao;
import com.mk.entity.BuyerRemark;

/**
 * 
 * @author MK
 * @param <T>
 */

public abstract class Dao<T extends Serializable> implements IDao<T> {

	@Autowired
	private SessionFactory factory;

	protected final Class<T> entityClass;

	protected Session getSession() {

		return factory.getCurrentSession();

	}

	public Dao(Class<T> class1) {
		entityClass=class1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Integer id) {
		Session session = getSession();

		T t = (T) session.get(entityClass, id);

		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(java.lang.Integer id) {
		Session session = getSession();

		T t = (T) session.load(entityClass, id);

		return t;
	}

	@Override
	public boolean save(T t) {
		Session session = getSession();
		// session.beginTransaction();
		try {
			session.save(t);
			// session.getTransaction().commit();
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// session.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public boolean saveOrUpdate(T t) {
		Session session = getSession();
		// session.beginTransaction();
		try {
			session.saveOrUpdate(t);
			// session.getTransaction().commit();
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// session.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public boolean update(T t) {
		Session session = getSession();
		// session.beginTransaction();
		try {
			session.update(t);
			// session.getTransaction().commit();
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// session.getTransaction().rollback();
		}

		return false;
	}

	@Override
	public boolean delete(T t) {
		Session session = getSession();
		// session.beginTransaction();
		try {
			session.delete(t);
			// session.getTransaction().commit();
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// session.getTransaction().rollback();
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(Integer start, Integer limit) {

		List<T> userList = null;
		Session session = getSession();
		String hql = "from " + entityClass.getSimpleName();
		try {
			Query query = (Query) session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(limit);
			userList = query.list();

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return userList;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

}
