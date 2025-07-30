package chapter20_JDBC;

import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class TrgMemberDao extends DBConn {
	//Field
	
	//Constructor
	public TrgMemberDao() {
		super();
	}
	
	//Method
	//삭제(혼자만듬)
	public boolean delete(String mid) {
		boolean result = false;
		String sql = """
				delete from trg_member
				where mid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, mid);
			
			int rows = pstmt.executeUpdate();
			if(rows == 1) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean insert(TrgMemberVo trgmember) {
		boolean result = false;
		String sql = """
				insert into trg_member(mid, name, mdate)
				values(?, ?, curdate())
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, trgmember.getMid());
			pstmt.setString(2, trgmember.getName());
			
			int rows = pstmt.executeUpdate();
			if(rows == 1) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<TrgMemberVo> getListAll() {
		List<TrgMemberVo> list = new ArrayList<TrgMemberVo>();
		String sql = """
				select row_number() over() as rno, mid, name, mdate 
				from trg_member
				""";
		try {
			getStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//rs 객체의 1 row --> EmployeeVo 저장
				TrgMemberVo trg = new TrgMemberVo();
				trg.setRno(rs.getInt(1));
				trg.setMid(rs.getString(2));
				trg.setName(rs.getString(3));
				trg.setMdate(rs.getString(4));

				list.add(trg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
}
