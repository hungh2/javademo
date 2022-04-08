package com.laptrinhjavaweb.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.repository.annotation.Column;
import com.laptrinhjavaweb.repository.annotation.Entity;
import com.laptrinhjavaweb.repository.annotation.Table;
import com.laptrinhjavaweb.repository.mapper.ResultSetMapper;
import com.laptrinhjavaweb.repository.JdbcRepository;
import com.laptrinhjavaweb.utils.ConnectionUtils;
@Repository
public class SimpleJdbcRepository<T> implements JdbcRepository<T>{

	private ResultSetMapper<T> mapper = new ResultSetMapper<>();
	private Class<T> tClass;
	public SimpleJdbcRepository() {
	 tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public List<T> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String tableName = "";
		if(tClass.isAnnotationPresent(Entity.class) && tClass.isAnnotationPresent(Table.class)) {
			Table table = tClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		try {
			conn = ConnectionUtils.getConnection();
			String sql = " select * from " +tableName;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			return mapper.mapRow(rs, tClass);
		} catch ( SQLException | ArithmeticException e) {
			e.printStackTrace(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					conn.close();
				}
				if (rs != null) {
					conn.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
				
			}
		}
		return new ArrayList<>();
	}

	@Override
	public Long insert(Object object) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conn = ConnectionUtils.getConnection();
				conn.setAutoCommit(false);
				StringBuilder sql = createSqlInsert();
				stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				Class<?> zClass = object.getClass();
				Field[] fields = zClass.getDeclaredFields();
				int parameterIndex = 1;
				for(Field field: fields) {
					field.setAccessible(true);
					stmt.setObject(parameterIndex, field.get(object));
					parameterIndex++;
				}
				Class<?> parentClass = tClass.getSuperclass();
				int indexParent = fields.length + 1;
				while(parentClass != null) {
					for(Field field: parentClass.getDeclaredFields()) {
						if(!field.getName().equals("id")) {
							field.setAccessible(true);
							stmt.setObject(indexParent, field.get(object));
							indexParent++;
						}	
					}
					parentClass = parentClass.getSuperclass();
				}
				int flag = stmt.executeUpdate();
				rs = stmt.getGeneratedKeys();
				conn.commit();
				//int rowInserted = stmt.executeUpdate();
				if(flag > 0) {
					while (rs.next()) {
						Long id = rs.getLong(1);
						return id;
					}
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {		
				try {
					conn.rollback();
					if (conn != null) {
						conn.close();
					} 
					if (stmt != null) {
						conn.close();
					}
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {

					e.printStackTrace();
					
				}
			}
			return null;
			
		
	}

	private StringBuilder createSqlInsert() {
		String tableName = "";
		if(tClass.isAnnotationPresent(Entity.class) && tClass.isAnnotationPresent(Table.class)) {
			Table table = tClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		//StringBuilder sql = new StringBuilder("insert into building(name,floorArea, districtid" ) values(?,?,?)");
		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");
		
		for(Field field : tClass.getDeclaredFields())
		{
			if(fields.length() > 1) {
				fields.append(",");
				params.append(",");
			}
			if(field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fields.append(column.name());
				params.append(" ? ");
				
			}
		}
		Class<?> parentClass = tClass.getSuperclass();
		while(parentClass != null) {
			for(Field field : parentClass.getDeclaredFields())
			{
				if(fields.length() > 1) {
					fields.append(",");
					params.append(",");
				}
				if(field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					fields.append(column.name());
					params.append(" ? ");
					
				}
			}
			parentClass = parentClass.getSuperclass();
		}
		StringBuilder sql = new StringBuilder("insert into "+tableName+"("+fields.toString()+" ) values("+fields.toString()+")");
		return null;
	}

	@Override
	public T findById(Long id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String tableName = "";
		if(tClass.isAnnotationPresent(Entity.class) && tClass.isAnnotationPresent(Table.class)) {
			Table table = tClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		try {
			conn = ConnectionUtils.getConnection();
			String sql = " select * from " +tableName+ " where id = "+id;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			List<T> results = mapper.mapRow(rs, tClass);
			return (results.size() > 0) ? results.get(0) : null;
		} catch ( SQLException | ArithmeticException e) {
			e.printStackTrace(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					conn.close();
				}
				if (rs != null) {
					conn.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
				
			}
		}
		return null;
	}

	@Override
	public T update(Object updateObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> findByCondition(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			return mapper.mapRow(rs, tClass);
		} catch ( SQLException | ArithmeticException e) {
			e.printStackTrace(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					conn.close();
				}
				if (rs != null) {
					conn.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
				
			}
		}
		return new ArrayList<>();
	}

	
	

}

