package pl.gornik.model;

public class Product {
    private String title;
    private int quantity;
    private double price;

    public Product(String title, int quantity, double price) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayProduct(){
        System.out.print("Nazwa: " + title + ", Ilość: " + quantity + ", Cena: " + price );
    }

    public void displayBasketProduct(){
        System.out.print( title + ", Ilość sztuk: " + quantity + "\n");
    }

    public double countPrice(){
        return quantity * price;
    }


}
