package com.bookmgm.service;

import java.util.List;
import java.util.Random;

import com.bookmgm.application.BookManagementApplication;
import com.bookmgm.model.Book;
import com.bookmgm.repository.AladinBookRepository;

import db.GenericRepositoryInterface;

public class DefaultBookService implements BookService {
	//Field
	BookManagementApplication bma;
	GenericRepositoryInterface<Book> repository;
	
	//Constructor
	public DefaultBookService() {
		
	}
	
	public DefaultBookService(BookManagementApplication bma) {
		this.bma = bma;
		selectRepository();
//		repository = new InMemoryBookRepository();
	}

	//Method
	/**
	 * 도서 생성
	 */
	public Book createBook() {
		Random rd = new Random();
		Book book = new Book();
		
		book.setIsbn(rd.nextInt(1000,9999));
		
		System.out.println("[도서 등록]");
		System.out.print("도서명 : ");
		book.setTitle(bma.scan.next());
		System.out.print("저자 : ");
		book.setAuthor(bma.scan.next());
		System.out.print("가격 : ");
		book.setPrice(bma.scan.nextInt());
		
		return book;
	}
	
	/**
	 * 도서 생성
	 * @param book - old book 정보
	 * 도서 수정시 도서 정보를 일부 수정하여 반환
	 */
	public Book createBook(Book book) {
		System.out.println("[도서 수정]");
		System.out.print("도서명 : ");
		book.setTitle(bma.scan.next());
		System.out.print("저자 : ");
		book.setAuthor(bma.scan.next());
		System.out.print("가격 : ");
		book.setPrice(bma.scan.nextInt());
		
		return book;
	}
	
	/**
	 * 도서관 선택
	 */
	public void selectRepository() {
		System.out.println("-----------------------------------------");
		System.out.println("1. 교육센터\t2. 알라딘\t3. 예스24");
		System.out.println("-----------------------------------------");
		System.out.println("도서관 선택 > ");
		int rno = bma.scan.nextInt();
		repository = new AladinBookRepository(rno);
//		if(rno == 1) {
//			repository = new InMemoryBookRepository("book_tj");
//		} else if(rno == 2) {
//			repository = new InMemoryBookRepository("book_aladin");
//		} else if(rno == 3) {
//			repository = new InMemoryBookRepository("book_yes24");
//		} else {
//			System.out.println("등록된 도서관이 없습니다.");
//			selectRepository();
//		}
		
	}
	
	@Override
	public void register() {
//		selectRepository();
		Book book = createBook();
		if(repository.insert(book) != 0) {
			//등록 성공
			System.out.println("✅ 도서가 등록되었습니다.");
		} else {
			//등록 실패
			System.out.println("🚫도서가 등록되지 않았습니다.");
		}
		
		bma.showMenu();
	}
	
	/*
	 * >> 메뉴 선택: 2<br>
[도서 목록 조회]<br>
[1234] 자바프로그래밍 - 서민구,  30000 <br>
<br>
	 */
	
	@Override
	public void list() {
		if(getCount() != 0) {
			System.out.println("-----------------------------------------");
			System.out.println("[도서 목록 조회]");
			System.out.println("-----------------------------------------");
			List<Book> library = repository.findAll();
			library.forEach(book -> {		//list라서 forEach 메소드를 사용 할 수 있음
//				System.out.print("[" + book.getBid() + "]\t");
//				System.out.print(book.getTitle() + " - ");
//				System.out.print(book.getAuthor() + ", \t");
//				System.out.print(book.getPrice() + "\t");
//				System.out.print(book.getIsbn() + "\t");
//				System.out.print(book.getBdate() + "\n");
				printBook(book);
			});
//			for(Book list : library) {		//이게 내가 한거
//				System.out.print("[" + list.getId() + "]\t");
//				System.out.print(list.getName() + " - ");
//				System.out.print(list.getAuthor() + ", \t");
//				System.out.print(list.getPrice() + "\n");
//			}
			System.out.println("-----------------------------------------");
		} else {
			System.out.println("🚫 등록된 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
	}
	
	@Override
	public void search() {
		if(getCount() != 0) {
			System.out.println("-----------------------------------------");
			System.out.println("[도서 검색]");
			System.out.println("-----------------------------------------");
			System.out.print("도서번호 > ");
			Book book = repository.find(bma.scan.next());
			if(book != null) {
				System.out.println("-----------------------------------------");
				printBook(book);
				System.out.println("-----------------------------------------");
			} else {
				System.out.println("🚫 검색한 도서가 존재하지 않습니다.");
			}
		} else {
			System.out.println("🚫 등록된 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
	}
	
	/**
	 * 도서 수정
	 */
	@Override
	public void update() {
		if(getCount() != 0) {
			System.out.println("-----------------------------------------");
			System.out.println("[도서 수정]");
			System.out.println("-----------------------------------------");
			System.out.print("도서번호 > ");
			Book book = repository.find(bma.scan.next());
			if(book != null) {
				int rows = repository.update(createBook(book));
				if(rows != 0) {
					System.out.println("✅도서가 수정되었습니다.");
					System.out.println("-----------------------------------------");
					printBook(book);
					System.out.println("-----------------------------------------");
				} else {
					System.out.println("✅도서가 수정 실패.");
				}
			} else {
				System.out.println("🚫 검색한 도서가 존재하지 않습니다.");
			}
		} else {
			System.out.println("🚫 등록된 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
	}
	
	@Override
	public void delete() {
		if(getCount() != 0) {
			System.out.println("-----------------------------------------");
			System.out.println("[도서 삭제]");
			System.out.println("-----------------------------------------");
			System.out.print("도서번호 > ");
			Book book = repository.find(bma.scan.next());
			if(book != null) {
				System.out.println("정말 삭제 하시겠습니까?(y:삭제, 아무키:취소)");
				if(bma.scan.next().equals("y")) {
					repository.remove(book.getBid());
					System.out.println("✅도서가 삭제되었습니다.");
				}
			} else {
				System.out.println("🚫 검색한 도서가 존재하지 않습니다.");
			}
		} else {
			System.out.println("🚫 등록된 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
	}
	
	@Override
	public void exit() {
		System.out.println("✅시스템이 종료됩니다.");
		repository.close();
		System.exit(0);
	}
	
	@Override
	public int getCount() {
		return repository.getCount();
	}
	
	/**
	 * 도서 출력 - 검색, 수정 시 결과 출력
	 * @param book
	 */
	public void printBook(Book book) {
		System.out.print("[" + book.getBid() + "]\t");
		System.out.print(book.getTitle() + " - ");
		System.out.print(book.getAuthor() + ", \t");
		System.out.print(book.getPrice() + "\t");
		System.out.print(book.getIsbn() + "\t");
		System.out.print(book.getBdate() + "\n");
	}
	
	public void libraryChange() {
		repository.close();
		selectRepository();
		bma.showMenu();
	}
}
