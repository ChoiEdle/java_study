package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bookmgm.model.Book;

public class InMemoryBookRepository implements BookRepository {
	//Field
	List<Book> library = new ArrayList<Book>();
	
	//Constructor
	public InMemoryBookRepository() {
		System.out.println("** 교육센터 도서관 생성 완료 **");
	}
	
	//Method
	@Override
	public boolean insert(Book book) {
		if(book != null) {
			return library.add(book);
		} else {
			return false;
		}
	}
	
	@Override
	public List<Book> selectAll(){
		return library;
	}
	
	@Override
	public Book select(String id) {
		Book book = null;
		for(Book b : library) {
			if(b.getId().equals(id)) {
				book = b;
				break;
			}
		}
		return book;
	}
	
	@Override
	public void update(Book book) {
		if(book != null) {
			int idx = -1;
//			for(int i=0; i<library.size(); i++) {		//이건 내가 만든거
//				Book b = library.get(i);
//				if(b.getId().equals(book.getId())) {
//					library.set(i, book);
//					break;
//				}
//			}
			int i = 0;
			for(Book b : library) {
				if(b.getId().equals(book.getId())) {
					idx = i;
				}
				i++;
			}
			library.set(idx, book);
		}
	}
	
	@Override
	public void remove(String id) {
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext()) {
			Book book = ie.next();
			if(book.getId().equals(id)) {
				ie.remove();
			}
		}
	}

	@Override
	public void remove(Book book) {
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext()) {
			Book b = ie.next();
			if(b == book) {
				ie.remove();
			}
		}
	}
	
	@Override
	public int getCount(){
		return library.size();
	}
}
