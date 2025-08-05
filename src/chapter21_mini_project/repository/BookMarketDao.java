package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.BookVo;
import chapter21_mini_project.model.CartVo;
import db.DBConn;

public class BookMarketDao extends DBConn {
	//Field
	
	//Constructor
	
	
	//Method
	public List<BookVo> bookItemList() {
		List<BookVo> list = new ArrayList<BookVo>();
		String sql = """
				select bid, title, price, author, detail, uid, bdate
				from book_market_books
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVo book = new BookVo();
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
	
	public void cartAddItem(BookVo book) {
		List<CartVo> list = cartItemList();
		String sql = "";
		if(list.size() == 0) {
			sql = "insert into book_market_cart(bid, quantity, total, bdate) "
					+ " values('" + book.getBid() +"', 1 , " + book.getPrice() + ", curdate())";
			
		} else {
			for(int i=0 ; i<list.size() ; i++) {
				if(list.get(i).getBid().equals(book.getBid())) {
					sql = "update book_market_cart " +
							" set quantity = " + (list.get(i).getQuantity() + 1) + " , total = " + ((list.get(i).getQuantity() + 1)*book.getPrice()) + 
							" where bid = '" + list.get(i).getBid() + "'";
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
	
	public void cartClear() {
		String sql = "truncate book_market_cart";
		try {
			getPreparedStatement(sql);
			pstmt.executeLargeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<CartVo> cartItemList() {
		List<CartVo> list = new ArrayList<CartVo>();
		String sql = "select bid, quantity, total, bdate from book_market_cart";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartVo cart = new CartVo();
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
	
	public void cartRemoveItem(String id) {
		String sql = "delete from book_market_cart where bid = ?";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cartRemoveItemCount(String id, int no) {
		CartVo cart = cartItem(id);
		BookVo book = bookItem(id);
		if(cart != null) {
			String sql = "update book_market_cart set quantity = ?, total = ? where bid = ?";
			try {
				getPreparedStatement(sql);
				pstmt.setInt(1, no);
				pstmt.setInt(2, (no*book.getPrice()));
				pstmt.setString(3, cart.getBid());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(id + " 장바구니에서 도서의 수량이 수정되었습니다.");
		} else {
			System.out.println(id + "는 장바구니에 없습니다.");
		}
	}
	
	public CartVo cartItem(String id) {
		List<CartVo> list = cartItemList();
		CartVo cart = null;
		for(int i=0 ; i<list.size() ; i++) {
			if(list.get(i).getBid().equals(id)) {
				cart = list.get(i);
				break;
			}
		}
		return cart;
	}
	
	public BookVo bookItem(String id) {
		List<BookVo> list = bookItemList();
		BookVo book = null;
		for(int i=0 ; i<list.size() ; i++) {
			if(list.get(i).getBid().equals(id)) {
				book = list.get(i);
				break;
			}
		}
		return book;
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
