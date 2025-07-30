package chapter20_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDao {
	//Field
	private String url = "jdbc:mysql://localhost:3306/hrdb2019";
	private String user = "root";
	private String password = "mysql1234";
	
	Connection connection;
	Statement stmt;
	ResultSet rs;
	
	//Constructor
	public EmployeeDao() {
		//1, 2단계
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("----->> 1단계 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method
	//2단계 : Statement
	public void getStatement() {
		//2단계 : Statement 객체 생성
		try {
			stmt = connection.createStatement();
			System.out.println("----->> 2단계 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//3단계 : ResultSet
	public ResultSet getResultSet(String sql) {
		try {
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//5단계 : close
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(connection != null) connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}












