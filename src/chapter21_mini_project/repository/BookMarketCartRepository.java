package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.BookMarketBooksVo;
import chapter21_mini_project.model.BookMarketCartVo;
import db.DBConn;

public class BookMarketCartRepository extends DBConn implements BookMarketRepositoryInterface<BookMarketCartVo> {
	//Field
	
	//Constructor
	
	//Method
	public void addItem(BookMarketBooksVo book) {
		List<BookMarketCartVo> list = itemList();
		String sql = "";
		if(list.size() == 0) {
			sql = "insert into book_market_cart(bid, quantity, total, bdate) "
					+ " values('" + book.getBid() +"', 1 , " + book.getPrice() + ", curdate())";
			
		} else {
			for(int i=0 ; i<list.size() ; i++) {
				if(list.get(i).getBid().equals(book.getBid())) {
					sql = "update book_market_cart " +
							" set quantity = " + (list.get(i).getQuantity() + 1) + " , total = "
							+ ((list.get(i).getQuantity() + 1)*book.getPrice())
							+ " where bid = '" + list.get(i).getBid() + "'";
					break;
				} else {
					sql = "insert into book_market_cart(bid, quantity, total, bdate) "
							+ " values('" + book.getBid() +"', 1 , " + book.getPrice() + ", curdate())";
				}
			}
		}
		try {
			getPreparedStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clear() {
		String sql = "truncate book_market_cart";
		try {
			getPreparedStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BookMarketCartVo> itemList() {
		List<BookMarketCartVo> list = new ArrayList<BookMarketCartVo>();
		String sql = """
				select bid, quantity, total, bdate
				from book_market_cart 
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookMarketCartVo cart = new BookMarketCartVo();
				cart.setBid(rs.getString(1));
				cart.setQuantity(rs.getInt(2));
				cart.setTotalPrice(rs.getInt(3));
				cart.setBdate(rs.getString(4));
				
				list.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int removeItem(String id) {
		int rows = 0;
		String sql = "delete from book_market_cart where bid = ?";
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
		int rows = 0;
		BookMarketCartVo cart = findItem(id);
		if(cart != null) {
			String sql = "update book_market_cart set quantity = ?, total = ? where bid = ?";
			try {
				getPreparedStatement(sql);
				pstmt.setInt(1, no);
				pstmt.setInt(2, (no*(cart.getTotalPrice()/cart.getQuantity())));
				pstmt.setString(3, cart.getBid());
				rows = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rows;
	}
	
	public BookMarketCartVo findItem(String id) {
		List<BookMarketCartVo> list = itemList();
		BookMarketCartVo cart = null;
		for(int i=0 ; i<list.size() ; i++) {
			if(list.get(i).getBid().equals(id)) {
				cart = list.get(i);
				break;
			}
		}
		return cart;
	}
	
//	public boolean login(String name, String phone) {
//		boolean result = false;
//		return result;
//	}
}
