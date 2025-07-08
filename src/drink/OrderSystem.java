package drink;

public class OrderSystem {
	//Field
	String[] names = {"☕ 아메리카노", "🍵 바닐라 라떼", "🥤 딸기 쉐이크"};
	int[] price = {2800, 3500, 4000};
	Menu[] menuList = new Menu[names.length];
	
	
	//Constructor
	public OrderSystem() {
		init();
	}
	
	//Method
	public void init() {
		createMenuList();
		showMenu();
	}
	
	//메뉴 생성
	public void createMenuList() {
		for(int i=0; i<names.length; i++) {
			Menu menu = new Menu((i+1),names[i],price[i]);
			menuList[i] = menu;
		}
	}
	
	//메뉴 보여주기
	public void showMenu() {
		for(Menu menu : menuList) {
			System.out.println(menu.no + ".\t" + menu.name + "\t" + menu.price);
		}
	}
	
	
}
