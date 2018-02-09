package com.mk.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.mk.entity.User;

@Repository
public class UserDao extends Dao<User> {
   

    public UserDao() {
		super(User.class);
	}

	public User get(String account) {
         
    	User user=null;
        Session session = getSession();
        String hql="from " + entityClass.getSimpleName() + " u where u.email=?";
        try {
            Query query = (Query) session.createQuery(hql);
            query.setString(0, account);
            List<User> userList = query.list();
            if(userList.size()>0)
            	user=userList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return user;
    }

	public boolean save(Integer id, String image) {
		    Session session = getSession();
	        String sql="update user set image=? where uid=?";
	        try {
	            Query query = (Query) session.createSQLQuery(sql);
	            query.setString(0, image);
	            query.setLong(1, id);
	           return query.executeUpdate()>0;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       return false;
	}

}
