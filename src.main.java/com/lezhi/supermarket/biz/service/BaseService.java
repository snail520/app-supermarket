package com.lezhi.supermarket.biz.service;

import java.io.Serializable;

public interface BaseService<T,ID extends Serializable>{
	
	public boolean insert(T obj) throws Exception;
	
	public boolean update(T obj) throws Exception;
	
	public boolean delete(Class<?> c,String id) throws Exception;
}
