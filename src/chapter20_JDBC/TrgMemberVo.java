package chapter20_JDBC;

public class TrgMemberVo {
	//Field
	int rno;
	String mid;
	String name;
	String mdate;
	
	//Constructor
	
	//Method
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	
}
/*
mid	varchar(10)
name	varchar(10)
mdate	date
*/
