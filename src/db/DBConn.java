package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {
	//Field
	private String url = "jdbc:mysql://localhost:3306/hrdb2019";
	private String user = "root";
	private String password = "mysql1234";
	
	Connection connection;
	protected Statement stmt;
	protected ResultSet rs;
	
	//Constructor
	protected DBConn() {
		//1단계
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("----->> 1단계 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method
	//Statement 생성
	public void getStatement() {
		//2단계 : Statement 객체 생성
		try {
			stmt = connection.createStatement();
			System.out.println("----->> 2단계 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return stmt;
	}
	
	//객체 종료 : close
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(connection != null) connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}//class
