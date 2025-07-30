package chapter20_JDBC;

import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class DepartmentDao extends DBConn {
	//Field

	//Constructor
	public DepartmentDao() {
		super();
	}
	
	//Method
	//3단계 : CRUD 기능에 따라 메소드 생성
	public List<DepartmentVo> getList() {
		List<DepartmentVo> list = new ArrayList<DepartmentVo>();
		String sql = """
				select dept_id, dept_name, unit_id, start_date 
				from department
				""";
		try {
			getStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//rs 객체의 1 row --> EmployeeVo 저장
				DepartmentVo department = new DepartmentVo();
				department.setDeptId(rs.getString(1));
				department.setDeptName(rs.getString(2));
				department.setUnitId(rs.getString(3));
				department.setStartDate(rs.getString(4));

				list.add(department);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		
		
}
