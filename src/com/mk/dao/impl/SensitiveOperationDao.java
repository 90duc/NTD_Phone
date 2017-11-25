package com.mk.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.entity.Company;
import com.mk.entity.LoginInfo;
import com.mk.entity.SensitiveOperation;
import com.mk.entity.User;

@Repository
public class SensitiveOperationDao extends Dao<SensitiveOperation> {

	public SensitiveOperationDao() {
		super(SensitiveOperation.class);
		
	}

	public List<SensitiveOperation> list(Integer id, Integer start, Integer limit) {

		List<SensitiveOperation> userList = null;
		Session session = getSession();
		String hql = "from " + entityClass.getSimpleName() + " u where u.operationPK.uid=? order by u.operationPK.time desc";
		try {
			Query query = (Query) session.createQuery(hql);
			query.setInteger(0, id);
			query.setFirstResult(start);
			query.setMaxResults(limit);
			userList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	}

}
