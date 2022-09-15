package Programming1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import models.Order;
import models.Product;
import services.OrderService;
import services.ProductService;

public class App {
	
	public static List<Product> PRODUCTS = new ArrayList<Product>();
	public static List<Order> ORDERS = new ArrayList<Order>();

	public static void menu() {
		System.out.println("------------------Function List------------------------");
		System.out.println("1. Add new products");
		System.out.println("2. View products");
		System.out.println("3. Change product");
		System.out.println("4. Delete product");
		System.out.println("5. Add product to cart");
		System.out.println("6. Check out cart");
		System.out.println("7. Exit.");
	}

	public static void main(String[] args) {
		
		for (int i = 0; i < 4; i++) {
			Float price = (float) (i + 4);
			Product p = new Product(i + 1, "SP " + (i + 1), 1,
					"Description"  + (i + 1), price);
			
			App.PRODUCTS.add(p);
		}
		
		int function = 0;
		
		do {
			menu();
			Scanner inputs = new Scanner(System.in);
			try {
				System.out.print("Select function: ");
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