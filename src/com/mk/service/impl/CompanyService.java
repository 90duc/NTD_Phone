package com.mk.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.mk.dao.impl.CompanyDao;
import com.mk.entity.Company;
@Transactional
@org.springframework.stereotype.Service
public class CompanyService extends Service<Company,CompanyDao> {
   
}
