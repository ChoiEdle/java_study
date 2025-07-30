package chapter20_JDBC;

public class DepartmentVo {
	//Field
	int rno;
	String deptId;
	String deptName;
	String unitId;
	String startDate;
	
	//Constructor
	
	
	//Method
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
}

/*
dept_id	char(3)
dept_name	varchar(10)
unit_id	char(1)
start_date	date
 */
