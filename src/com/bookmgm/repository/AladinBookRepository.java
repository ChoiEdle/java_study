package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.List;

import com.bookmgm.model.Book;

import db.DBConn;
import db.GenericRepositoryInterface;

public class AladinBookRepository extends DBConn implements GenericRepositoryInterface<Book> {
	//Field
	String tableName;
	public static final String TJ = "book_tj";
	public static final String ALADIN = "book_aladin";
	public static final String YES24 = "book_yes24";
	
	//Constructor
	public AladinBookRepository(int rno) {
		super();
		createTitle(rno);
	}
	
	//Method
	public void createTitle(int rno) {
		String name = null;
		if(rno == 1) {
			name = "교육센터";
			tableName = TJ;
		}
		else if(rno == 2) {
			name = "알라딘";
			tableName = ALADIN;
		}
		else if(rno == 3) {
			name = "예스24";
			tableName = YES24;
		}
		System.out.println("** " + name + " 도서관 생성 완료 **");
	}
	
	public int insert(Book book) {
		int rows = 0;
		String sql = "insert into " + tableName + "(title, author, price, isbn, bdate) "
				+ " values(?, ?, ?, ?, curdate())";
		try {
			getPreparedStatement(sql);
//			pstmt.setString(1, tableName);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setInt(4, book.getIsbn());
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int getCount() {
		int rows = 0;
		String sql = "select count(*) as count from " + tableName;
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rows = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public List<Book> findAll() {
		List<Book> list = null;
		String sql = "select row_number() over() as rno, bid, title, author, isbn, price, bdate "
				+ " from " + tableName;
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			if(rs != null) {
				list = new ArrayList<Book>();
				while(rs.next()) {
					Book book = new Book();
					book.setRno(rs.getInt(1));
					book.setBid(rs.getString(2));
					book.setTitle(rs.getString(3));
					book.setAuthor(rs.getString(4));
					book.setIsbn(rs.getInt(5));
					book.setPrice(rs.getInt(6));
					book.setBdate(rs.getString(7));
					
					list.add(book);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Book find(String bid) {
		Book book = null;
		String sql = "select bid, title, author, isbn, price, bdate "
				+ " from " + tableName + " where bid = ?";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setBid(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setIsbn(rs.getInt(4));
				book.setPrice(rs.getInt(5));
				book.setBdate(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  book;
	}
	
	public int update(Book book) {
		int rows = 0;
		String sql = "update " + tableName + " set title = ?, author = ?, price = ? "
				+ " where bid = ?";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getBid());
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public int remove(String bid) {
		int rows = 0;
		String sql = "delete from " + tableName + " where bid = ?";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, bid);
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
}
