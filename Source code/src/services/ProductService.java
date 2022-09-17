package services;

import java.util.InputMismatchException;
import java.util.Scanner;

import console.Main;
import models.Product;
import java.io.File;
import java.io.*;
import java.io.FileOutputStream;
import console.Main;

public class ProductService implements Serializable {
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
			Main.PRODUCTS.add(p);

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
		for (Product p : Main.PRODUCTS) {
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

			for (int i = 0; i < Main.PRODUCTS.size(); i++) {
				if (id.equals(Main.PRODUCTS.get(i).getId())) {

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

					Main.PRODUCTS.get(i).setName(name);
					Main.PRODUCTS.get(i).setQuantity(quantity);
					Main.PRODUCTS.get(i).setDescription(description);
					Main.PRODUCTS.get(i).setPrice(price);

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
		
		for (Product p : Main.PRODUCTS) {
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
