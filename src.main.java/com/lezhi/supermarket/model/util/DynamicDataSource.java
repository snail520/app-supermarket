package com.lezhi.supermarket.model.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {  

	@Override  
	protected Object determineCurrentLookupKey() {  
		return DataSourceSwitcher.getDataSource();
	}  
} 
