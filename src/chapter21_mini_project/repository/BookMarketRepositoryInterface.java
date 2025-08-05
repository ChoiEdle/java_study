package chapter21_mini_project.repository;

import java.util.List;

import chapter21_mini_project.model.BookMarketBooksVo;

public interface BookMarketRepositoryInterface<T> {
	List<T> itemList();
	void addItem(BookMarketBooksVo book);
	void clear();
	int removeItem(String id);
	int removeItemCount(String id, int no);
	T findItem(String id);
	boolean login(String name, String phone);
	void close();
}
