package Cafe;
import java.awt.Image;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class CoffeeSystem {

	static Vector <Menu> drink = new Vector<Menu>();
	static Vector <Menu> cake = new Vector<Menu>();
	static Vector <Menu> sandwich = new Vector<Menu>();
	static Vector <Menu> order = new Vector<Menu>();
	static Vector<Integer> price = new Vector<Integer>();
	

	
	static Menu new_drink(String product_name,int price) {
		
		Menu new_drink = new Menu(product_name,price);
		CoffeeSystem.addTodrink(new_drink);	
		return new_drink;
	}
	
	static Menu new_cake(String product_name,int price) {
		
		Menu new_cake = new Menu(product_name,price);
		CoffeeSystem.addTocake(new_cake);				
		return new_cake;
		
	}
	
	static Menu new_sandwich(String product_name,int price) {
		
		Menu new_sandwich = new Menu(product_name,price);
		CoffeeSystem.addTosandwich(new_sandwich);				
		return new_sandwich;
		
	}
	
	
	static Integer new_Price(int price) {
		
		Integer new_Price = new Integer(price);
		CoffeeSystem.addToPrice(new_Price);	
		return new_Price;
	}
	
	static String total_Price(int sum) {
		
		sum=0;
		int m;
		for(int i=0; i<CoffeeSystem.getNumPrices(); i++) {			
			m=CoffeeSystem.getPrice(i);
			sum = sum+m;
	}
		return "총 가격 : "+sum+"원";
	}
	 // 이미지 크기조절하기!
	 static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	       Image img = icon.getImage();  
	       Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	       return new ImageIcon(resizedImage);
	}
	
	 
	 
	private static void addToPrice(Integer new_Price) {
		price.add(new_Price);
		
	}

	
	private static void addTosandwich(Menu new_sandwich) {
		sandwich.add(new_sandwich);
		
	}

	private static void addTocake(Menu new_cake) {
		cake.add(new_cake);
	}

	
	
	private static void addTodrink(Menu new_drink) {
		drink.add(new_drink);
		
	}
	
	static void setupMenu() {
		CoffeeSystem.new_drink("아메리카노", 1500);
		CoffeeSystem.new_drink("카푸치노", 2500);
		CoffeeSystem.new_cake("딸기케이크", 3000);
		CoffeeSystem.new_cake("초코케이크", 3000);
		CoffeeSystem.new_sandwich("햄치즈샌드위치", 4000);
		CoffeeSystem.new_sandwich("누텔라샌드위치", 4000);	
	}
		
	@SuppressWarnings("unused")
	private static void new_Order_drink(Menu new_drink) {
		order.add(new_drink);
	}
	

	static String Customer_order() {
		Menu m;
		
		System.out.println("\n--모든 주문 리스트 --");
				
		for(int i=0; i<CoffeeSystem.getNumOrders(); i++) {
			m=CoffeeSystem.getOrder(i);
			System.out.print(i+1+". ");
			m.output();		
			
		}
		return null;
	
	}
	static Menu getOrder(int witch) {
			
		return order.elementAt(witch);
	}
	static int getNumOrders() {

		return order.size();
	}
	static int getNumPrices() {
		return price.size();
	}
	static Integer getPrice(int witch) {
		return price.elementAt(witch);
	}
	static Integer get_Price(int witch) {
		return price.get(witch);
	}
	
	public static void main(String[] args) {//Test
		Customer_order();
		price.get(1);
	}

	
}
