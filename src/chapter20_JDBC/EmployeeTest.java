package chapter20_JDBC;

import java.sql.ResultSet;

public class EmployeeTest {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		dao.getStatement();
		ResultSet rs = dao.getResultSet("select emp_id, emp_name from employee");
		try {
			while(rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//main
}
