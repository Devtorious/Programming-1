package services;

import java.util.InputMismatchException;
import java.util.Scanner;

import Programming1.App;
import models.Product;

public class ProductService {
	public void insert() {
		Scanner inputs = new Scanner(System.in);
		System.out.println("Adding Product Information:");

		try {
			System.out.print("Product ID: ");
			int id = inputs.nextInt();

			inputs.nextLine();

			System.out.println("Product Name: ");
			String name = inputs.nextLine();

			System.out.println("Quantity: ");
			int quantity = inputs.nextInt();

			inputs.nextLine();

			System.out.println("Description:");
			String description = inputs.nextLine();

			System.out.println("Price:");
			Float price = inputs.nextFloat();

			Product p = new Product(id, name, quantity, description, price);
			App.PRODUCTS.add(p);

		} catch (InputMismatchException ei) {
			System.out.println("Invalid value! Please check and try again");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void show() {
		System.out.println("Product List");
		String header = String.format("%s%15s%30s%15s%15s", "ID", "Name", "Quantity", "Price", "Description");
		System.out.println(header);
		for (Product p : App.PRODUCTS) {
			String row = String.format("%d%15s%30d%15f%15s", p.getId(), p.getName(), p.getQuantity(), p.getPrice(),
					p.getDescription());
			System.out.println(row);
		}

	}

	public void update() {
		Scanner inputs = new Scanner(System.in);

		try {
			System.out.println("Product ID: ");
			Integer id = inputs.nextInt();
			Product product = null;

			for (Product p : App.PRODUCTS) {
				if (p.getId().equals(id)) {
					product = p;
					break;
				}
			}

			if (product == null) {
				System.out.println("Invalid ID! Please check and try again");
			}

			System.out.println("Product Info");
			String row = String.format("%d%15s%30d%15f%15s", product.getId(), product.getName(), product.getQuantity(),
					product.getPrice(), product.getDescription());
			System.out.println(row);

			for (int i = 0; i < App.PRODUCTS.size(); i++) {
				if (id.equals(App.PRODUCTS.get(i).getId())) {

					inputs.nextLine();

					System.out.println("Name: ");
					String name = inputs.nextLine();

					System.out.println("Quantity: ");
					int quantity = inputs.nextInt();

					inputs.nextLine();

					System.out.println("Description: ");
					String description = inputs.nextLine();

					System.out.println("Price: ");
					Float price = inputs.nextFloat();

					App.PRODUCTS.get(i).setName(name);
					App.PRODUCTS.get(i).setQuantity(quantity);
					App.PRODUCTS.get(i).setDescription(description);
					App.PRODUCTS.get(i).setPrice(price);

				}
			}

		} catch (InputMismatchException ei) {
			System.out.println("Invalid Input! Please Check and try again");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Product getById(int id) {
		Product product = new Product();
		
		for (Product p : App.PRODUCTS) {
			if (p.getId().equals(id)) {
				product = p;
				break;
			}
		}
		return product;
	}
	public void removeProduct() {
		Scanner inputs = new Scanner(System.in);

		try {
			System.out.println("Product ID: ");
			Integer id = inputs.nextInt();
			Product product = null;

			for (Product p : Main.PRODUCTS) {
				if (p.getId().equals(id)) {
					product = p;
					break;
				}
			}

			if (product == null) {
				System.out.println("Invalid ID! Please check and try again");
			}

			System.out.println("Product Info");
			String row = String.format("%d%15s%30d%15f%15s", product.getId(), product.getName(), product.getQuantity(),
					product.getPrice(), product.getDescription());
			System.out.println(row);
			
			for (int i = Main.PRODUCTS.size() - 1; i >= 0 ; i--) {
				if (id.equals(Main.PRODUCTS.get(i).getId())) {
					Main.PRODUCTS.remove(i);
				}
			}

		} catch (InputMismatchException ei) {
			System.out.println("Invalid Input! Please Check and try again");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
