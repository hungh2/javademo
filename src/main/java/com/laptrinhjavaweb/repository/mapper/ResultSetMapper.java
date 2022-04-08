package com.laptrinhjavaweb.repository.mapper;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhjavaweb.repository.annotation.Column;

public class ResultSetMapper<T> {

	public List<T> mapRow(ResultSet rs,Class<T> tClass){
		List<T> results = new ArrayList<>();
		try {
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			Field[] fields = tClass.getDeclaredFields();
			while(rs.next()) {
				T object = tClass.newInstance();
				for(int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
					String columnName = resultSetMetaData.getColumnName(i + 1);
					Object columnValue = rs.getObject(i + 1);
					for(Field field: fields) {
						if(field.isAnnotationPresent(Column.class)) {
							Column column = field.getAnnotation(Column.class);
							if(column.name().equals(columnName) && columnValue != null) {
								BeanUtils.setProperty(object, field.getName(), columnValue);
								break;
							}
						}
					}
					Class<?> parentClass = tClass.getSuperclass();
					while(parentClass != null) {
						for(Field field: parentClass.getDeclaredFields()) {
							if(field.isAnnotationPresent(Column.class)) {
								Column column = field.getAnnotation(Column.class);
								if(column.name().equals(columnName) && columnValue != null) {
									BeanUtils.setProperty(object, field.getName(), columnValue);
									break;
								}
							}
						}
						parentClass = parentClass.getSuperclass();
					}
				}
				results.add(object);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return results;
	}
}
