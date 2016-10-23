package com.lezhi.supermarket.dao.service;

import java.io.Serializable;

public interface BaseDao<T,ID extends Serializable> {
	
  public boolean insert(T obj);
  
  public boolean update(T obj);
  
  public boolean delete(Class<?> c,String id);
  
  public T findById(Class<?> c,String id);
}
