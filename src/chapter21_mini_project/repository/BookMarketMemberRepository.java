package chapter21_mini_project.repository;

import java.util.List;

import chapter21_mini_project.model.BookMarketMemberVo;
import db.DBConn;

public class BookMarketMemberRepository extends DBConn implements BookMarketRepositoryInterface<BookMarketMemberVo> {
	//Field
	
	//Construct
	
	//Method
	public List<BookMarketMemberVo> itemList() {
		return null;
	}
	
	public void addItem(String id) {
		
	}
	
	public void clear() {
		
	}
	
	public int removeItem(String id) {
		return 0;
	}
	
	public int removeItemCount(String id, int no) {
		return 0;
	}
	
	public BookMarketMemberVo findItem(String id) {
		return null;
	}
	
	public boolean login(String name, String phone) {
		boolean result = false;
		String sql = """
				select name, phone from book_market_member where name = ? and phone = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
			
			result = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
