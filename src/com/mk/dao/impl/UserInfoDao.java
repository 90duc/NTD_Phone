package com.mk.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.entity.Company;
import com.mk.entity.User;
import com.mk.entity.UserInfo;

@Repository
public class UserInfoDao extends Dao<UserInfo> {

	public UserInfoDao() {
		super(UserInfo.class);
		
	}
   

}
