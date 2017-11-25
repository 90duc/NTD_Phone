package com.mk.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.entity.Company;

@Repository
public class CompanyDao extends Dao<Company> {

	public CompanyDao() {
		super(Company.class);
		
	}
   
}
