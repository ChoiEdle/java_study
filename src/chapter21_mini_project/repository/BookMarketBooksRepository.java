package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.BookMarketBooksVo;
import db.DBConn;

public class BookMarketBooksRepository extends DBConn implements BookMarketRepositoryInterface<BookMarketBooksVo> {
	//Field
	
	//Constructor
	
	//Method
	public List<BookMarketBooksVo> itemList() {
		List<BookMarketBooksVo> list = new ArrayList<BookMarketBooksVo>();
		String sql = """
				select bid, title, price, author, detail, uid, bdate
				from book_market_books
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookMarketBooksVo book = new BookMarketBooksVo();
				book.setBid(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setPrice(rs.getInt(3));
				book.setAuthor(rs.getString(4));
				book.setDetail(rs.getString(5));
				book.setUid(rs.getString(6));
				book.setBdate(rs.getString(7));
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public BookMarketBooksVo findItem(String id) {
		List<BookMarketBooksVo> list = itemList();
		BookMarketBooksVo book = null;
		for(int i=0 ; i<list.size() ; i++) {
			if(list.get(i).getBid().equals(id)) {
				book = list.get(i);
				break;
			}
		}
		return book;
	}
	
	public void addItem(BookMarketBooksVo book) {
		
	}
	
	public void clear() {
		String sql = "truncate book_market_books";
		try {
			getPreparedStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int removeItem(String id) {
		int rows = 0;
		String sql = "delete from book_market_books where bid = ?";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int removeItemCount(String id, int no) {
		return 0;
	}
	
	public boolean login(String name, String phone) {
		return false;
	}
	
}
