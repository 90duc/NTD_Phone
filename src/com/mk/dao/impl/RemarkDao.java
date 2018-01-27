package com.mk.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.entity.Remark;

@Repository
public class RemarkDao extends Dao<Remark> {
	
	
	public RemarkDao() {
		super(Remark.class);
		
	}

	public List<Map<String, Object>> list(Integer id,int start,int limit) {
        List<Map<String, Object>> userList =null;
        Session session = getSession();
        String sql="select r.pid,r.uid,r.text,r.rank,r.time,r.agree,r.type,u.name  from " 
       +"remark r join user u on r.uid=u.uid where r.pid=? order by r.time desc";
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
            		map.put("type", os[i++]);
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

	public Map<String, Object> getRemakRange(Integer pid) {
		
		 Map<String, Object> map=new HashMap<>();
	        Session session = getSession();
	        String sql="select rank,count(1) from " 
	       +" remark where pid=? group by rank order by rank desc";
	        try {
	            Query query = (Query) session.createSQLQuery(sql);
	            query.setInteger(0, pid);
	            List<Object[]> list = query.list();
	            int d=0;
	            int[] data=new int[5];
	            for(Object[] os:list){
	            	data[Integer.parseInt(os[0].toString())/2-1]=Integer.parseInt(os[1].toString());
	            	d+=Integer.parseInt(os[1].toString());
	            }
	            map.put("size", d);
				map.put("range", data);
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       
	
	        return map;
	}
}
