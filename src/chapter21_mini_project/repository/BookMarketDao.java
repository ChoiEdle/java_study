package chapter21_mini_project.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.BookMarketBooksVo;
import chapter21_mini_project.model.BookMarketCartVo;

public class BookMarketDao {
	//Field
	private String url = "jdbc:mysql://localhost:3306/hrdb2019";
	private String user = "root";
	private String password = "mysql1234";
	
	Connection connection;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//Constructor
	public BookMarketDao() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Method
	private void getPreparedStatement(String sql) {
		try {
			pstmt = connection.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public List<BookMarketBooksVo> bookItemList() {
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
	
	public void cartAddItem(BookMarketBooksVo book) {
		List<BookMarketCartVo> list = cartItemList();
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
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BookMarketCartVo> cartItemList() {
		List<BookMarketCartVo> list = new ArrayList<BookMarketCartVo>();
		String sql = "select bid, quantity, total, bdate from book_market_cart";
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
	
	public int cartRemoveItem(String id) {
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
	
	public int cartRemoveItemCount(String id, int no) {
		int rows = 0;
		BookMarketCartVo cart = cartItem(id);
		BookMarketBooksVo book = bookItem(id);
		if(cart != null) {
			String sql = "update book_market_cart set quantity = ?, total = ? where bid = ?";
			try {
				getPreparedStatement(sql);
				pstmt.setInt(1, no);
				pstmt.setInt(2, (no*book.getPrice()));
				pstmt.setString(3, cart.getBid());
				rows = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rows;
	}
	
	public BookMarketCartVo cartItem(String id) {
		List<BookMarketCartVo> list = cartItemList();
		BookMarketCartVo cart = null;
		for(int i=0 ; i<list.size() ; i++) {
			if(list.get(i).getBid().equals(id)) {
				cart = list.get(i);
				break;
			}
		}
		return cart;
	}
	
	public BookMarketBooksVo bookItem(String id) {
		List<BookMarketBooksVo> list = bookItemList();
		BookMarketBooksVo book = null;
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
