package com.lezhi.supermarket.biz.service;

import java.io.Serializable;

public interface BaseService<T,PK extends Serializable>{
	
	public boolean insert(T obj) throws Exception;
}
