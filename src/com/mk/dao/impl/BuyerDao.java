package com.mk.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.entity.BuyerRemark;

@Repository
public class BuyerDao extends Dao<BuyerRemark> {
	
	
	public BuyerDao() {
		super(BuyerRemark.class);
		
	}

	public List<Map<String, Object>> list(Integer id,int start,int limit) {
        List<Map<String, Object>> userList =null;
        Session session = getSession();
        String sql="select r.pid,r.uid,r.text,r.rank,r.time,r.agree,u.name  from " 
       +"buyer_remark r join user u on r.uid=u.uid where r.pid=? order by r.time desc";
        try {
            Query query = (Query) session.createSQLQuery(sql);
            query.setInteger(0, id);
            query.setFirstResult(start);
            query.setMaxResults(limit);
            List<Object[]> list = query.list();
            if(!list.isEmpty()){
            	userList=new ArrayList<>();
            	for(Object[] os :list){
            		int i=0;
            		Map<String, Object> map =new HashMap<String, Object>();
            		map.put("pid", os[i++]);
            		map.put("uid", os[i++]);
            		map.put("text", os[i++]);
            		map.put("rank", os[i++]);
            		map.put("time", os[i++]);
            		map.put("agree", os[i++]);
            		map.put("name", os[i++]);
            		userList.add(map);
            	}
            }
           
        } catch (Exception e) {
           // e.printStackTrace();
        }
       
        return userList;
    }

	public boolean check(Integer pid, Integer uid) {

		Session session = getSession();
        String hql="select count(*) from " + entityClass.getSimpleName() +" p where p.pk.pid=? and p.pk.uid=?";
        try {
            Query query = (Query) session.createQuery(hql);
            query.setInteger(0, pid);
            query.setInteger(1, uid);
            return (long)query.uniqueResult()>0;
        } catch (Exception e) {
           // e.printStackTrace();
        }
  
		return false;
	}
}
