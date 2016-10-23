package com.lezhi.supermarket.model.util;

import java.lang.reflect.Method;
import org.apache.commons.lang.StringUtils;
import org.springframework.aop.MethodBeforeAdvice;

public class DataSourceAspect implements MethodBeforeAdvice {  

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		String methodName = arg0.getName();
		if(StringUtils.isNotBlank(methodName)){
			if(methodName.startsWith("add")    //写数据源
					|| methodName.startsWith("save") 
					|| methodName.startsWith("insert") 
					|| methodName.startsWith("update") 
					|| methodName.startsWith("modify")
					|| methodName.startsWith("edit") 
					|| methodName.startsWith("delete")){
				DataSourceSwitcher.setMaster();
			}else{
				DataSourceSwitcher.setSlave(); // 读数据源
			}
		}
	}  
}  

