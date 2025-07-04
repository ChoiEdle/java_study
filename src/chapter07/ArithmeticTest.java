package chapter07;

public class ArithmeticTest {

	public static void main(String[] args) {
		Arithmetic arithmetic = new Arithmetic();
		ArithmeticOverloading arithmetic_ol = new ArithmeticOverloading();
		
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add(10, 20));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add(3.14, 1.5));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add("100", "200"));
		System.out.println("------------------------------------------");
		int add = arithmetic.add(10.7, 20.8);
		int sub = arithmetic.sub(20, 30);
		double mul = arithmetic.mul(3.24, 10);
		int div = arithmetic.div(10, 20);
		int mod = arithmetic.mod(10, 20);
		
		System.out.println("add = " + add);
		System.out.println("sub = " + sub);
		System.out.println("mul = " + mul);
		System.out.println("div = " + div);
		System.out.println("mod = " + mod);
	}

}
