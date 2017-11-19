package com.mk.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.mk.dao.impl.Dao;
import com.mk.service.IService;
import com.mk.util.Utils;

/**
 *
 * @author MK
 * @param <T>
 */
public abstract class Service<T extends Serializable,D extends Dao<T>> implements IService<T> {

	
	protected D dao;

	
	

	public Service() {
    }

	@Autowired
    public void setDao(D dao) {
		this.dao = dao;
	}

	@Override
    public T get(Integer id) {
        
    	if(Utils.isNull(id))
    		return null;
    	
        return dao.get(id);
    }

    @Override
    public T load(Integer id) {
    	if(Utils.isNull(id))
    		return null;
    	
        return dao.load(id);
    }

    @Override
    public boolean save(T t) {
        
        return dao.save(t);
    }

    @Override
    public boolean saveOrUpdate(T t) {
        
        return dao.saveOrUpdate(t);
    }

    @Override
    public boolean update(T t) {
       
        return dao.update(t);
    }

    @Override
    public boolean delete(T t) {
        
        return dao.delete(t);
    }

    @Override
    public List<T> list(Integer start,Integer limit) {

		if(Utils.isNull(start)||Utils.isNull(limit))
			return null;
		
        return dao.list(start,limit);
    }
}
