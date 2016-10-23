package com.lezhi.supermarket.model.util;



import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:标识为实体类的ID
 * @author shizy
 * @createDateTime 
 * @version  
 * @Company: MSD. 
 * @Copyright: Copyright (c) 2013
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table{
	public String value();
}
