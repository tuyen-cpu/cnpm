package model;

public class Product {
    private String namePro;
    private double price;
    private int quantity;
    private String brand;
    private String descriptions;

    public Product(String namePro, double price, int quantity, String brand, String descriptions) {
        this.namePro = namePro;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.descriptions = descriptions;
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
