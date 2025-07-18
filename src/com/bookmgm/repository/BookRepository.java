package com.bookmgm.repository;

import java.util.List;

import com.bookmgm.model.Book;

public class BookRepository implements InMemoryBookRepository {
	//Field
	
	//Constructor
	
	//Method
	public boolean insert(Book book) {
		return false;
	}
	
	public List<Book> selectAll(){
		return null;
	}
	
	public Book select(String no) {
		return null;
	}
	
	public void update(Book book) {
		
	}
	
	public void remove(String no) {
		
	}
	
	public int getCount(){
		return 0;
	}
	
}
