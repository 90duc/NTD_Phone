package com.mk.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.mk.entity.Company;
import com.mk.entity.User;

@Repository
public class UserDao extends Dao<User> {
   

    public User get(String account) {
         
    	User user=null;
        Session session = factory.openSession();
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
        session.close();
        return user;
    }

}