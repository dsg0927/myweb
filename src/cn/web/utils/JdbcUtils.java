package cn.web.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class JdbcUtils {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/dsg", "root", "dsg1234");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
	}

}
