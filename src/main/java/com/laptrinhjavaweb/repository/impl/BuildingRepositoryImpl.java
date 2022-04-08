package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;


import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.utils.BuildingTypeUtils;
import com.laptrinhjavaweb.utils.ConnectionUtils;
import com.laptrinhjavaweb.utils.StringUtils;

@Repository
public  class BuildingRepositoryImpl extends SimpleJdbcRepository<BuildingEntity>  implements BuildingRepository {

	@Override
	public List<BuildingEntity> searchBuilding(Map<String, Object> params, List<String> types) {
		
		List<BuildingEntity> results = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionUtils.getConnection();
			StringBuilder query = buildQuerySerch();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query.toString());
			while (rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setFloorarea(rs.getInt("floorarea"));
				buildingEntity.setStreet(rs.getString("street"));
				buildingEntity.setWard(rs.getString("ward"));
				buildingEntity.setNumberOfBasement(rs.getInt("numberofbasement"));
				buildingEntity.setManagerName(rs.getString("managerName")); 
				buildingEntity.setManagerPhone(rs.getInt("managerPhone"));	
				buildingEntity.setDistrictId(rs.getString("districtid"));
				buildingEntity.setDirection(rs.getString("direction"));
				buildingEntity.setRentprice(rs.getInt("rentprice"));
				buildingEntity.setId(rs.getLong("id"));
				buildingEntity.setLevel(rs.getString("level"));
				 results.add(buildingEntity);
			}
			return results;
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

	private StringBuilder buildQuerySerch() {
		try {
			//BuildingSearchResponse buildingSearchResponse
			BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
			StringBuilder query = new StringBuilder("select A.id, A.name, A.floorarea, A.street, A.ward, A.numberofbasement,A.managerName, A.managerPhone, B.code as districtid , A.direction,A.level, A.rentprice,E.value as rentarea, D.code as type ,C.staffid as staffid ");
			query.append(" from building as A");
			query.append(" LEFT JOIN district as B on A.districtid = B.id");
			query.append(" LEFT JOIN assignmentbuilding as C on A.id = C.buildingid");
			query.append(" LEFT JOIN renttype as D on A.id = D.id ");
			query.append(" LEFT JOIN rentarea as E on A.id = E.buildingid ");
			query.append(" 	GROUP BY A.id ");
			if(buildingSearchResponse.getBuildingTypes().length > 0) {
				query.append("and (B.type like '%"+buildingSearchResponse.getBuildingTypes()+"%')");
				for(String type : buildingSearchResponse.getBuildingTypes()) {
					if(!type.equals(buildingSearchResponse.getBuildingTypes()[0])) {
						query.append("or B.type like '%"+type+"%'");
					}
				}
			}
			return query;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}































	
	/*if (!StringUtils.isNullOrEmpty(name)) {
	query.append(" and name like '%"+name+"%'");
}
if (!StringUtils.isNullOrEmpty(street)) {
	query.append(" and street like '%"+street+"%'");
	
	
}*/
	


/*	private Map<String, Object> mapSearch(BuildingSearchResponse buildingSearchResponse) {
Map<String,Object> result = new HashMap<>();
try {
	Field[] fields = BuildingSearchResponse.class.getDeclaredFields();
	for(Field field: fields) {
		if(!field.getName().equals("type")) {
			
		}
		if(StringUtils.isNotBlank((String) field.get(buildingSearchResponse)));//null or ""
	}
} catch (Exception e) {
	// TODO: handle exception
}
return null;
}
*/
/*public StringBuilder createsql1(BuildingSearchResponse buildingSearchResponse) {
StringBuilder sql2 = new StringBuilder();
if (StringUtils.isNotBlank(buildingSearchResponse.getRentAreaFrom())) {
	sql2.append(" and rentAreaFrom >= " +buildingSearchResponse.getRentAreaFrom());
}
if (StringUtils.isNotBlank(buildingSearchResponse.getRentAreaTo())) {
	sql2.append(" and rentAreaTo <= " +buildingSearchResponse.getRentAreaTo());
}
if(StringUtils.isNotBlank(buildingSearchResponse.getRentAreaFrom()) || StringUtils.isNotBlank(buildingSearchResponse.getRentAreaTo())) {
	sql2.append("and EXISTS (select * from rentarea as R where (R.buildingid = B.id))");
	if (StringUtils.isNotBlank(buildingSearchResponse.getRentAreaFrom())) {
		sql2.append(" and rentAreaFrom >= " +buildingSearchResponse.getRentAreaFrom());
	}
	if (StringUtils.isNotBlank(buildingSearchResponse.getRentAreaTo())) {
		sql2.append(" and rentAreaTo <= " +buildingSearchResponse.getRentAreaTo());
	}
	sql2.append("))");
}
if(buildingSearchResponse.getType().length() > 0) {
	sql2.append("and (B.type like '%"+buildingSearchResponse.getType()+"%')");
	for(String type : buildingSearchResponse.getType()) {
		if(!type.equals(buildingSearchResponse.getType())) {
			sql2.append("or B.type like '%"+type+"%'");
		}
	}
}
return sql2;
}*/
