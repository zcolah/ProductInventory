public class Product {
    private final String productId;
    private double price;
    private int quantityAvailable;

    Product(String productId, double price) {
        this.productId = productId;
        this.price = price;
        this.quantityAvailable = 0;
    }

    public String getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void addStock(int quantity) {
        quantityAvailable += quantity;
    }

    public void removeStock(int quantity) {
        quantityAvailable -= quantity;
    }

}
