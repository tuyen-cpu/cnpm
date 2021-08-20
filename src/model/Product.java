package model;

public class Product {
	private int id;
    private String namePro;
    private double price;
    private int quantity;
    private String brand;
    private String descriptions;
	public Product(int id, String namePro, double price, int quantity, String brand, String descriptions) {
		super();
		this.id = id;
		this.namePro = namePro;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.descriptions = descriptions;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamePro() {
		return namePro;
	}
	public void setNamePro(String namePro) {
		this.namePro = namePro;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
   
    

    
}
