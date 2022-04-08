package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.repository.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.CustomerRepository;

public class CustomerRepositoryImpl extends SimpleJdbcRepository<CustomerEntity> implements CustomerRepository{
	/*@Override
	public List<CustomerEntity> findAll() {
		List<CustomerEntity> results = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionUtils.getConnection();
			StringBuilder sql = new StringBuilder();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			while (rs.next()) {
				CustomerEntity customer = new CustomerEntity();
				customer.setFullName(rs.getString("fullname"));
				customer.setPhone(rs.getString("phone"));
				results.add(customer);
			}
		} catch (SQLException | ArithmeticException e) {
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
		return results;
	}

	@Override
	public void insert(CustomerEntity newCustomer) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionUtils.getConnection();
			StringBuilder sql = new StringBuilder("insert into customer(fullname, phone) values(?,?)");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, newCustomer.getFullName());
			stmt.setString(2, newCustomer.getPhone());
			stmt.executeUpdate();
		} catch (SQLException | ArithmeticException e) {
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
			} catch (SQLException e) {

				e.printStackTrace();
				
			}
		}
	}
*/
}
