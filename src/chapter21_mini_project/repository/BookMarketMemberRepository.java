package chapter21_mini_project.repository;

import db.DBConn;

public class BookMarketMemberRepository extends DBConn implements BookMarketLoginInterface {
	//Field
	
	//Construct
	
	//Method
//	public List<BookMarketMemberVo> itemList() {
//		List<BookMarketMemberVo> list = new ArrayList<BookMarketMemberVo>();
//		String sql = """
//				select name, phone
//				from book_market_member
//				""";
//		try {
//			getPreparedStatement(sql);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				BookMarketMemberVo member = new BookMarketMemberVo();
//				member.setName(rs.getString(1));
//				member.setPhone(rs.getString(2));
//				
//				list.add(member);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//	
//	public void addItem(BookMarketBooksVo book) {
//		
//	}
//	
//	public void clear() {
//		String sql = "truncate book_market_member";
//		try {
//			getPreparedStatement(sql);
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public int removeItem(String name) {
//		int rows = 0;
//		String sql = "delete from book_market_member where name = ?";
//		try {
//			getPreparedStatement(sql);
//			pstmt.setString(1, name);
//			rows = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return rows;
//	}
//	
//	public BookMarketMemberVo findItem(String id) {
//		List<BookMarketMemberVo> list = itemList();
//		BookMarketMemberVo member = null;
//		for(int i=0 ; i<list.size() ; i++) {
//			if(list.get(i).getName().equals(id)) {
//				member = list.get(i);
//				break;
//			}
//		}
//		return member;
//	}
//	
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
	
	public int removeItemCount(String id, int no) {
		return 0;
	}
}
