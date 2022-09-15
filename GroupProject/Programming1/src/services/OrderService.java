package services;

import java.util.InputMismatchException;
import java.util.Scanner;

import Programming1.App;
import models.Order;
import models.OrderDetail;
import models.Product;

public class OrderService {
	public void order() {
		
		Scanner inputs = new Scanner(System.in);
		System.out.println("-------------------Product order----------------");
		
		
		try {
			System.out.print("Order ID: ");
			int id = inputs.nextInt();
			
			inputs.nextLine();
			
			System.out.println("Customer name: ");
			String customerName = inputs.nextLine();
			
			System.out.println("Customer Number: ");
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
				
				System.out.println("Quantity: ");
				int quantity = inputs.nextInt();
				
				Product product = null;
				
				for (Product p : App.PRODUCTS) {
					if (p.getId().equals(productId)) {
						product = p;
						break;
					}
				}
				
				if (product == null) {
					System.out.println("Invalid prouct!");
				}
				
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(1);
				orderDetail.setOrderId(order.getId());
				orderDetail.setPrice(product.getPrice());
				orderDetail.setProductId(productId);
				orderDetail.setQuantity(quantity);
				
				order.getOrderDetails().add(orderDetail);
				
			}
			
			App.ORDERS.add(order);
			
			
		} catch (InputMismatchException ei) {
			System.out.println("Invalid value! Please check and try again");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void show() {
		System.out.println("Order Listing");
		String header = String.format("%s%15s%30s%30s", "ID", "Customer name",
				"Phone number", "Email");
		System.out.println(header);
		ProductService productService = new ProductService();
		
		for (Order order : App.ORDERS) {
			String row = String.format("%d%15s%30s%30s", order.getId(), order.getCustomerName(),
					order.getPhone(), order.getEmail());
			System.out.println(row);
			
			String orderDetailHeader = String.format("%30s%10s%30s%30s",
					"Order list", "Product name", "Price", "Quantity");
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