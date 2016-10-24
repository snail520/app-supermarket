package com.lezhi.supermarket.dao.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lezhi.supermarket.dao.service.BaseDao;
import com.lezhi.supermarket.model.util.AssConstant;
import com.lezhi.supermarket.model.util.GenericsUtils;
import com.lezhi.supermarket.model.util.Ignore;
import com.lezhi.supermarket.model.util.PrimaryKey;
import com.lezhi.supermarket.model.util.ReflectionUtils;
import com.lezhi.supermarket.model.util.SQLGenerator;
import com.lezhi.supermarket.model.util.Table;
import com.lezhi.supermarket.model.util.TableColumn;

@Repository("BaseDao")
public abstract class BaseDaoImpl<T,PK extends Serializable> implements BaseDao<T,PK>{
	
	@Autowired
	SqlSessionTemplate sqlTemplate;
	protected Logger    logger    = LoggerFactory.getLogger(this.getClass());
	private String basePackage = "com.lezhi.supermarket.dao.mapper.";
	private Class<T> entityClass;
	/**
     * 作cache 结构{T类的镜像,{数据库列名,实体字段名}}
     */
    private static final Map<Class<?>, Map<String, String>> classFieldMap = new HashMap<Class<?>,Map<String, String>>();
	private Map<String, String> currentColumnFieldNames;
	 //实体类主键名称
    private String pkName;
    //实体类ID字段名称
    private String idName;
    //主键的序列
    private String seq;
    private String tableName;
    private SQLGenerator<T> sqlGenerator;
    
	public BaseDaoImpl(){
		super();
		this.entityClass = (Class<T>)GenericsUtils.getSuperClassGenricType(this.getClass());
		currentColumnFieldNames = classFieldMap.get(entityClass);
		if (null == currentColumnFieldNames) {
            currentColumnFieldNames = new LinkedHashMap<String, String>();
            classFieldMap.put(entityClass, currentColumnFieldNames);
        }
		// 作cache
        Field[] fields = this.entityClass.getDeclaredFields();
        String fieldName = null;
        String columnName = null;
        for (Field field : fields) {
        	if (field.isAnnotationPresent(Ignore.class)) {
                continue;
            }
        	fieldName = field.getName();
            TableColumn tableColumn = field.getAnnotation(TableColumn.class);
            if (null != tableColumn) {
                columnName = tableColumn.value();
            } else {
                columnName = null;
            }
            //如果未标识特殊的列名，默认取字段名
            columnName = (StringUtils.isEmpty(columnName) ? StringUtils.upperCase(fieldName) : columnName);
            currentColumnFieldNames.put(columnName, fieldName);
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                // 取得ID的列名
                idName = fieldName;
                pkName = columnName;
                PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
                seq = primaryKey.seq();
            }
        }
        Table table = this.entityClass.getAnnotation(Table.class);
        if (null == table) 
        { throw new RuntimeException("类-"+ this.entityClass + ",未用@Table注解标识!!"); }
        tableName = table.value();
        sqlGenerator = new SQLGenerator<T>(currentColumnFieldNames.keySet(),tableName,pkName,seq);
	}
	
	@Override
	public boolean insert(T obj) {
		int res = sqlTemplate.insert("insert",sqlGenerator.sql_create(obj, currentColumnFieldNames));
		return returnResult(res);
	}
	
	@Override
	public void insertOfBatch(List<T> list) {
		if(null == list || list.isEmpty()){
            return;
        }
        List<T> temp = new ArrayList<T>();
        //获取列表的第一个对象的pk的value
        Object pkVal = null;
        for (int i=0; i < list.size(); i++) {
            T t = list.get(i);
            if(i==0){
                pkVal = ReflectionUtils.invokeGetterMethod(t, idName);
            }
            temp.add(t);
            if (i > 0 && i % AssConstant.FLUSH_CRITICAL_VAL == 0) {
                sqlTemplate.insert("createOfBatch", sqlGenerator
                        .sql_createOfBatch(temp, currentColumnFieldNames,pkVal));
                sqlTemplate.flushStatements();
                temp = new ArrayList<T>();
            }
        }
        sqlTemplate.insert("insertOfBatch", sqlGenerator.sql_createOfBatch(temp, currentColumnFieldNames,pkVal));
	}
	
	@Override
	public boolean deleteById(PK id) {
		int res = sqlTemplate.delete("deleteById",sqlGenerator.sql_removeById(id));
		return returnResult(res);
	}
	
	@Override
	public boolean update(T obj) {
		int res = sqlTemplate.update("update",sqlGenerator.sql_modify(obj,currentColumnFieldNames));
		return returnResult(res);
	}

	@Override
	public T findById(PK id) {
		Map<String, Object> resultMap = sqlTemplate.selectOne("findById", sqlGenerator.sql_findOneById(id));
        return handleResult(resultMap, this.entityClass);
	}
	
	@Override
	public void deleteOfBatch(List<PK> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findAllCount() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean returnResult(int result){
		if(result>0){
			return true;
		}else{
			return false;
		}
	}
	private T handleResult(Map<String, Object> resultMap, Class<T> tClazz) {
        T t = null;
        try {
            t = tClazz.newInstance();
        } catch (InstantiationException e) {
            logger.error("/********************************");
            logger.error("封装查询结果时，实例化对象(" + this.entityClass + ")时，出现异常!"
                    + e.getMessage());
            logger.error("/********************************");
        } catch (IllegalAccessException e) {
            logger.error("/********************************");
            logger.error("封装查询结果时，实例化对象(" + this.entityClass + ")时，出现异常!"
                    + e.getMessage());
            logger.error("/********************************");
        }
        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            String key = entry.getKey();
            key = currentColumnFieldNames.get(key);
            Object val = entry.getValue();
            ReflectionUtils.invokeSetterMethod(t, key, val);
        }
        return t;
    }
}
