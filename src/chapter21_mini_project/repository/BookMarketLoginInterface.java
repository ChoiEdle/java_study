package chapter21_mini_project.repository;

public interface BookMarketLoginInterface {
	boolean login(String name, String phone);
	void close();
}
