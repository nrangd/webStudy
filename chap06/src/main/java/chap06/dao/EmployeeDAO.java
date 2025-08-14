package chap06.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap06.dto.Employee;
public class EmployeeDAO {
	Connection conn;
	
	public EmployeeDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Employee> getAll() {
		
		try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
				ResultSet rs = pstmt.executeQuery()){
			List<Employee> emps = new ArrayList<>();

			while (rs.next()) {
				emps.add(new Employee(
							rs.getInt("employee_id"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("email"),
							rs.getString("phone_number"),
							rs.getDate("hire_date"),
							rs.getString("job_id"),
							rs.getDouble("salary"),
							rs.getDouble("commission_pct"),
							rs.getInt("manager_id"),
							rs.getInt("department_id")
						));
			}
			return emps;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
