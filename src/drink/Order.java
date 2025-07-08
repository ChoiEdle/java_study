package drink;

public class Order {
	//Field
	Menu orderMenu;
	
	//Constructor
	public Order() {
	}
	public Order(Menu orderMenu) {
		this.orderMenu = orderMenu;
	}
	
	//Method
	public String getName() {
		return orderMenu.name;
	}
	public int getTotal() {
		return orderMenu.price;
	}
	
	
}
