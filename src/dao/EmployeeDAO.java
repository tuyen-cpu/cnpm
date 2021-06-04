package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectDB;
import model.Employee;

public class EmployeeDAO {
	public boolean insert(Employee employee) {
		Connection connection = null;
		try {
			connection = ConnectDB.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO Employee VALUES ( ?, ?, ?,?)");
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getPhoneNum());
			stmt.setString(3, employee.getAddress());
			stmt.setString(4, employee.getUserName());
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		return true;
	}

}
