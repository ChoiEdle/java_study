package com.bookmgm.repository.before;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bookmgm.model.Book;
import com.bookmgm.repository.BookRepository;

public class AladinBookRepositoryBefore implements BookRepository {
	//Field
	List<Book> library = new ArrayList<Book>();
	
	//Constructor
	public AladinBookRepositoryBefore() {
		System.out.println("** 알라딘 도서관 생성 완료 **");
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
			if(b.getBid().equals(id)) {
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
			int i = 0;
			for(Book b : library) {
				if(b.getBid().equals(book.getBid())) {
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
			if(book.getBid().equals(id)) {
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
