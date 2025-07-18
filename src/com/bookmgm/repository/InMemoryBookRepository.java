package com.bookmgm.repository;

import java.util.List;

import com.bookmgm.model.Book;

public interface InMemoryBookRepository {
	boolean insert(Book book);
	List<Book> selectAll();
	Book select(String no);
	void update(Book book);
	void remove(String no);
	int getCount();
}
