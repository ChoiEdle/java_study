package drink;

public class Menu {
	//Field
	String name;
	int price;
	int no;
	
	//Constructor
	public Menu() {
	}
	public Menu(int no, String name, int price) {
		this.no = no;
		this.name = name;
		this.price = price;
	}
	
	//Method
	public String getName() {
		return name;
	}
	
	public int getNo() {
		return no;
	}
	
	public int getPrice() {
		return price;
	}
	
}
