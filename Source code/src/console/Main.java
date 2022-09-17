package console;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import models.Order;
import models.Product;
import services.OrderService;
import services.ProductService;


public class Main {
	
	public static List<Product> PRODUCTS = new ArrayList<Product>();
	public static List<Order> ORDERS = new ArrayList<Order>();

	public static void menu() {
		System.out.println("************List of functions************\n"+
				"1. Add Product\n"+
				"2. View product\n"+
				"3. Change product\n"+
				"4. Delete product\n"+
				"5. Buy product\n"+
				"6. View shopping cart\n"+
				"7. Exit");

	}

	public static void main(String[] args) {
		System.out.println("COSC2081 GROUP ASSIGNMENT \n" +
				"STORE ORDER MANAGEMENT SYSTEM \n" +
				"Instructor: Mr. Minh Vu \n" +
				"Group: Group19 \n"+
				"s3836276, Tran Quang Anh\n"+
				"s3929256, Pham Minh Hoa\n"+
				"s3790421, Chau The Kien");
		Product p1 = new Product(1, "Asus", 5, "Vivobook 15X", 600);
		Main.PRODUCTS.add(p1);
		Product p2 = new Product(2, "Lenovo", 15, "Legion 5", 1300);
		Main.PRODUCTS.add(p2);
		Product p3 = new Product(3, "Dell", 20, "Inspiron", 900);
		Main.PRODUCTS.add(p3);
		
		

		int function = 0;
		
		do {
			menu();
			Scanner inputs = new Scanner(System.in);
			try {
				System.out.print("Please pick a function: ");
				function = inputs.nextInt();
				ProductService productService = new ProductService();
				OrderService orderService = new OrderService();
				
				switch (function) {
				case 1:
					productService.insert();
					break;
				case 2:
					productService.show();
					break;
				case 3:
					productService.update();
					break;
				case 4:
					productService.removeProduct();
					break;
				case 5:
					orderService.order();
					break;
				case 6:
					orderService.show();
					break;

				default:
					break;
				}
			} catch (InputMismatchException ei) {
				System.out.println("Invalid input! Please try again");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} while (function != 7);

		System.out.println("Good Bye!");

	}
}
