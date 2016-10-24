package com.lezhi.supermarket.biz.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T,PK extends Serializable>{
	
	public boolean insert(T obj) throws Exception;
	
	public void insertOfBatch(List<T> list) throws Exception;
	
	public boolean deleteById(PK id);
	
	public boolean update(T t) throws Exception;
	
	public T findById(PK id);
	
	public List<T> findAll() throws Exception;
	
	public Long findAllCount() throws Exception;
}
