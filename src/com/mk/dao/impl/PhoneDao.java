package com.mk.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.entity.Company;
import com.mk.entity.Imgs;
import com.mk.entity.Phone;

@Repository
public class PhoneDao extends Dao<Phone> {
	
	public PhoneDao() {
		super(Phone.class);
		// TODO Auto-generated constructor stub
	}

	public List<String> getImages(Integer id) {
        List<String> userList = null;
        Session session = getSession();
        String hql="select p.imgsPK.image from " + Imgs.class.getSimpleName() +" p where p.imgsPK.pid=?";
        try {
            Query query = (Query) session.createQuery(hql);
            query.setParameter(0, id);
            userList = query.list();
         
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return userList;
    }
	
	public List<Phone> search(String text,int start,int limit) {
        List<Phone> userList = null;
        Session session = getSession();
        String hql="from " + entityClass.getSimpleName() +" p where p.name like ?";
        try {
            Query query = (Query) session.createQuery(hql);
            query.setString(0, "%"+text+"%");
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
	        String hql="from " + entityClass.getSimpleName() +"  where "+key+" >= ? order by "+key+" desc";
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
	        String hql="from " + entityClass.getSimpleName() +" p  where p."+key+" like ? order by p.name asc , p."+key+" desc";
	        try {
	            Query query = (Query) session.createQuery(hql);
	            query.setString(0, "%"+value+"%");
	            query.setFirstResult(start);
	            query.setMaxResults(limit);
	            userList = query.list();
	         
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       
	       
	        return userList;
	}
	public List<Phone> typeList(String key,Integer start, Integer limit) {
		 List<Phone> userList = null;
	        Session session = getSession();
	        String hql="from " + entityClass.getSimpleName() +" p order by "+key+" desc";
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
	        Session session =getSession();
	        String hql="from " + entityClass.getSimpleName() +" p  where p.cid=?";
	        try {
	            Query query = (Query) session.createQuery(hql);
	            query.setString(0,value);
	            query.setFirstResult(start);
	            query.setMaxResults(limit);
	            userList = query.list();
	         
	        } catch (Exception e) {
	            //e.printStackTrace();
	        }
	       
	       
	        return userList;
	}
	
	
	public List<Company> topCompany(Integer start, Integer limit) {
	    List<Company> userList = null;
        Session session = getSession();
        String hql="select p.cid from " + entityClass.getSimpleName() +" p group by p.cid order by max(p.rank) desc ";
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
	
}
