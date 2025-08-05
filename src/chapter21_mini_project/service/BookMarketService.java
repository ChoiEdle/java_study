package chapter21_mini_project.service;

import java.util.List;

import chapter21_mini_project.application.BookMarketApplication;
import chapter21_mini_project.model.BookVo;
import chapter21_mini_project.model.CartVo;
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
	public void menuGuestInfo() {
		System.out.println("현재 고객 정보 : ");
		System.out.println("이름 " + app.getUserName() + "\t연락처 " + app.getUserPhone());
	}
	
	public void menuCartItemList() {
		List<CartVo> list = repository.cartItemList();
		System.out.println("------------------------------------------------");
		System.out.println("도서ID\t\t|\t수량\t|\t합계");
		list.forEach(cartList -> {
			System.out.print(cartList.getBid() +  "\t|\t");
			System.out.print(cartList.getQuantity() +  "\t|\t");
			System.out.print(cartList.getTotalPrice() +  " \n");
		});
		System.out.println("------------------------------------------------");
		int totalPrice = 0;
		for(int i=0 ; i<list.size() ; i++) {
			totalPrice += list.get(i).getTotalPrice();
		}
		System.out.println("주문 총 금액 : " + totalPrice + "원");
		System.out.println();
		System.out.println("------------------------------------------------");
	}
	
	public void menuCartClear() {
		System.out.print("장바구니에 모든 항목을 삭제하겠습니까? Y | N");
		String anser = app.scan.next();
		if(anser.equals("Y")) {
			System.out.println("장바구니에 모든 항목을 삭제했습니다.");
			repository.cartClear();
		} else if(anser.equals("N")) {
			System.out.println("취소하셨습니다.");
		} else {
			System.out.println("잘못 누르셨습니다.");
		}
	}
	
	public void menuCartAddItem() {
		List<BookVo> list = repository.bookItemList();
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
			String anser = app.scan.next();
			if(anser.equals("Y")) {
				repository.cartAddItem(addBook);
				System.out.println(addBook.getBid() + " 도서가 장바구니에 추가되었습니다.");
			} else if(anser.equals("N")) {
				System.out.println("취소하셨습니다.");
			} else {
				System.out.println("잘못 누르셨습니다.");
			}
		}
		
	}
	
	public void menuCartRemoveItemCount() {
		menuCartItemList();
		System.out.print("장바구니에서 수량을 변경할 도서의 ID를 입력하세요 : ");
		String scanId = app.scan.next();
		
		System.out.print("장바구니의 수량을 변경하겠습니까? Y | N");
		String anser = app.scan.next();
		if(anser.equals("Y")) {
			System.out.print("변경하실 수량은? ");
			int scanNo = app.scan.nextInt();
			repository.cartRemoveItemCount(scanId, scanNo);
		} else if(anser.equals("N")) {
			System.out.println("취소하셨습니다.");
		} else {
			System.out.println("잘못 누르셨습니다.");
		}
	}
	
	public void menuCartRemoveItem() {
		menuCartItemList();
		System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요 : ");
		String scanId = app.scan.next();
		System.out.print("장바구니의 항목을 삭제하겠습니까? Y | N");
		String anser = app.scan.next();
		if(anser.equals("Y")) {
			repository.cartRemoveItem(scanId);
			System.out.println(scanId + " 장바구니에서 도서가 삭제되었습니다.");
		} else if(anser.equals("N")) {
			System.out.println("취소하셨습니다.");
		} else {
			System.out.println("잘못 누르셨습니다.");
		}
	}
	
	public void menuCartBill() {
		System.out.print("배송받을 분은 고객정보와 같습니까? Y | N ");
		String anser = app.scan.next();
		if(anser.equals("Y")) {
			System.out.print("배송지를 입력해주세요 ");
			String adress = app.scan.next();
			System.out.println("----------------배송 받을 고객 정보-----------------");
			System.out.println("고객명 : " + app.getUserName() + "\t\t연락처 : " + app.getUserPhone());
			System.out.println("배송지 : " + adress + "\t발송일 : " + app.now);
			System.out.println("장바구니 상품 목록 : ");
			menuCartItemList();
		} else if(anser.equals("N")) {
			System.out.print("배송받을 고객명을 입력하세요 ");
			String name = app.scan.next();
			System.out.print("배송받을 고객의 연락처를 입력하세요 ");
			String phone = app.scan.next();
			System.out.print("배송받을 고객의 배송지를 입력해주세요 ");
			String adress = app.scan.next();
			System.out.println("----------------배송 받을 고객 정보-----------------");
			System.out.println("고객명 : " + name + "\t\t연락처 : " + phone);
			System.out.println("배송지 : " + adress + "\t발송일 : " + app.now);
			System.out.println("장바구니 상품 목록 : ");
			menuCartItemList();
		} else {
			System.out.println("잘못 누르셨습니다.");
		}
	}
	
	public void menuExit() {
		System.out.println("프로그램을 종료합니다.");
		repository.close();
	}
	
	public boolean login(String name, String phone) {
		boolean result = repository.login(name, phone);
		return result;
	}
}
