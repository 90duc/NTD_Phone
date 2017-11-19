package com.mk.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mk.dao.IDao;

/**
 *
 * @author MK
 * @param <T>
 */
public abstract class Dao<T extends Serializable> implements IDao<T> {

	@Autowired
	protected SessionFactory factory;
	
    protected final Class<T> entityClass;

    @SuppressWarnings("unchecked")
	public Dao() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
	@Override
    public T get(Integer id) {
        Session session = factory.openSession();

        T t = (T) session.get(entityClass, id);
        session.close();
        return t;
    }

    @SuppressWarnings("unchecked")
	@Override
    public T load(java.lang.Integer id) {
        Session session = factory.openSession();
      
        T t = (T) session.load(entityClass, id);
        
        return t;
    }

    @Override
    public boolean save(T t) {
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.save(t);
            session.getTransaction().commit();
           
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return false;
    }

    @Override
    public boolean saveOrUpdate(T t) {
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.saveOrUpdate(t);
            session.getTransaction().commit();
        
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return false;
    }

    @Override
    public boolean update(T t) {
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.update(t);
            session.getTransaction().commit();
          
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return false;
    }

    @Override
    public boolean delete(T t) {
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.delete(t);
            session.getTransaction().commit();
          
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return false;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<T> list(Integer start,Integer limit) {

        List<T> userList = null;
        Session session = factory.openSession();
        String hql="from " + entityClass.getSimpleName();
        try {
            Query query = (Query) session.createQuery(hql);
            query.setFirstResult(start);
            query.setMaxResults(limit);
            userList = query.list();
         
        } catch (Exception e) {
            //e.printStackTrace();
        }
        session.close();
        return userList;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

}
