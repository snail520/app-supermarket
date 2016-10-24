package com.lezhi.supermarket.biz.service.impl;

import java.io.Serializable;
import java.util.List;

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

	@Override
	public void insertOfBatch(List<T> list) throws Exception {
		baseDao.insertOfBatch(list);
	}

	@Override
	public boolean deleteById(PK id) {
		return baseDao.deleteById(id);
	}

	@Override
	public boolean update(T t) throws Exception {
		return baseDao.update(t);
	}
}
