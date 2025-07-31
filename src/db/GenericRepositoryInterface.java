package db;

import java.util.List;

public interface GenericRepositoryInterface<T> {
	boolean insert(T entity);
	int getCount();
	List<T> findAll();
	T find(String no);
	void update(T entity);
	void remove(String no);
}
