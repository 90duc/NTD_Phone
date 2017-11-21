package com.mk.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.mk.entity.Company;
import com.mk.entity.LoginInfo;
import com.mk.entity.SensitiveOperation;
import com.mk.entity.User;

@Repository
public class SensitiveOperationDao extends Dao<SensitiveOperation> {

	public List<SensitiveOperation> list(Integer id, Integer start, Integer limit) {

		List<SensitiveOperation> userList = null;
		Session session = factory.openSession();
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
		session.close();
		return userList;
	}

}
