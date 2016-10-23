package com.lezhi.supermarket.model.util;


public class DataSourceSwitcher{  
	
	@SuppressWarnings("rawtypes")
	private static final ThreadLocal contextHolder = new ThreadLocal();  

	@SuppressWarnings("unchecked")  
	public static void setDataSource(String dataSource) {  
		contextHolder.set(dataSource);  
	}  

	public static String getDataSource() {  
		return (String) contextHolder.get();  
	}  
	
	public static void setMaster(){  
		setDataSource("masterDataSource");
	}  

	public static void setSlave() {  
//		String slaveDataSourceType = ObjectUtils.toString(DataSourceSwitcher.getDataSourceType());
		setDataSource("slaveDataSource");
	}  
	
//	public static void setReport(){  
//		setDataSource("reportDataSource");
//	}  

	public static void clearDataSource() {  
		contextHolder.remove();  
	}  

//	public static int getDataSourceType(){
//		int temp[] = {1,2};
//		int index = (int) (Math.random() * temp.length);
//		return index + 1;
//	}
} 
