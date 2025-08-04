package chapter21_mini_project.service;

import java.util.List;

import chapter21_mini_project.application.BookMarketApplication;
import chapter21_mini_project.model.BookVo;
import chapter21_mini_project.repository.BookMarketDao;

public class BookMarketService {
	//Field
	BookMarketApplication app;
	BookMarketDao repository;
	
	//Constructor
	public BookMarketService(BookMarketApplication app) {
		this.app = app;
		repository = new BookMarketDao();
		
	}
	
	//Method
	public void info() {
		System.out.println("현재 고객 정보 : ");
		System.out.println("이름 " + app.getUserName() + "연락처 " + app.getUserPhone());
	}
	
	public void showCart() {
		
	}
	
	public void deleteAll() {
		
	}
	
	public void add() {
		List<BookVo> list = repository.bookFindAll();
		BookVo addBook = null;
		list.forEach(book -> {
			System.out.print(book.getBid() +  " | ");
			System.out.print(book.getTitle() +  " | ");
			System.out.print(book.getPrice() +  " | ");
			System.out.print(book.getAuthor() +  " | ");
			System.out.print(book.getDetail() +  " | ");
			System.out.print(book.getUid() +  " | ");
			System.out.println(book.getBdate() +  " | ");
		});
		System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 : ");
		String scanId = app.scan.next();
		for(int i=0 ; i < list.size() ; i++) {
			if(list.get(i).getBid().equals(scanId)) {
				addBook = list.get(i);
				break;
			}
		}
		if(addBook != null) {
			System.out.print("장바구니에 추가하겠습니까? Y | N");
			if(app.scan.next().equals("Y")) {
				repository.addCart(addBook);
				System.out.println(addBook.getBid() + " 도서가 장바구니에 추가되었습니다.");
			} 
		}
		
	}
	
	public void down() {
		
	}
	
	public void delete() {
		
	}
	
	public void receipt() {
		
	}
	
	public void exit() {
		
	}
	
}
