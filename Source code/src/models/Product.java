package models;

public class Product {
	private int id;
	private String name;
	private int quantity;
	private String description;
	private float price;
	
	public Product() {
		
	}
	
	public Product(Integer id, String name, int quantity, String description, float price) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.price = price;
	}
	
	public Product(String name, int quantity, String description, float price) {
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.price = price;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
