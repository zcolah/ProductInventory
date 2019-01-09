public class Product {
    private final String productId;
    private double price;
    private int quantity;

    Product(String productId, double price) {
        this(productId, price, 0);
    }

    Product(String productId, double price, int quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addStock(int quantity) {
        this.quantity += quantity;
    }

}
