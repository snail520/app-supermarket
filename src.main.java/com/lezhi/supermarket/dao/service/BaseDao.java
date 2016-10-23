package com.lezhi.supermarket.dao.service;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T,PK extends Serializable> {
	
  public boolean insert(T obj);
  
  public void insertOfBatch(List<T> list);
  
  public boolean update(T obj);
  
  public boolean deleteById(PK id);
  
  public void deleteOfBatch(List<PK> ids);
  
  public T findById(PK id);
  
  public List<T> findAll();
  
  Long findAllCount();
}
