package services;

import java.util.InputMismatchException;
import java.util.Scanner;

import console.Main;
import models.Order;
import models.OrderDetail;
import models.Product;

public class OrderService {
	public void order() {
		
		Scanner inputs = new Scanner(System.in);
		System.out.println("*******************Order List******************\r\n*input -1 at productID to quit out of buy menu*");
		
		
		try {
			System.out.print("Order ID: ");
			Integer id = inputs.nextInt();

			inputs.nextLine();
			
			System.out.println("Customer Name: ");
			String customerName = inputs.nextLine();
			
			System.out.println("Phone Number: ");
			String phone = inputs.nextLine();
						
			System.out.println("Email: ");
			String email = inputs.nextLine();
			
			Order order = new Order(id, customerName, phone, email);
			
			Integer productId = -1;
			
			while (true) {
				inputs = new Scanner(System.in);
				
				System.out.println("Product ID: ");
				productId = inputs.nextInt();
				
				if (productId.equals(-1)) {
					break;
				}
				
				System.out.println("Quanity: ");
				int quantity = inputs.nextInt();
				
				Product product = null;
				
				for (Product p : Main.PRODUCTS) {
					if (p.getId().equals(productId)) {
						product = p;
						break;
					}
				}
				
				if (product == null) {
					System.out.println("Product ID does not exist");
				}
				
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(1);
				orderDetail.setOrderId(order.getId());
				orderDetail.setPrice(product.getPrice());
				orderDetail.setProductId(productId);
				orderDetail.setQuantity(quantity);
				
				order.getOrderDetails().add(orderDetail);
				
			}
			
			Main.ORDERS.add(order);
			
			
		} catch (InputMismatchException ei) {
			System.out.println("Invalid value! Please check and try again");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void show() {
		System.out.println("Order List");
		String header = String.format("%s%15s%30s%30s", "ID", "CustomerName",
				"Phone Number", "Email");
		System.out.println(header);
		ProductService productService = new ProductService();
		
		for (Order order : Main.ORDERS) {
			String row = String.format("%d%15s%30s%30s", order.getId(), order.getCustomerName(),
					order.getPhone(), order.getEmail());
			System.out.println(row);
			
			String orderDetailHeader = String.format("%30s%10s%30s%30s",
					"Listing ID", "Product Name", "Price", "Quantity");
			System.out.println(orderDetailHeader);
			
			int i = 1;
			for (OrderDetail od : order.getOrderDetails()) {
				
				Product p = productService.getById(od.getProductId());
				
				String orderDetailRow = String.format("%30s%10s%30s%30s",
						i, p.getName(), od.getPrice(), od.getQuantity());
				System.out.println(orderDetailRow);
				i++;
			}
		}
	
	}
}
