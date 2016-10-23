package com.lezhi.supermarket.biz.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.lezhi.supermarket.biz.service.BaseService;
import com.lezhi.supermarket.dao.service.BaseDao;


public abstract class BaseServiceImpl<T,PK extends Serializable> implements BaseService<T,PK> {
	@Autowired
	private BaseDao<T,PK> baseDao;
	
    @Override
	public boolean insert(T obj) throws Exception {
		return baseDao.insert(obj);
    }
}
